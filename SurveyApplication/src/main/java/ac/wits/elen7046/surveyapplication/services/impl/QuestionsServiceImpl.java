/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.wits.elen7046.surveyapplication.services.impl;


import ac.wits.elen7046.surveyapplication.entities.Question;
import ac.wits.elen7046.surveyapplication.entities.QuestionType;
import ac.wits.elen7046.surveyapplication.services.QuestionsService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author f3418944
 */
public class QuestionsServiceImpl implements QuestionsService{
    
    private Map<Long, Question> questions = questions = new HashMap<Long, Question>();
    
    public QuestionsServiceImpl() {
        ArrayList<String> options = new ArrayList<String>();
        Question question1 = new Question();
        question1.setId(1);
        question1.setText("Is there a wide difference in performance between the available hospitals in this area?");
        question1.setQuestionType(QuestionType.YES_NO);   
        question1.setOptions(new ArrayList<String>());
        questions.put(question1.getId(), question1);
        Question question2 = new Question();
        question2.setId(2);
        question2.setText("Is there a wide difference in the cost of the different hospitals in this area?");
        question2.setQuestionType(QuestionType.YES_NO);
        question2.setOptions(options);
        questions.put(question2.getId(), question2);
        Question question3 = new Question();
        question3.setId(3);
        question3.setText("Were satisfied are you with the skill and competency of the staff?");
        question3.setQuestionType(QuestionType.YES_NO);
        question3.setOptions(options);
        questions.put(question3.getId(), question3);
        Question question4 = new Question();
        question4.setId(4);
        question4.setText("Which of the following problems did you encounter?");
        question4.setQuestionType(QuestionType.MULTIPLE_CHOICE);
        ArrayList<String> options4 = new ArrayList<String>();
        options4.add("Unvailability of staff");
        options4.add("Long waiting times");
        options4.add("Lack of Signage");
        question4.setOptions(options4);
        questions.put(question4.getId(), question4);
        Question question5 = new Question();
        question5.setId(5);
        question5.setText("Which of the following habbits do you have?");
        question5.setQuestionType(QuestionType.MULTIPLE_CHOICE);
        ArrayList<String> options5 = new ArrayList<String>();
        options5.add("Smoking");
        options5.add("Drinking");
        options5.add("Drugs");
        question5.setOptions(options5);
        questions.put(question5.getId(), question5);
        Question question6 = new Question();
        question6.setId(6);
        question6.setText("Have you visted a hospital in the last one year?");
        question6.setQuestionType(QuestionType.YES_NO);   
        question6.setOptions(new ArrayList<String>());
        questions.put(question6.getId(), question6);
        Question question7 = new Question();
        question7.setId(7);
        question7.setText("How many times have you visted a hospital in the last one year?");
        question7.setQuestionType(QuestionType.TEXT);   
        question7.setOptions(new ArrayList<String>());
        questions.put(question7.getId(), question7);
        Question question8 = new Question();
        question8.setId(8);
        question8.setText("What have you heard about the care patients receive at [Hospital]?");
        question8.setQuestionType(QuestionType.TEXT);   
        question8.setOptions(new ArrayList<String>());
        questions.put(question8.getId(), question8);
    }

    public List<Question> getAll() {
        return new ArrayList<Question>(questions.values());
    }

    public Question getQuestion(long questionId) {
        Question question = questions.get(questionId);
        System.out.println("XXXXXXXXXXXXXX: " + question.toString());
        return question;
    }

    public Question addQuestion(Question question) {
        question.setId(questions.size() + 1);
        return questions.put(question.getId(), question);
                
    }

    public Question updateQuestion(Question question) {
        return questions.put(question.getId(), question);
    }

    public void deleteQuestion(long questionId) {
        questions.remove(questionId);
    }
    
    public static void main(String[] args) {
        QuestionsService questionsService = new QuestionsServiceImpl();
        List<Question> questions = questionsService.getAll();
        System.out.println("" + questions);
    }
}
