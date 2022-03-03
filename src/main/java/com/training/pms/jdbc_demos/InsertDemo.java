package com.training.pms.jdbc_demos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.training.pms.jdbc_demos.utility.DBConnection;

public class InsertDemo {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Connection con = DBConnection.getConnection();
		
		Statement stat = con.createStatement();
		ResultSet res = stat.executeQuery("select * from employees");
		//takes the cursor to the next row and returns false if no record is there
		//reading the results
	}
}