package ac.wits.elen7046.surveyapplication.entities.tests;


import ac.wits.elen7046.surveyapplication.entities.Location;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 *
 * @author f3418944
 */
public class LocationTest {
    
    public LocationTest() {
        
    }
        
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void test() {
        Location location1 = new Location();
        double latitude1 = -90.0000;
        assertFalse(location1.getLatitude() == latitude1);
        location1.setLatitude(latitude1);
        assertFalse(location1.getLatitude() == -700000);
        assertTrue(latitude1 == location1.getLatitude());
        double longitude1 = -81.0000;
        assertFalse(location1.getLongitude() == longitude1);
        location1.setLongitude(longitude1);
        assertFalse(location1.getLongitude() == 70.0303);
        assertTrue(location1.getLongitude() == longitude1);
        Location location2 = new Location();
        double latitude2 = -90.0000;
        assertFalse(location2.equals(location1));
        location2.setLatitude(latitude2);
        assertFalse(location2.equals(location1));
        double longitude2 = -81.0000;
        assertFalse(location2.equals(location1));
        location2.setLongitude(longitude2);
        assertTrue(location2.equals(location1));
        location2.setLongitude(-91.20202);
        assertFalse(location2.equals(location1));
    }
}
