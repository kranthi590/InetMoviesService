package com.inetmovies.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.Map.Entry;

import com.mysql.jdbc.PreparedStatement;

public class DBConfig {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://192.168.1.7/imdb";
	static final String USER = "insetmovies";
	static final String PASS = "pass123$";

	static public Connection connection = null;

	public static Connection getConnection() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		if (connection == null) {
			Class.forName(JDBC_DRIVER).newInstance();
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Connection created...");
		}
		return connection;
	}

	public static ResultSet executeQuery(String query, Connection connection, Map<Integer, String> params)
			throws SQLException {
		if (connection != null && (query != null && !query.isEmpty())) {
			PreparedStatement statement = (PreparedStatement) connection.prepareStatement(query);
			for (Entry<Integer, String> entry : params.entrySet()) {
				statement.setString(entry.getKey(), entry.getValue());
			}
			return statement.executeQuery();
		}
		return null;
	}
}
