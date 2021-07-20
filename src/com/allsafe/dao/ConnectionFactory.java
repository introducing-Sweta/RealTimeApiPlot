package com.allsafe.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class ConnectionFactory {

	private static final String URL="jdbc:mysql://localhost:3306/sys";
	private static final String USER="root";
	private static final String PASS="adload";
	
	public Connection getConnection() {
		
		try {
			DriverManager.registerDriver(new Driver());
			return DriverManager.getConnection(URL, USER, PASS);
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}
}

