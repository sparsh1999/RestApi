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
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response.Status;

import org.glassfish.jersey.server.Uri;
import org.sparsh.MessengerAPI.exception.DataNotFoundException;
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
	
	// Exception handling described on DataNotFoundExcption class
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Message getMessageById(@PathParam("id") int id)
	{
		Message msg = service.getMessage(id);
		Exception exception = new Exception("not found",404,"www.google.com");
		Response response = Response.status(Status.NOT_FOUND).entity(exception).build();
		
		if (msg == null)
		{
		throw new WebApplicationException(response);
		
		// we can also throw directly RedirectException or any other subclass of WebApplicationException
		// they have already implemented status code etc;
		}
		return msg;
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
		
		// adding link 
		 message.addLink(extractLink(uri, mssg).toString(), "self");
		 message.addLink(getLinkForSubresource(mssg,uri), "comment");
		 
		return Response.created(extractLink(uri,mssg)).entity(message).build();
	}

	private String getLinkForSubresource(Message mssg, UriInfo uri) {

	// for subresource we need to traverse the whole uri from parent to subresource 
	// also there might be any pathParamenter so we need to resolve it use resolveTemplate()
        URI uri1 = uri.getBaseUriBuilder().path(MessageResource.class)
        		                          .path(MessageResource.class,"operateComments")
        		                          .path(CommentResource.class)
        		                          .resolveTemplate("id",mssg.getId())
        		                          .build();
        return uri1.toString();
	}

	private URI extractLink(UriInfo uri, Message message) {
		
		String newId = String.valueOf(message.getId());
		//path(myResource.class) will return /message or class level path
		URI uriNew = uri.getAbsolutePathBuilder().path(newId).build();
		return uriNew;
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



