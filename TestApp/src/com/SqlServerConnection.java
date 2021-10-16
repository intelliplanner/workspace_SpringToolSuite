package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlServerConnection {
	public static void main(String[] args) {
		String connectionUrl = "jdbc:sqlserver://localhost:1433;" + "database=ipssi_cgpl;" + "user=root;"
				+ "password=root;";
//		+ "encrypt=true;"+ "trustServerCertificate=false;" + "loginTimeout=30;";

		ResultSet resultSet = null;

		try (Connection connection = DriverManager.getConnection(connectionUrl);
				Statement statement = connection.createStatement();) {

			// Create and execute a SELECT SQL statement.
			String selectSql = "SELECT id,USERNAME FROM users";
			resultSet = statement.executeQuery(selectSql);

			// Print results from select statement
			while (resultSet.next()) {
				System.out.println(resultSet.getString(1) + " " + resultSet.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() throws SQLException {
		Connection retval = null;
		String connectionUrl = "jdbc:sqlserver://localhost:1433;" + "database=ipssi_cgpl;" + "user=root;"
				+ "password=root;";
		
		ResultSet resultSet = null;
		return retval = DriverManager.getConnection(connectionUrl);
	}

	public void returnConnection(Connection retConn, boolean destroyIt) {
		if (retConn == null)
			return;
		try {
			retConn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}