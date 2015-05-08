package ac.wits.elen7046.surveyapplication.entities.tests;


import ac.wits.elen7046.surveyapplication.entities.Question;
import ac.wits.elen7046.surveyapplication.entities.Response;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 * A unit test class for the ac.wits.elen7046.surveyapplication.entities.Question
 * <br/> class.
 * 
 * @author Ronald Menya
 */
public class QuestionTest {
   
    /**
     * 
     */
    private Question question;
    
    /**
     * 
     */
    public QuestionTest() {
    }
    
    /**
     * 
     */
    @BeforeClass
    public static void setUpClass() {
    }
    
    /**
     * 
     */
    @AfterClass
    public static void tearDownClass() {
    }
    
    /**
     * 
     */
    @Before
    public void setUp() {
        this.question = new Question();
    }
    
    /**
     * 
     */
    @After
    public void tearDown() {
        question = null;
    }
    
    /**
     * 
     */
    @Test
    public void testQuestion() {
        long id = 1;
        question.setId(id);
        assertEquals(question.getId(), id);
        
        String description = "This is a question";
        question.setDescription(description);
        assertEquals(question.getDescription(), description);
       
        Response response = new Response();
        long _id = 1;
        response.setId(_id);
        assertEquals(response.getId(), _id);
        String _description = "This is a response";
        response.setDescription(_description);
        List<Response> responses = new ArrayList<Response>();
        responses.add(response);
        question.setResponses(responses);
        assertEquals(responses, question.getResponses());
        
        Question otherQuestion = new Question();
        otherQuestion.setId(id);
        otherQuestion.setDescription(description);
        assertEquals(question, otherQuestion);
        
        otherQuestion.setDescription("This is another question");
        assertFalse(question.equals(otherQuestion));     
    }
}