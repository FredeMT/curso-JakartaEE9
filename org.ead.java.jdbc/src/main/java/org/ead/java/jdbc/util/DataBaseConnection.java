package org.ead.java.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
	private static String url = "jdbc:mysql://localhost:3306/estoque-db?serverTimezone=UTC";
	private static String username = "root";
	private static String password = "macaco";
	private static Connection connection;
	
	public static Connection getInstance() throws SQLException {
		if(connection == null) {
			connection = DriverManager.getConnection(url, username, password);
		}
		return connection;
	}
}
