package com.training.pms.jdbc_demos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;
import com.training.pms.jdbc_demos.utility.DBConnection;

public class CallingProcedureFromJava {

	public static void main(String[] args) throws SQLException {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter account number to debit the amount: ");
		int sender = sc.nextInt();
		
		System.out.println("Enter account number to credit the amount: ");
		int receiver = sc.nextInt();
		
		System.out.println("Enter amount to be transferred: ");
		int amount = sc.nextInt();
		
		Connection connect = DBConnection.getConnection();
		CallableStatement stat = connect.prepareCall("Caller transfer(?, ?, ?)");
		stat.setInt(1, sender);
		stat.setInt(2, receiver);
		stat.setInt(3, amount);
		
		stat.execute();
		
		System.out.println("Transfer done/completed");
	}

}
