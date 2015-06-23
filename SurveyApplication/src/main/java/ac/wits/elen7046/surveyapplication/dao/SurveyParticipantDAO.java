package ac.wits.elen7046.surveyapplication.dao;

import ac.wits.elen7046.surveyapplication.entities.SurveyParticipant;

public interface SurveyParticipantDAO {
	
	public int getSurveyParticipantId(SurveyParticipant surveyParticipant);
	public boolean createSurveyParticipant(SurveyParticipant surveyParticipant);
	public SurveyParticipant getSurveyParticipantById(int surveyParticipantId);

}
