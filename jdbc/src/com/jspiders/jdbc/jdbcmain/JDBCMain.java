package com.jspiders.jdbc.jdbcmain;

import java.util.Scanner;

import com.jspiders.jdbc.operation.JDBCService;

public class JDBCMain {
	private static Scanner scanner=new Scanner(System.in);
	
	public static void main(String[] args) {
		boolean flag=true;
		
		
		while(flag) {
			System.out.println("Enter 1 to signup\nEnter 2 to login\nEnter 3 to exit");
			int choice=scanner.nextInt();
			switch (choice) {
			case 1:
				JDBCService.signUp(scanner);
				break;
			case 2:
				JDBCService.logIn(scanner);
				break;
			case 3:
			flag=false;
			System.out.println("Thank you");
			break;
			
			default:
				System.out.println("Invalid input");
			}
		}
	}

}
