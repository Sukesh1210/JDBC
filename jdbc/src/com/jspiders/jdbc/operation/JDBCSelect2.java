package com.jspiders.jdbc.operation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCSelect2 {
	private static String query;
	private static Statement statement;
	private static Connection connection;
	private static ResultSet resultset;
	
	public static void main(String[] args) {
		try {
			openConnection();
			statement=connection.createStatement();
			query="SELECT * FROM user WHERE id=1";
			resultset=statement.executeQuery(query);
			if(resultset.next()) {
				System.out.println(resultset.getInt(1));
				System.out.println(resultset.getString(2));
				System.out.println(resultset.getString(3));
				System.out.println(resultset.getString(4));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	private static void openConnection() throws SQLException {
		connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/weja4", "root", "root");
	}
	private static void closeConnection() throws SQLException {
		if(resultset!=null) {
		resultset.close();
		}
		if(statement!=null) {
			statement.close();
			
		}
		if(connection!=null) {
			connection.close();
			
		}
		
	}

}
