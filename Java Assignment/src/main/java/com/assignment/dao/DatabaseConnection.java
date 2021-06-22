package com.assignment.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

	public Connection getCon() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment", "root", "root");

		} catch (ClassNotFoundException | SQLException ex) {
			ex.printStackTrace();
		}
		return con;

	}

}
