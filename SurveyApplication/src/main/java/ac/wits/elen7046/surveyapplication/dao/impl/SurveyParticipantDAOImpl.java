package ac.wits.elen7046.surveyapplication.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ac.wits.elen7046.surveyapplication.dao.SurveyParticipantDAO;
import ac.wits.elen7046.surveyapplication.dao.connection.DBConnection;
import ac.wits.elen7046.surveyapplication.entities.Location;
import ac.wits.elen7046.surveyapplication.entities.SurveyParticipant;
import ac.wits.elen7046.surveyapplication.factory.DAOFactory;

public class SurveyParticipantDAOImpl implements SurveyParticipantDAO {

	@Override
	public int getSurveyParticipantId(SurveyParticipant surveyParticipant) {
		
		String selectSurveyParticipant = "SELECT id FROM SURVEYPARTICIPANT WHERE firstname = ? AND lastname = ? AND age = ?";
		Connection conn = null;
		PreparedStatement statement = null;
	    ResultSet resultSet = null;
	    int surveyParticipantId = 0;
		
		try {
			conn = DBConnection.getDBConnection();			
			statement = conn.prepareStatement(selectSurveyParticipant);
	        statement.setString(1, surveyParticipant.getFirstname());
	        statement.setString(2, surveyParticipant.getLastname());
	        statement.setInt(3, surveyParticipant.getAge());
	        resultSet = statement.executeQuery();
	        
	        while (resultSet.next()) {
	        	surveyParticipantId = resultSet.getInt(1);
			}
		} catch (SQLException e) { 
			System.out.println(e.getMessage());			
		} finally { 
			
			DBConnection.closeConnection(statement, conn); 
		}
		
		return surveyParticipantId;
	}

	@Override
	public boolean createSurveyParticipant(SurveyParticipant surveyParticipant) {
		
		
		String insertLocation = "INSERT INTO SURVEYPARTICIPANT (firstname, lastname, age) VALUES (?, ?, ?)";
		Connection conn = null;
		PreparedStatement statement = null;
		boolean results = false;
		
		try {
			conn = DBConnection.getDBConnection();
			
			statement = conn.prepareStatement(insertLocation);
            statement.setString(1, surveyParticipant.getFirstname());
            statement.setString(2, surveyParticipant.getLastname());
            statement.setInt(3, surveyParticipant.getAge());
          
            if (statement.executeUpdate() < 1) {
	            throw new SQLException("Could not insert the question... " + surveyParticipant);
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
	public SurveyParticipant getSurveyParticipantById(
			int surveyParticipantId) {
		
		String selectSurveyParticipant = "SELECT id, firstname, lastname, age FROM SURVEYPARTICIPANT WHERE id = ?";
		Connection conn = null;
		PreparedStatement statement = null;
	    ResultSet resultSet = null;
	    SurveyParticipant surveyParticipant = new SurveyParticipant();
		
		try {
			conn = DBConnection.getDBConnection();			
			statement = conn.prepareStatement(selectSurveyParticipant);
	        statement.setDouble(1, surveyParticipantId);
	        resultSet = statement.executeQuery();
	        
	        while (resultSet.next()) {
	        	surveyParticipant.setId(resultSet.getInt(1));
	        	surveyParticipant.setFirstname(resultSet.getString(2));
	        	surveyParticipant.setLastname(resultSet.getString(3));
	        	surveyParticipant.setAge(resultSet.getInt(4));
			}
		} catch (SQLException e) { 
			System.out.println(e.getMessage());			
		} finally { 
			
			DBConnection.closeConnection(statement, conn); 
		}
		
		return surveyParticipant;
	}
	
	 public static void main(String[] args) {
	     
		 //testing inserting surveyParticipant
		 System.out.println("adding surveyParticipant");
		 SurveyParticipant surveyParticipant = new SurveyParticipant();
		 surveyParticipant.setFirstname("STEVE");
		 surveyParticipant.setLastname("JOBS");
		 surveyParticipant.setAge(55);
		 boolean response = DAOFactory.getSurveyParticipantDAO().createSurveyParticipant(surveyParticipant);
		 System.out.println("Response----------------------: " + response);
		 
		 
		 //testing getting surveyParticipantId
		 System.out.println("getting surveyParticipant id");
		 SurveyParticipant surveyParticipant1 = new SurveyParticipant();
		 surveyParticipant1.setFirstname("STEVE");
		 surveyParticipant1.setLastname("JOBS");
		 surveyParticipant1.setAge(55);
		 int surveyParticipantId = DAOFactory.getSurveyParticipantDAO().getSurveyParticipantId(surveyParticipant1);
		 System.out.println("LocationID---------------------: " + surveyParticipantId);
		 
		 //testing getting surveyParticipant
		 System.out.println("getting surveyParticipant id");
		 SurveyParticipant surveyParticipant2 = DAOFactory.getSurveyParticipantDAO().getSurveyParticipantById(1);
		 System.out.println("id: " + surveyParticipant2.getId());
		 System.out.println("firstname: " + surveyParticipant2.getFirstname());
		 System.out.println("lastname------------------------: " + surveyParticipant2.getLastname()); 
		 System.out.println("age------------------------: " + surveyParticipant2.getAge()); 
		 	 
	    }

}
