package ac.wits.elen7046.surveyapplication.dao;

import java.util.List;

import ac.wits.elen7046.surveyapplication.entities.Question;

public interface QuestionDAO {
	
	public List<Question> getAll(); 
	public boolean updateQuestion(Question question); 
	public boolean addQuestion(Question question); 
	public boolean deleteQuestion(long questionId); 
	public boolean getQuestion(long questionId); 
}
