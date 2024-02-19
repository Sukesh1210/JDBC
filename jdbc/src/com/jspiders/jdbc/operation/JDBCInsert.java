package com.jspiders.jdbc.operation;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCInsert {
	public static void main(String[] args) throws SQLException {
		//Register Driver
		Driver driver=new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(driver);
		
		//Get Connection
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/weja4?user=root&&password=root");
		
		//Create statement
		Statement statement=connection.createStatement();
		
		//Execute statement
		statement.execute("INSERT INTO user VALUES(1,'Sukesh','sukesh@gmail.com','Sukesh@123')");
		
		//Process result
		System.out.println("Data inserted");
		
		//Close connection
		connection.close();
		
		//Deregister Driver
		DriverManager.deregisterDriver(driver);

	}
}
