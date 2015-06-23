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
        for (int i = 1; i < 10; i++) {
            Question question = new Question();
            
            if (i % 2 == 0) { 
               question.setQuestionType(QuestionType.TEXT);   
               question.setOptions(new ArrayList<String>());
               
            } else {
               question.setQuestionType(QuestionType.MULTIPLE_CHOICE);
               ArrayList<String> options = new ArrayList<String>();
               options.add("option 1");
               options.add("option 2");
               options.add("option 3");
               question.setOptions(options);
            }
            
            question.setId(i);
            question.setText("This is question " + i);
            questions.put(question.getId(), question);
            System.out.println("XXXXXXXXXXXXXX: " + question.getOptions());
        }
        
        Question question = new Question();
        question.setQuestionType(QuestionType.YES_NO);   
        question.setOptions(new ArrayList<String>());
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
