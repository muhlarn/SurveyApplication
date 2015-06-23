package ac.wits.elen7046.surveyapplication.services.impl;


import ac.wits.elen7046.surveyapplication.entities.Location;
import ac.wits.elen7046.surveyapplication.entities.Question;
import ac.wits.elen7046.surveyapplication.entities.Survey;
import ac.wits.elen7046.surveyapplication.entities.SurveyParticipant;
import ac.wits.elen7046.surveyapplication.entities.Surveyor;
import ac.wits.elen7046.surveyapplication.services.SurveyService;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;


/**
 *
 * @author Ronald Menya
 */
public class SurveyServiceImpl implements SurveyService{
    
    private Map<Long, Survey> surveys  = new HashMap<Long, Survey>();
    
    public SurveyServiceImpl() {
        Survey survey = new Survey();
        survey.setId(1);
        survey.setCreationDate(new Date());
        survey.setName("name1");
        Location location = new Location();
        location.setLatitude(1234556666);
        location.setLongitude(334445566);
        survey.setLocation(location);
        SurveyParticipant surveyor = new Surveyor();
        surveyor.setFirstname("Ron");
        surveyor.setLastname("Menya");
        survey.setSurveyor(surveyor);
        SurveyParticipant respodent = new Surveyor();
        respodent.setFirstname("Ron");
        respodent.setLastname("Menya");
        survey.setRespondent(respodent);
        survey.setQuestions(new ArrayList<Question>());
        survey.setQuestionsToAnswersMapping(new MultivaluedHashMap<Long, List<String>>());
        surveys.put(survey.getId(), survey); 
    }

    /**
     * 
     */ 
    public List<Survey> getAll() {
        return new ArrayList<Survey>(surveys.values());
    }

    /**
     * 
     */ 
    public Survey getSurvey(long surveyId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * 
     */ 
    public Survey addSurvey(Survey survey) {
        survey.setId(surveys.size() + 1);
        surveys.put(survey.getId(), survey);
        return survey;
    }

    /**
     * 
     */ 
    public Survey updateSurvey(Survey survey) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * 
     */ 
    public void deleteSurvey(long surveyId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
