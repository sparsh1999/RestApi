package org.sparsh.MessengerAPI.resources;

import java.net.URI;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import org.glassfish.jersey.server.Uri;
import org.sparsh.MessengerAPI.model.Message;
import org.sparsh.MessengerAPI.service.MessageService;

import com.sun.research.ws.wadl.Application;

@Path("/message")
@Produces(value = {MediaType.APPLICATION_JSON,MediaType.TEXT_XML})

public class MessageResource {

	MessageService service = new MessageService();
	
	// we can more than one mediatype respones 
	// also we need to specify multiple consumes mediatype
	@GET
	@Produces(value = {MediaType.APPLICATION_JSON,MediaType.TEXT_XML})
	public  List<Message> getAllMessage()
	{
		return service.getAllMssg();
	}
	
//	@GET
//	@Produces(MediaType.TEXT_XML)
//	public  List<Message> getAllMessage1()
//	{
//		return service.getAllMssg();
//	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Message getMessageById(@PathParam("id") int id)
	{
		return service.getMessage(id);
	}
	
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteMssg(@PathParam("id") int id)
	{
		return service.deleteMessage(id);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addMessage(Message mssg,@Context UriInfo uri)
	{
		// Response is used to send or change headers value like status code ,extra URI ,location
		// Responese.status(Status.value) can be used to only send status
		// to not use hardcoded address like /message/1/comment we use a  URIinfo here
		Message message = service.addMessage(mssg);
		String newId = String.valueOf(message.getId());
		URI uriNew = uri.getAbsolutePathBuilder().path(newId).build();
		return Response.created(uriNew).entity(message).build();
	}
	
	@PUT
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Message updateMssg(@PathParam("id") int id,Message mssg)
	{
		return service.updateMessage(mssg);
	}
	
	
	@Path("/{id}/comment")
	//@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public CommentResource operateComments()
	{
		return new CommentResource();
	}

}



