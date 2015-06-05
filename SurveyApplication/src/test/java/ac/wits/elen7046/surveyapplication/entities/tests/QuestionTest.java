package ac.wits.elen7046.surveyapplication.entities.tests;


import ac.wits.elen7046.surveyapplication.entities.Question;
import java.util.UUID;
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
        long id = System.currentTimeMillis();
        assertEquals(question.getId(), id);
        
        String description = "This is a question";
        question.setText(description);
        assertEquals(question.getText(), description);
       

        
        Question otherQuestion = new Question();
        otherQuestion.setText(description);
        assertEquals(question, otherQuestion);
        
        otherQuestion.setText("This is another question");
        assertFalse(question.equals(otherQuestion));     
    }
}