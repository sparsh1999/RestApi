package org.sparsh.MessengerAPI.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.sparsh.MessengerAPI.model.Message;
import org.sparsh.MessengerAPI.model.Profile;
import org.sparsh.MessengerAPI.service.MessageService;
import org.sparsh.MessengerAPI.service.ProfileService;

@Path("/profile")
public class ProfileResources {
	
	ProfileService service = new ProfileService();
	
	// queryparam is used to get query values
	// example    /profile?year=2018 here year is qeryparam
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public  List<Profile> getAllProfiles(@QueryParam("year") int year)
	{
		if (year==0)
		return service.getAllProfile();
		else
		return service.getAllProfileYear(year);
	}
	
	@GET
	@Path("/{uname}")
	@Produces(MediaType.APPLICATION_JSON)
	public Profile getProfileById(@PathParam("uname") String uname)
	{
		return service.getProfile(uname);
	}
	
	@DELETE
	@Path("/{uname}")
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteProfile(@PathParam("uname") String uname)
	{
		return service.deleteProfile(uname);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Profile addProfile(Profile prof)
	{
		return service.addProfile(prof);
	}
	
	@PUT
	@Path("/{uname}")
	@Produces(MediaType.APPLICATION_JSON)
	public Profile updateProfile(@PathParam("uname") String uname,Profile prof)
	{
		return service.updateProfile(prof);
	}

}
