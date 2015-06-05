/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.wits.elen7046.surveyapplication.entities.tests;

import ac.wits.elen7046.surveyapplication.entities.SurveyParticipant;
import ac.wits.elen7046.surveyapplication.entities.Surveyor;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author f3418944
 */
public class SurveyorTest {
    
    public SurveyorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void test() {
        SurveyParticipant surveyor1 = new Surveyor();
        long id = surveyor1.getId();
        assertTrue(id > 0);
        surveyor1.setFirstname("Sam");
        assertFalse(surveyor1.getFirstname().equals("Ronald"));
        surveyor1.setLastname("Lee");
        assertFalse(surveyor1.getLastname().equals("Doe"));
        surveyor1.setLastname("Doe");
        assertTrue(surveyor1.getLastname().equals("Doe"));
        surveyor1.setAge(18);
        assertFalse(surveyor1.getAge() > 19);
        assertTrue(surveyor1.getAge() < 19);
        assertTrue(surveyor1.getAge() == 18);
        
    }
}
