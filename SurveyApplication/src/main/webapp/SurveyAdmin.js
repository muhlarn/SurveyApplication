var answers = [];
var updatedQuestionIndex = 0;

function getAllQuestion() {
    jQuery.ajax({
        url: "http://localhost:8080/SurveyApplication/resources/questions/",
        type: "GET",
        contentType: 'application/json; charset=utf-8',
        success: function(resultData) {
            localStorage["questions"] = JSON.stringify(resultData);
            getAllQuestionHelper(resultData);
        },
        error : function(jqXHR, textStatus, errorThrown) {
            alert(textStatus + ": " + errorThrown);
            var data = JSON.parse(localStorage["questions"]);
            getAllQuestionHelper(data);
        },

        timeout: 120000,
    });
}

function getAllQuestionHelper(data) {
    var table = "<table class=\"table table-striped\"><thead><tr><th>Question Number</th><th>Question</th></tr></thead><tbody>";
    var questionNumber = 1;

    for (var i = 0; i < data.length; i++) {
        table = table + "<tr><td>" + questionNumber + "</td><td>" + data[i].text + "</td></tr>";
        questionNumber++;
    }

    table = table + "</tbody></table>";
    document.getElementById("admin-container").innerHTML = table;    
}

function viewCreateQuestionPanel() {
    return showTextOnlyQuestion();
}

function viewUpdateQuestionPanel() {
    jQuery.ajax({
        url: "http://localhost:8080/SurveyApplication/resources/questions/",
        type: "GET",
        contentType: 'application/json; charset=utf-8',
        success: function(resultData) {
            localStorage["questions"] = JSON.stringify(resultData);
            viewUpdateQuestionPanelHelper(resultData);
        },
        error : function(jqXHR, textStatus, errorThrown) {
            alert(textStatus + ": " + errorThrown);
            var data = JSON.parse(localStorage["questions"]);
            viewUpdateQuestionPanelHelper(data);
        },

        timeout: 120000,
    });
}

function viewUpdateQuestionPanelHelper(data) {
    var table = "<label for=\"comment\">Please select the question to be updated.</label><br/><table id=\"updatable-table\" class=\"table table-striped\"><thead><tr><th>Question Number</th><th>Question</th></tr></thead><tbody>";
    var questionNumber = 1;

    for (var i = 0; i < data.length; i++) {
        table = table + "<tr onclick=\"showPopup(this);\"><td>" + questionNumber + "</td><td>" + data[i].text + "</td></tr>";
        questionNumber++;
    }

    table = table + "</tbody></table>";
    document.getElementById("admin-container").innerHTML = table;
}

function viewDeleteQuestionPanel() {
    jQuery.ajax({
        url: "http://localhost:8080/SurveyApplication/resources/questions/",
        type: "GET",
        contentType: 'application/json; charset=utf-8',
        success: function(resultData) {
            localStorage["questions"] = JSON.stringify(resultData);
            viewDeleteQuestionPanelHelper(resultData);
        },
        error : function(jqXHR, textStatus, errorThrown) {
            alert(textStatus + ": " + errorThrown);
            var data = JSON.parse(localStorage["questions"]);
            viewDeleteQuestionPanelHelper(data);
        },

        timeout: 120000,
    });
}

function viewDeleteQuestionPanelHelper(data) {
    var table = "<label for=\"comment\">Please select the question to be deleted.</label><br/><table class=\"table table-striped\"><thead><tr><th>Question Number</th><th>Question</th></tr></thead><tbody>";
    var questionNumber = 1;

    for (var i = 0; i < data.length; i++) {
        table = table + "<tr onclick=\"showConfirmDeletePopup(this);\"><td>" + questionNumber + "</td><td>" + data[i].text + "</td></tr>";
        questionNumber++;
    }

    table = table + "</tbody></table>";
    document.getElementById("admin-container").innerHTML = table;
}

function showTextOnlyQuestion(obj) {
    var textArea = document.getElementById("comment");
    var content = "";
    
    if (textArea) {
        content = textArea.value;    
    }
    
    var question = "<label for=\"comment\">Question:</label><textarea class=\"form-control\" rows=\"2\" cols=\"100\" id=\"comment\">" + content + "</textarea>"
                + "<br/><div><label for=\"comment\">Answer type:</label><br/><label class=\"radio-inline\"><input id =\"text_answer\" type=\"radio\" onclick=\"showTextOnlyQuestion(this);\" name=\"Text\">Text"
                + "</label><label class=\"radio-inline\"><input id =\"yes_no\" type=\"radio\" onclick=\"showSingleSelectionQuestion(this);\" name=\"SingleSelection\">Yes/No</label><label class=\"radio-inline\">"
                + "<input id =\"options_answer\" type=\"radio\" onclick=\"showMultipleSelectionQuestion(this);\" name=\"MultipleSelection\">Multiple Selection</label></div><br/>"
                + "<div class=\"col-sm-offset-2 col-sm-10\"><button type=\"submit\" onclick=\"submitQuestion();\"  class=\"btn btn-primary pull-right\">Submit</button></div>";
    document.getElementById("admin-container").innerHTML = question;
    
    if (obj) {
       if (obj.value === 'on') {
            document.getElementById(obj.id).checked = true;
       }
    }
}

function showSingleSelectionQuestion(obj) {
    showTextOnlyQuestion(obj);
}

function showMultipleSelectionQuestion(obj) {
    var textArea = document.getElementById("comment");
    var content = "";
    
    if (textArea) {
        content = textArea.value;    
    }
    
    var question = "<label for=\"comment\">Question:</label><textarea class=\"form-control\" rows=\"2\" cols=\"100\" id=\"comment\">" + content + "</textarea>"
                + "<br/><div><label for=\"comment\">Answer type:</label><br/><label class=\"radio-inline\"><input id =\"text_answer\" type=\"radio\" onclick=\"showTextOnlyQuestion(this);\" name=\"Text\">Text"
                + "</label><label class=\"radio-inline\"><input id =\"yes_no\" type=\"radio\" onclick=\"showSingleSelectionQuestion(this);\" name=\"SingleSelection\">Yes/No</label><label class=\"radio-inline\">"
                + "<input id =\"options_answer\" type=\"radio\" onclick=\"showMultipleSelectionQuestion(this);\" name=\"MultipleSelection\">Multiple Selection</label></div><br/><label for=\"comment\">Provide answer and click add to table button:</label>"
                + "<textarea class=\"form-control\" id=\"answer\" rows=\"1\" cols=\"100\" id=\"comment\"></textarea><br/><button type=\"button\" onclick=\"addQuestionToTable();\" class=\"btn btn-primary pull-right\">"
                + "Add to table</button><br/><br/><table class=\"table table-striped\" id=\"answersTable\"><thead><tr><th>Answers</th></tr></thead><tbody></tbody></table>"
                + "<div class=\"col-sm-offset-2 col-sm-10\"><button type=\"submit\" onclick=\"submitQuestion();\"  class=\"btn btn-primary pull-right\">Submit</button></div>";
    document.getElementById("admin-container").innerHTML = question;
    
    if (obj) {
       if (obj.value === 'on') {
            document.getElementById(obj.id).checked = true;
       }
    }
}

function addQuestionToTable() {
    var answer = document.getElementById("answer");
    answers.push(answer.value);
    var tableContent = "<thead><tr><th>Answer</th></tr></thead><tbody>";
    
    for (var i = 0; i < answers.length; i++) {
        var _answer = answers[i];
        tableContent = tableContent + "<tr><td>" + _answer + "</td></tr>";
    }
    
    tableContenet = tableContent + "</tbody>";
    document.getElementById("answersTable").innerHTML = tableContent; 
    answer.value = "";
}

function submitQuestion() {
    var textArea = document.getElementById("comment");
    var content = "";
    
    if (textArea) {
        content = textArea.value;
        
        if (content == null || content == "") {
            alert("question must be filled out");
            return false;
        }
    }
    
    
    var answerType;
    var options = [];
    var inputs = document.getElementsByTagName("input");
    
    for (var i = 0; i < inputs.length; i++) {
        var value = inputs[i].value;
        
        if (value) {
            if (inputs[i].checked === true) {
                if (inputs[i].id === "text_answer") {
                    answerType = "TEXT";
                }
                
                if (inputs[i].id === "yes_no") {
                    answerType = "YES_NO";
                }
                
                if (inputs[i].id === "options_answer") {
                    answerType = "MULTIPLE_CHOICE";
                    var answersTableRows = document.getElementById("answersTable").rows;
                    
                    for (var j = 0; j < answersTableRows.length; j++) {
                        var row = answersTableRows[j];
                        
                        if (j > 0) {
                            options.push(row.cells[0].firstChild.data) ;   
                        }
                    }
                }
            }      
        } 
    }
    
    var data = {"id":11,"options": options,"questionType":answerType,"text":content};
    jQuery.ajax({
        url: "http://localhost:8080/SurveyApplication/resources/questions/",
        type: "POST",
        contentType: 'application/json; charset=utf-8',
        data: JSON.stringify(data),
        success: function(resultData) {
            
        },
        error : function(jqXHR, textStatus, errorThrown) {
            alert("" + jqXHR.toString() + " " + textStatus + " " + errorThrown);
        },

        timeout: 120000,
    });
    
    alert("Question Created Successfully.");
    textArea.innerHTML = "";
}

function showPopup(obj) {
    updatedQuestionIndex = obj.cells[0].firstChild.data;
    var text = obj.cells[1].firstChild.data;
    var question = "<div class=\"container\" id=\"bubbles_container\">" 
                +"<label for=\"comment\">Question:</label><textarea class=\"form-control\" rows=\"2\"  id=\"comment\">" + text + "</textarea>"
                + "<br/><div><label for=\"comment\">Answer type:</label><br/><label class=\"radio-inline\"><input type=\"radio\" onclick=\"showTextOnlyQuestion();\" name=\"Text\">Text"
                + "</label><label class=\"radio-inline\"><input type=\"radio\" onclick=\"showSingleSelectionQuestion();\" name=\"SingleSelection\">Single Selection</label><label class=\"radio-inline\">"
                + "<input type=\"radio\" onclick=\"showMultipleSelectionQuestion();\" name=\"MultipleSelection\">Multiple Selection</label></div><br/>"
                + "<div class=\"col-sm-offset-2 col-sm-10\"><button type=\"submit\" onclick=\"unloadPopup();\"  class=\"btn btn-primary pull-right\">Update</button></div></div>";
    document.getElementById("technologies-pop-up").innerHTML = question;
    $("#technologies-pop-up").fadeIn("slow");
    $("#technologies-pop-up").css({     
            "opacity": "0.3" 
    });

}

function showConfirmDeletePopup(obj) {
    var text = obj.cells[1].firstChild.data;
    var question = "<div class=\"container\" id=\"bubbles_container\" style=\"width: 600px; height: 200px; margin: 0 auto;\">" 
                +"<label for=\"comment\">Are you sure you want to delete question: <br/>" + text
                + "<div class=\"col-sm-offset-2 col-sm-10\"><button type=\"submit\" onclick=\"unloadPopup();\"  class=\"btn btn-primary pull-right\">OK</button></div></div>";
    document.getElementById("technologies-pop-up").innerHTML = question;
    $('#technologies-pop-up').fadeIn("slow");
    //$("#main_container").css({       
      //      "opacity": "0.3" 
    //});

}

function unloadPopup() {    
    var textArea = document.getElementById("comment");
    var content = "";
    
    if (textArea) {
        content = textArea.value;
    }
    
    var row = document.getElementById("updatable-table").rows[updatedQuestionIndex];
    row.cells[1].firstChild.data = content ;
    // TO Unload the Popupbox
    $('#technologies-pop-up').fadeOut("slow");
    $("#main_container").css({        
            "opacity": "1" 
    });
}