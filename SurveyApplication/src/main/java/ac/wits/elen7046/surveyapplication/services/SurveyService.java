package ac.wits.elen7046.surveyapplication.services;


import ac.wits.elen7046.surveyapplication.entities.Survey;
import java.util.List;


/**
 *
 * @author Ronald Menya
 */
public interface SurveyService {

    
    /**    
     * 
     */
    public List<Survey> getAll();

    /**
     * 
     */ 
    public Survey getSurvey(long surveyId);

    /**
     * 
     */ 
    public Survey addSurvey(Survey survey);

    /**
     * 
     */ 
    public Survey updateSurvey(Survey survey);

    /**
     * 
     */ 
    public void deleteSurvey(long surveyId);
    
}
