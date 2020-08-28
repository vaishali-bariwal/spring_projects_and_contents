package com.demo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;



public class TestJdbc {

	public static void main(String[] args) {
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb-04-one-to-many-uni?useSSL=false";
		String user = "hbstudent";
		String pwd = "hbstudent";
		
		try {
			System.out.println("Connecting to database "+jdbcUrl);
			
			Connection con = DriverManager.getConnection(jdbcUrl,user,pwd);
			
			System.out.println("Connection Successful");
			
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}

	}

}
