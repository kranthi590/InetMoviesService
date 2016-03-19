package com.inetmovies.services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/hello")
public class HelloWorldService {

	@GET
	@Path("/{param}")
	public Response getMsg(@PathParam("param") String msg) {

		String output = "Jersey say : " + msg;
		try {
			Connection connection = null;
			try {
				connection = DBConfig.getConnection();
			} catch (InstantiationException | IllegalAccessException e) {
				
				e.printStackTrace();
			}
			String query = "select * from actors limit 2";
			Map<Integer, String> params = new HashMap<>();
			ResultSet resultSet = DBConfig.executeQuery(query, connection, params);
			System.out.println(resultSet);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return Response.status(200).entity(output).build();

	}

}
