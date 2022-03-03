package com.training.pms.jdbc_demos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

import com.training.pms.jdbc_demos.utility.DBConnection;

public class CallingProcedureFromJavaOutput {

	public static void main(String[] args) throws SQLException {
		Scanner scanner = new Scanner(System.in);
		
		int debitorBalance=0,creditorBalance=0;
		
		System.out.println("Enter the account number to debit the amount :");
		int sender = scanner.nextInt();

		System.out.println("Enter the account number to credit the amount :");
		int reciever = scanner.nextInt();
		
		System.out.println("Enter the amout to be  transferred :");
		int amount = scanner.nextInt();
		
		Connection connection = DBConnection.getConnection();
		CallableStatement stat = connection.prepareCall("call transferAmountAndGetbalance(?,?,?,?,?)");
		stat.setInt(1, sender);
		stat.setInt(2, reciever);
		stat.setInt(3, amount);
		
		stat.registerOutParameter(4, Types.INTEGER);
		stat.setInt(4, debitorBalance);

		stat.registerOutParameter(5, Types.INTEGER);
		stat.setInt(5, creditorBalance);
		
		stat.execute();
		
		debitorBalance = stat.getInt(4);
		creditorBalance = stat.getInt(5);
		
		System.out.println("Transfer done/completed and the balance is : ");
		System.out.println("Debitor balance :"+debitorBalance);
		System.out.println("Creditor balance :"+creditorBalance);

		
	}
}
	