package com.training.pms.jdbc_demos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import com.training.pms.jdbc_demos.utility.DBConnection;

public class App {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("org.postgresql.Driver");
		Connection con = DBConnection.getConnection();
		
		Statement stat = con.createStatement();
		ResultSet res = stat.executeQuery("select * from employees");
		res.next(); // move to next line, 1st index
		System.out.println(res.getInt("salary"));
		
		//Do we have anyway to retrieve the column information
		ResultSetMetaData rsmd = res.getMetaData();
		
		int columnCount = rsmd.getColumnCount();
				
		for (int i = 1; i <= columnCount; i++) {
			System.out.print(rsmd.getColumnName(i) +"  ");
		}
		System.out.println();
		
		// cursor to next row, returns false if no record is there
		while(res.next()) {
			for (int i = 1; i <= columnCount; i++) {
				System.out.print(res.getString(i) +"  ");
			}
			System.out.println();
		}
		//closing the resultset, statement and connection
		res.close();
		stat.close();
		con.close();
	}
}