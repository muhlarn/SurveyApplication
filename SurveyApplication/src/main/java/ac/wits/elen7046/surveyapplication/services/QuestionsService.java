package ac.wits.elen7046.surveyapplication.services;


import ac.wits.elen7046.surveyapplication.entities.Question;
import java.util.List;


/**
 *
 * @author Ronald Menya
 */
public interface QuestionsService {
    
    
    public List<Question> getAll();
    public Question getQuestion(long questionId);
    public Question addQuestion(Question question);
    public Question updateQuestion(Question question);
    public void deleteQuestion(long questionId);
}
