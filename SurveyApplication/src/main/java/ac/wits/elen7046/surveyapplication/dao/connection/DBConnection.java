package ac.wits.elen7046.surveyapplication.dao.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import ac.wits.elen7046.surveyapplication.entities.Question;

public class DBConnection {
	
	public static Connection getDBConnection() {
		
		Connection connection = null;
		try {
			Class.forName("org.postgresql.Driver");
			
			connection = DriverManager.getConnection(
			   "jdbc:postgresql://localhost:5432/postgres","postgres", "sa");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return connection;
	}
	
	public static void closeConnection(Statement statement, Connection conn) {
		
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
		
}
