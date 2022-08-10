package main.java.server;

import java.util.ArrayList;
import java.util.List;

import org.glassfish.jersey.internal.guava.Lists;


import main.java.hibernate.model.Social;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.GenericEntity;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

import main.java.hibernate.dao.SocialDAO;

@Path("/social")

@Consumes(MediaType.APPLICATION_XML)
@Produces(MediaType.APPLICATION_XML)
public class SocialResource {
	


	// server Test	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/test")
	public String serverTest() {
		return "server test successful!";
	}

	

	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("/social/{id}")
	public Response getSocial(@PathParam("id") int id) { 
			
		Social social = new Social();
		social = SocialDAO.getSocial(id);	
		
		return Response.status(Status.OK).entity(social).build();
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	//@Consumes(MediaType.APPLICATION_XML)
	@Path("/sociallist")
	public Response getSocialList() {		
	
		List<Social> socials = new ArrayList<>();			
		socials = SocialDAO.getSocials();
		
		GenericEntity<List<Social>> ml = new GenericEntity<List<Social>>(Lists.newArrayList(socials)) {};
	    
		return Response.status(Status.OK).entity(ml).build();			
	}
	
	@GET 
	@Produces(MediaType.APPLICATION_XML)
	@Path("/socialsByMember/{id}")
	public Response getSocialsByMember(@PathParam("id") int id) { 
		List<Social> s = SocialDAO.getSocialsByMemberId(id);
				
		GenericEntity<List<Social>> sl = new GenericEntity<List<Social>>(Lists.newArrayList(s)) {};
	    
		return Response.status(Status.OK).entity(sl).build();	
	}
	
	
	
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	@Path("/addSocial")
	public Response postSocial(Social newSocial) {
		
		SocialDAO.addSocial(newSocial);	
		return Response.status(Status.CREATED).build();
		
	}

	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	@Path("/updateSocial/{id}")
	public Response putSocial(@PathParam("id")int id, Social alteredSocial) {
		
		SocialDAO.updateSocial(id, alteredSocial);
		return Response.status(Status.NOT_IMPLEMENTED).build();
	}

	@DELETE
	@Path("/deleteSocial/{id}")
	public Response deleteSocial(@PathParam("id")int id) {
		SocialDAO.deleteSocial(id);
		return Response.status(Status.NOT_IMPLEMENTED).build();
	}

	 
}
