/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.wits.elen7046.surveyapplication.restresources;


import ac.wits.elen7046.surveyapplication.entities.Survey;
import ac.wits.elen7046.surveyapplication.services.SurveyService;
import ac.wits.elen7046.surveyapplication.services.impl.SurveyServiceImpl;
import java.util.List;
import java.util.logging.Logger;
import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Ronald Menya
 */
@Path("surveys")
@Singleton
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public class SurveyResource {
    
    private static Logger logger = Logger.getLogger(SurveyResource.class.getName());
    private SurveyService surveyService = new SurveyServiceImpl();
    
    @GET
    public List<Survey> getAll() {
        logger.info("Getting all surveys");
        return surveyService.getAll();
    }
    
    @GET
    @Path("/{id}")
    public Survey getSurvey(@PathParam("id") long surveyId) {
        logger.info("Getting survey with id: " + surveyId);
        logger.info(surveyService.getSurvey(surveyId).toString());
        return surveyService.getSurvey(surveyId);
    }

    @POST
    public Survey addSurvey(Survey survey) {
        logger.info("Adding survey: " + survey.getName());
        return surveyService.addSurvey(survey);
    }

    @PUT
    public Survey updateSurvey(Survey survey) {
        logger.info("Updating survey: " + survey.getName());
        return surveyService.updateSurvey(survey);
    }

    @DELETE
    @Path("/{id}")
    public void deleteSurvey(@PathParam("id") long surveyId) {
        logger.info("Deleting survey with id: " + surveyId);
        surveyService.deleteSurvey(surveyId);
    }
}
