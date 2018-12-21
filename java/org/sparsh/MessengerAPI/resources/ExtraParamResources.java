package org.sparsh.MessengerAPI.resources;

import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

@Path("/extraParam")

public class ExtraParamResources {
	
	// matrix param is like query param but with /profile ; year = 2018
	@GET
	public String getExtraParam(@MatrixParam("param") String param ,
			                    @HeaderParam("content-type") String content_type,
			                    @CookieParam("cookie") String cookie)
	{
		return param+" "+content_type+" "+cookie;
	}
	
	// URIINFO will take all the values of the URI
	@GET
	@Path("/context")
	public String getParamUri(@Context UriInfo uriinfo)
	{
		return uriinfo.getAbsolutePath().toString();
	}
}
