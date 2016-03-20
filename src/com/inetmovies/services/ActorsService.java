package com.inetmovies.services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.google.gson.Gson;
import com.inetmovies.models.Actors;

@Path("/actors")
public class ActorsService {

	@Path("/{param}")
	@GET
	public String getActors(@PathParam("param") String msg) {
		Integer limit = msg != null ? Integer.parseInt(msg) : 0;
		List<Actors> actors = new ArrayList<>();
		String ret = "";
		try {
			Gson gson = new Gson();
			Connection connection = null;
			connection = DBConfig.getConnection();
			String query = "select * from actors limit " + limit;
			Map<Integer, String> params = new HashMap<>();
			ResultSet resultSet = DBConfig.executeQuery(query, connection, params);

			while (resultSet.next()) {

				Actors actor = new Actors();
				actor.setId(resultSet.getInt("id"));
				actor.setFirst_name(resultSet.getString("first_name"));
				actor.setLast_name(resultSet.getString("last_name"));
				actor.setGender(resultSet.getString("gender").charAt(0));
				actors.add(actor);

			}
			ret = gson.toJson(actors);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

		return ret;
	}
}
