package com.inetmovies.services;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.Properties;
import java.util.Map.Entry;

import com.inetmovies.properties.DBProperties;
import com.mysql.jdbc.PreparedStatement;

public class DBConfig {

	static public Connection connection = null;

	public static Connection getConnection()
			throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		DBProperties properties = new DBProperties();
		Properties prop;
		try {
			prop = properties.getPropValues();
			if (connection == null) {
				Class.forName(prop.getProperty("JDBC_DRIVER")).newInstance();
				connection = DriverManager.getConnection(prop.getProperty("DB_URL"), prop.getProperty("USER"),
						prop.getProperty("PASS"));
				System.out.println("Connection created...");
			}
		} catch (IOException e) {
			e.printStackTrace();
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
