package ac.wits.elen7046.surveyapplication.dao;

import java.sql.SQLException;
import java.util.List;

import ac.wits.elen7046.surveyapplication.entities.Question;
import ac.wits.elen7046.surveyapplication.entities.Survey;
import ac.wits.elen7046.surveyapplication.entities.Surveyor;

public interface SurveyDAO {
	
	public boolean createSurvey(Survey survey) throws SQLException; 
}
