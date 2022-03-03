package com.training.pms.jdbc_demos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import com.training.pms.jdbc_demos.utility.DBConnection;

public class PApp {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("org.postgresql.Driver");
		Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "Aero$mith101");

		Statement stat = con.createStatement();
		ResultSet res = stat.executeQuery("select * from employees");
		// res.next(); takes the cursor to the next row and returns false if no record is there
		//reading the results
		ResultSetMetaData rsmd = res.getMetaData(); // helps retrieve more information about ResultSet
		int columnCount = rsmd.getColumnCount();
		
		for(int i = 1; i <= columnCount; i++) {
			System.out.print(rsmd.getColumnName(i) + " : ");
		}
		
		System.out.println();
		
		while(res.next()) {
//			System.out.print(res.getString(1) + "  ");
//			System.out.print(res.getString(2) + "  ");
//			System.out.print(res.getString(3) + "  ");
//			System.out.println(res.getString(4) + "  ");
			
			for(int i = 1; i <= columnCount; i++) {
				System.out.print(res.getString(i) + " : ");
			}
			System.out.println();
		}
		
		//closing the resultset, statement and connection
		res.close();
		stat.close();
		con.close();
	}
}