package ac.wits.elen7046.surveyapplication.entities.tests;


import ac.wits.elen7046.surveyapplication.entities.Response;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 * A unit test class for the ac.wits.elen7046.surveyapplication.entities.Response
 * <br/> class.
 * 
 * @author Ronald Menya
 */
public class ResponseTest {
    
    /**
     * 
     */
    private static Response response;
    
    /**
     * 
     */
    public ResponseTest() {
  
    }
    
    /**
     * 
     */ 
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    /**
     * 
     * 
     */ 
    @AfterClass
    public static void tearDownClass() {
        
    }
    
    /**
     * 
     * 
     */ 
    @Before
    public void setUp() {
        response = new Response();
    }
    
    @After
    public void tearDown() {
        response = null;
    }

    /**
     * 
     * 
     */ 
    @Test
    public void testResponse() {
        long id = 1;
        response.setId(id);
        assertEquals(response.getId(), id);
        
        String description = "This is a response";
        response.setDescription(description);
        assertEquals(response.getDescription(), description);
        
        Response otherResponse = new Response();
        otherResponse.setId(id);
        otherResponse.setDescription(description);
        assertEquals(response, otherResponse);
        
        otherResponse.setDescription("This is another response");
        assertFalse(response.equals(otherResponse));
    }
}
