package ac.wits.elen7046.surveyapplication.factory;

import ac.wits.elen7046.surveyapplication.dao.LocationDAO;
import ac.wits.elen7046.surveyapplication.dao.QuestionDAO;
import ac.wits.elen7046.surveyapplication.dao.SurveyDAO;
import ac.wits.elen7046.surveyapplication.dao.SurveyParticipantDAO;
import ac.wits.elen7046.surveyapplication.dao.impl.LocationDAOImpl;
import ac.wits.elen7046.surveyapplication.dao.impl.QuestionDAOImpl;
import ac.wits.elen7046.surveyapplication.dao.impl.SurveyDAOImpl;
import ac.wits.elen7046.surveyapplication.dao.impl.SurveyParticipantDAOImpl;
import ac.wits.elen7046.surveyapplication.services.QuestionsService;
import ac.wits.elen7046.surveyapplication.services.impl.QuestionsServiceImpl;


public class DAOFactory {
	
	public static QuestionDAO getQuestionDAO() {
		return (new QuestionDAOImpl());
	}
	
	public static LocationDAO getLocationDAO() {
		return (new LocationDAOImpl());
	}
	
	public static SurveyParticipantDAO getSurveyParticipantDAO() {
		return (new SurveyParticipantDAOImpl());
	}
	
	public static SurveyDAO getSurveyDAO() {
		return (new SurveyDAOImpl());
	}

}
