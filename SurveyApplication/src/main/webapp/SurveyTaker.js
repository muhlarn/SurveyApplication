var data;
var counter = 0;
var survey = {"creationDate":"",
                "id":0,
                "location":{"latitude":0,"longitude":0},
                "name":"name1",
                "questions":[],
                "questionsToAnswersMapping":{"entry":[]},
                "respondent":{"age":0,"firstname":"xxx","lastname":"xxxx"},
                "surveyor":{"age":0,"firstname":"xxxxx","lastname":"xxxx"},
                "version":0.0
              };
              
var allQuestions = function () {    
    jQuery.ajax({
        url: "http://localhost:8080/SurveyApplication/resources/questions/",
        type: "GET",
        contentType: 'application/json; charset=utf-8',
        success: function(resultData) {
            data = resultData;
        },
        error : function(jqXHR, textStatus, errorThrown) {
            alert(errorThrown);
        },

        timeout: 120000,
    });
}();

function startSurvey() {
    var inputs = document.getElementsByTagName("input");
    
    for (var i = 0; i < inputs.length; i++) {
        if (inputs[i].name === "surveydate") {
            survey.creationDate = inputs[i].value;
            break;
        }
    }    
    
    survey.surveyor.firstname = document.getElementById("firstname").value;
    survey.surveyor.lastname = document.getElementById("lastname").value;
    nextQuestion();
}

function nextQuestion() {
    if (counter => 0 && counter < data.length) {
        if (counter > 0) {
            survey.questionsToAnswersMapping.entry[counter - 1, "mamamamma"];
        }
        var question = data[counter];
        var answerTemplate;

        if (question.questionType === "MULTIPLE_CHOICE") {
           answerTemplate = getOptionsTemplate(question); 
        } else if (question.questionType === "YES_NO") {
           answerTemplate = getYesNoTemplate(question);
        } else if (question.questionType === "TEXT") {
           answerTemplate = getTextTemplate(question);
        }

        var questionNumber = counter + 1;
        var text = questionNumber + ". " + question.text;
        var questionText = "<br/><p>" + text + "<p/><br/>"
        var nextButton = "<div class=\"col-sm-offset-2 col-sm-10\"><button type=\"button\" class=\"btn btn-primary pull-right\" onclick=\"nextQuestion();\">Next</button></div></div>";
        document.getElementById("survey-container").innerHTML = questionText + answerTemplate + nextButton;
        counter++;
        
        if (counter == data.length) {
            alert ("Completed Survey");
             submitSurvey();
        }
    }
    
}

function getYesNoTemplate() {
    var template = "<div class=\"radio\"><label><input type=\"radio\" name=\"optradio\">Yes</label></div>"
                 + "<div class=\"radio\"><label><input type=\"radio\" name=\"optradio\">No</label></div>";
    return template;
}

function getOptionsTemplate() {
    var template = "<div class=\"checkbox\"><label><input type=\"checkbox\" value=\"\">Option 1</label>"
                 + "</div><div class=\"checkbox\"><label><input type=\"checkbox\" value=\"\">Option 2</label>"
                 + "</div><div class=\"checkbox\"><label><input type=\"checkbox\" value=\"\">Option 3</label></div>";
    return template;
}

function getTextTemplate() {
    var input = "<label for=\"comment\">Answer:</label><textarea class=\"form-control\" rows=\"2\"  id=\"comment\"></textarea>";
    return input;
}

function submitSurvey() {
    jQuery.ajax({
        url: "http://localhost:8080/SurveyApplication/resources/surveys/",
        type: "POST",
        contentType: 'application/json; charset=utf-8',
        data: JSON.stringify(survey),
        success: function(resultData) {
            
        },
        error : function(jqXHR, textStatus, errorThrown) {
            alert(errorThrown);
        },

        timeout: 120000,
    });
    
    var content = getSurveyConfigPage();
    alert(content);
    document.getElementById("survey-container").innerHTML = content;
}


function getSurveyConfigPage() {
    var content = "<br/><label for=\"date\">Date:</label><input id=\"surveydate\" type=\"text\" name=\"surveydate\" value=\"\" />"
            +  "<script type=\"text/javascript\">$(function() {$(\'input[name=\"surveydate\"]\').daterangepicker({format: \'DD/MM/YYYY\',"    
            +  "singleDatePicker: true,showDropdowns: true},function(start, end, label) {var years = moment().diff(start, \'years\');"
            +  "});});</script><br/><br/><fieldset><legend>Surveyor</legend><div class=\"col-xs-6\"><label for=\"firstname\">Firstname:</label>"
            +  "<input type=\"text\" class=\"form-control\" id=\"firstname\" maxlength=\"10\"></div><div class=\"col-xs-6\"><label for=\"lastname\">Lastname:</label>"
            +  "<input type=\"text\" class=\"form-control\" id=\"lastname\" maxlength=\"10\"></div></fieldset><br/><fieldset><legend>Location</legend>"
            +  "<div class=\"dropdown\">&nbsp;&nbsp;&nbsp;&nbsp;<button class=\"btn btn-primary dropdown-toggle\" type=\"button\" id=\"country\" data-toggle=\"dropdown\">Country<span class=\"caret\"></span></button>" + "<ul class=\"dropdown-menu\" role=\"menu\" aria-labelledby=\"menu1\"><li role=\"presentation\"><a role=\"menuitem\" tabindex=\"-1\" href=\"#\"></a>South Africa</li>"
            +  "<li role=\"presentation\" class=\"divider\"></li></ul></div><br/><div class=\"col-xs-6\"><label for=\"state\">State/Province:</label> <input type=\"text\" class=\"form-control\" id=\"state\" maxlength=\"10\">" + "</div><div class=\"col-xs-6\"><label for=\"city\">City:</label> <input type=\"text\" class=\"form-control\" id=\"city\" maxlength=\"10\"></div><div class=\"col-xs-6\">" + "<label for=\"suburb\">Suburb:</label><input type=\"text\" class=\"form-control\" id=\"suburb\" maxlength=\"10\"></div><div class=\"col-xs-6\"><label for=\"street-address\">Street Address:</label>" + "<input type=\"text\" class=\"form-control\" id=\"street-address\" maxlength=\"10\"></div><div class=\"col-xs-6\"><label for=\"code\">Code:</label> <input type=\"text\" class=\"form-control\" id=\"code\" maxlength=\"10\">" + "</div></fieldset><br/><div class=\"col-sm-offset-2 col-sm-10\"><button type=\"button\"  class=\"btn btn-primary pull-right\" onclick=\"startSurvey();\">Start Survey</button></div>"
    return content;
}