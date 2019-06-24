package com.exoscale.carassembly.config.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.exoscale.carassembly.config.api.model.Config;

@Path("config")
public interface ConfigService {
	
	@GET
	@Produces({ "application/json", "application/xml" })
	public Config get(@QueryParam("key") String key);

	@DELETE
	@Consumes({ "application/json", "application/xml" })
	@Produces({ "application/json", "application/xml" })
	public Config remove(@QueryParam("key") String key);
	
	@POST
	@Consumes({ "application/json", "application/xml" })
	@Produces({ "application/json", "application/xml" })
	public void add(@QueryParam("key") String key, @QueryParam("value") Object value);
	
}
