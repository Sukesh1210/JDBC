package com.jspiders.jdbc.operation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCInsert2 {
	private static Statement statemant;
	private static String query;
	private static Connection connection;
	
	public static void main(String[] args) {
		try {
			openConnection();
			statemant=connection.createStatement();
			query="INSERT INTO user VALUES(2,'Mahesh','mahesh@gmail.com','mahesh@123')";
			statemant.execute(query);
			System.out.println("Data is inserted");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	private static void openConnection() throws SQLException {
		connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/weja4?user=root&&password=root");
		
	}
	private static void closeConnection() throws SQLException {
		if(statemant!=null) {
			statemant.close();
			
		}
		if(connection!=null) {
			connection.close();
			
		}
		
	}

}
