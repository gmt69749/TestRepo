package com.omantel.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionFactory {

	public static List<String> getPosDbConnection_TEST() {
		// TODO Auto-generated method stub
		List<String> counterList = new ArrayList<String>();
		Connection connection = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {

			Context context = new InitialContext();
			DataSource ds = (DataSource) context.lookup("java:/comp/env/jdbc/posdb_Test");
			connection = ds.getConnection();
			if(connection != null){
				stmt = connection.createStatement();
				rs = stmt.executeQuery("select * from dma_collection_center_ref where collection_center_id like 'IR%'");
				while(rs.next()){
					counterList.add(rs.getString("collection_center_id"));
				}
			}

		} catch (NamingException nee) {
			System.out.println("In naming exception block");
			nee.printStackTrace();
		} catch (SQLException ee) {
			System.out.println("In sql exception block");
			ee.printStackTrace();
		}
		finally{
			try{
			rs.close();
			stmt.close();
			connection.close();
			}catch(Exception eee){}
		}
		return counterList;
	}
	
	public static List<String> getPosDbConnection_Prod() {
		// TODO Auto-generated method stub
		List<String> counterList = new ArrayList<String>();
		Connection connection = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {

			Context context = new InitialContext();
			DataSource ds = (DataSource) context.lookup("java:/comp/env/jdbc/posdb_Prod");
			connection = ds.getConnection();
			if(connection != null){
				stmt = connection.createStatement();
				rs = stmt.executeQuery("select * from dma_collection_center_ref where collection_center_id like 'A%'");
				while(rs.next()){
					counterList.add(rs.getString("collection_center_id"));
				}
			}

		} catch (NamingException nee) {
			System.out.println("In naming exception block");
			nee.printStackTrace();
		} catch (SQLException ee) {
			System.out.println("In sql exception block");
			ee.printStackTrace();
		}
		finally{
			try{
			rs.close();
			stmt.close();
			connection.close();
			}catch(Exception eee){}
		}
		return counterList;
	}
	
	public static String getConnection() {
		// TODO Auto-generated method stub
		Connection connection = null;
		try {

			Context context = new InitialContext();
			DataSource ds = (DataSource) context.lookup("java:/comp/env/jdbc/posdb");
			connection = ds.getConnection();
			if (connection == null) {
				System.out.println("No Connection exist");
				return "No Connection exist??????????";
			} else {
				System.out.println("Connection exist");
				return "Connection exist**************";
			}

		} catch (NamingException nee) {
			System.out.println("In naming exception block");
			nee.printStackTrace();
			return "Naming Exception **************";
		} catch (SQLException ee) {
			System.out.println("In sql exception block");
			ee.printStackTrace();
			return "SQL Exception **************";
		}
	}

	public static String displayUser() {
		return "Gurmeet Singh";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection connection = null;
		try {

			Context context = new InitialContext();
			DataSource ds = (DataSource) context.lookup("java:/comp/env/jdbc/posdb");
			connection = ds.getConnection();
			if (connection == null) {
				System.out.println("No Connection exist");
			} else {
				System.out.println("Connection exist");
			}

		} catch (NamingException nee) {
			System.out.println("In naming exception block");
			nee.printStackTrace();
		} catch (SQLException ee) {
			System.out.println("In sql exception block");
			ee.printStackTrace();
		}

	}

}
