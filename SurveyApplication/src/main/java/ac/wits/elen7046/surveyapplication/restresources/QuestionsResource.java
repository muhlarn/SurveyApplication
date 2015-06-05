package ac.wits.elen7046.surveyapplication.restresources;


import ac.wits.elen7046.surveyapplication.entities.Question;
import ac.wits.elen7046.surveyapplication.services.QuestionsService;
import ac.wits.elen7046.surveyapplication.services.impl.QuestionsServiceImpl;
import java.io.Serializable;
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
@Path("questions")
@Singleton
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public class QuestionsResource implements Serializable {
    private static Logger logger = Logger.getLogger(QuestionsResource.class.getName());
    private QuestionsService questionsService = new QuestionsServiceImpl();
    
    @GET
    public List<Question> getAll() {
        logger.info("Getting all questions");
        return questionsService.getAll();
    }
    
    @GET
    @Path("/{id}")
    public Question getQuestion(@PathParam("id") long questionId) {
        logger.info("Getting question with id: " + questionId);
        logger.info(questionsService.getQuestion(questionId).toString());
        return questionsService.getQuestion(questionId);
    }

    @POST
    public Question addQuestion(Question question) {
        logger.info("Adding question: " + question.getText());
        return questionsService.addQuestion(question);
    }

    @PUT
    public Question updateQuestion(Question question) {
        logger.info("updating question: " + question.getText());
        return questionsService.updateQuestion(question);
    }

    @DELETE
    @Path("/{id}")
    public void deleteQuestion(@PathParam("id") long questionId) {
        logger.info("deleting question with id: " + questionId);
        questionsService.deleteQuestion(questionId);
    }
}
