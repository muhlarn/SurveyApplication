package ac.wits.elen7046.surveyapplication.dao;

import java.sql.SQLException;
import java.util.List;

import ac.wits.elen7046.surveyapplication.entities.Question;
import ac.wits.elen7046.surveyapplication.entities.Surveyor;

public interface AnswerDAO {
	
	public boolean saveAnswers() throws SQLException; 
}
