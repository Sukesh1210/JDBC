package com.jspiders.jdbc.operation;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCCall {
	private static Connection connection;
	private static CallableStatement callableStatement;
	private static String query;
	private static ResultSet resultSet;
	
	public static void main(String[] args) {
		try {
			openConnection();
			query="call stoe()";
			callableStatement=connection.prepareCall(query);
			callableStatement.execute();
			resultSet=callableStatement.getResultSet();
			while(resultSet.next()) {
				System.out.println(resultSet.getString(2));
				
			}
			
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
		connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/weja4","root","root");
	}
	private static void closeConnection() throws SQLException {
		if(resultSet!=null) {
			resultSet.close();
			
		}
		if(callableStatement!=null) {
			callableStatement.close();
			
		}
		if(connection!=null) {
			connection.close();
			
		}
		
	}

}
