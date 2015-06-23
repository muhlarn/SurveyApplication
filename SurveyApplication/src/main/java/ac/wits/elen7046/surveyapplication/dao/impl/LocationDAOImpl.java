package ac.wits.elen7046.surveyapplication.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import ac.wits.elen7046.surveyapplication.dao.LocationDAO;
import ac.wits.elen7046.surveyapplication.dao.connection.DBConnection;
import ac.wits.elen7046.surveyapplication.entities.Location;
import ac.wits.elen7046.surveyapplication.entities.Question;
import ac.wits.elen7046.surveyapplication.entities.QuestionType;
import ac.wits.elen7046.surveyapplication.factory.DAOFactory;

public class LocationDAOImpl implements LocationDAO {

	@Override
	public boolean createLocation(Location location) {
		
		String insertLocation = "INSERT INTO LOCATION (latitude, longitude) VALUES (?, ?)";
		Connection conn = null;
		PreparedStatement statement = null;
		boolean results = false;
		
		try {
			conn = DBConnection.getDBConnection();
			
			statement = conn.prepareStatement(insertLocation);
            statement.setDouble(1, location.getLatitude());
            statement.setDouble(2, location.getLongitude());
          
            if (statement.executeUpdate() < 1) {
	            throw new SQLException("Could not insert the question... " + location);
	        } else {
	        	results = true;
	        }
			
		} catch (SQLException e) { 
			System.out.println(e.getMessage());			
		} finally { 
			
			DBConnection.closeConnection(statement, conn); 
		}
		return results;
	}

	@Override
	public int getLocationId(Location location) {
		
		String selectAllQuestion = "SELECT id FROM LOCATION WHERE latitude = ? and longitude = ?";
		Connection conn = null;
		PreparedStatement statement = null;
	    ResultSet resultSet = null;
	    int locationId = 0;
		
		try {
			conn = DBConnection.getDBConnection();			
			statement = conn.prepareStatement(selectAllQuestion);
	        statement.setDouble(1, location.getLatitude());
	        statement.setDouble(2, location.getLongitude());
	        resultSet = statement.executeQuery();
	        
	        while (resultSet.next()) {
	        	locationId = resultSet.getInt(1);
			}
		} catch (SQLException e) { 
			System.out.println(e.getMessage());			
		} finally { 
			
			DBConnection.closeConnection(statement, conn); 
		}
		
		return locationId;
	}
	

	@Override
	public Location getLocationById(int locationId) {
		
		String selectLocation = "SELECT latitude, longitude FROM LOCATION WHERE id = ?";
		Connection conn = null;
		PreparedStatement statement = null;
	    ResultSet resultSet = null;
	    Location location = new Location();
		
		try {
			conn = DBConnection.getDBConnection();			
			statement = conn.prepareStatement(selectLocation);
	        statement.setDouble(1, locationId);
	        resultSet = statement.executeQuery();
	        
	        while (resultSet.next()) {
	        	location.setLatitude(resultSet.getInt(1));
	        	location.setLongitude(resultSet.getInt(2));
			}
		} catch (SQLException e) { 
			System.out.println(e.getMessage());			
		} finally { 
			
			DBConnection.closeConnection(statement, conn); 
		}
		
		return location;
	}
	
	 public static void main(String[] args) {
	     /* 
		 //testing inserting location
		 System.out.println("adding location");
		 Location location2 = new Location();
		 location2.setLatitude(1.22323);
		 location2.setLongitude(2.0009);
		 boolean response = DAOFactory.getLocationDAO().saveLocation(location2);
		 System.out.println("Response----------------------: " + response);
		 */
		 
		 //testing getting locationId
		 System.out.println("getting location id");
		 Location location = new Location();
		 location.setLatitude(1.22323);
		 location.setLongitude(2.0009);
		 int locationId = DAOFactory.getLocationDAO().getLocationId(location);
		 System.out.println("LocationID---------------------: " + locationId);
		 /*
		 //testing getting location
		 System.out.println("getting location id");
		 Location location3 = DAOFactory.getLocationDAO().getLocationById(2);
		 System.out.println("id: " + location3.getId());
		 System.out.println("latitude: " + location3.getLatitude());
		 System.out.println("longitude------------------------: " + location3.getLongitude()); */
		 	 
	    }


}
