package org.sparsh.MessengerAPI.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public class CommentResource {
	
	// we can retrieve the parent uri path Parameters in the child 
	
	@GET
	@Produces(MediaType.TEXT_XML)
	public String welcome()
	{
		return "hello from subresource";
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.TEXT_XML)
	public String welcome1()
	{
		return "hello from subresoufce";
	}

}
