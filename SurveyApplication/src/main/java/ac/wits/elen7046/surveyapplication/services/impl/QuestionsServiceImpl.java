/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.wits.elen7046.surveyapplication.services.impl;

import ac.wits.elen7046.surveyapplication.entities.Question;
import ac.wits.elen7046.surveyapplication.services.QuestionsService;
import com.mongodb.DB;
import com.mongodb.MongoClient;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author f3418944
 */
public class QuestionsServiceImpl implements QuestionsService{
    
    private Map<Long, Question> questions = questions = new HashMap<Long, Question>();
    
    public QuestionsServiceImpl() {
        Question question1 = new Question();
        question1.setText("This is question 1");
        Question question2 = new Question();
        question2.setText("This is question 2");
        questions.put(question1.getId(), question1);
        questions.put(question2.getId(), question2);
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
        return questions.put(question.getId(), question);
                
    }

    public Question updateQuestion(Question question) {
        return questions.put(question.getId(), question);
    }

    public void deleteQuestion(long questionId) {
        questions.remove(questionId);
    }
    
    public static void main(String[] args) {
        MongoClient mongoClient = null;
        
        try {
            mongoClient = new MongoClient("localhost", 27017);
            DB db = mongoClient.getDB("Survey_APP_DB");
            List<String> dbs = mongoClient.getDatabaseNames();
            System.out.println("DBs: " + dbs);
        } catch (UnknownHostException ex) {
            Logger.getLogger(QuestionsServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (mongoClient != null) {
                mongoClient.close();
            }
        }
    }
}
