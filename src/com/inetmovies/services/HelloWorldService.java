package com.inetmovies.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.JsonObject;
import com.inetmovies.properties.DBProperties;

@Path("/")
public class HelloWorldService {

	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public String rootLink(@PathParam("param") String msg) {

		JsonObject object = new JsonObject();
		String ret = "";
		DBProperties dbProperties = new DBProperties();
		try {
			System.out.println(dbProperties.getPropValues());
			object.addProperty("response", "ok");
			ret = object.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}

}
