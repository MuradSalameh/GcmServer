package main.java.server;

import java.util.ArrayList;
import java.util.List;

import org.glassfish.jersey.internal.guava.Lists;

import main.java.hibernate.model.RevenueType;
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
import main.java.hibernate.dao.RevenueTypeDAO;

@Path("/revenueType")

@Consumes(MediaType.APPLICATION_XML)
@Produces(MediaType.APPLICATION_XML)
public class RevenueTypeResource {
	


	// server Test	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/test")
	public String serverTest() {
		return "server test successful!";
	}

	

	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("/revenueType/{id}")
	public Response getRevenueType(@PathParam("id") int id) { 
			
		RevenueType revenueType = new RevenueType();
		revenueType = RevenueTypeDAO.getRevenueType(id);	
		
		return Response.status(Status.OK).entity(revenueType).build();
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	//@Consumes(MediaType.APPLICATION_XML)
	@Path("/revenueTypelist")
	public Response getRevenueTypeList() {		
	
		List<RevenueType> revenueTypes = new ArrayList<>();			
		revenueTypes = RevenueTypeDAO.getRevenueTypes();
		
		GenericEntity<List<RevenueType>> ml = new GenericEntity<List<RevenueType>>(Lists.newArrayList(revenueTypes)) {};
	    
		return Response.status(Status.OK).entity(ml).build();			
	}
	
	
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	@Path("/addRevenueType")
	public Response postRevenueType(RevenueType newRevenueType) {
		
		RevenueTypeDAO.addRevenueType(newRevenueType);	
		return Response.status(Status.CREATED).build();
		
	}

	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	@Path("/updateRevenueType/{id}")
	public Response putRevenueType(@PathParam("id")int id, RevenueType alteredRevenueType) {
		
		RevenueTypeDAO.updateRevenueType(id, alteredRevenueType);
		return Response.status(Status.NOT_IMPLEMENTED).build();
	}

	@DELETE
	@Path("/deleteRevenueType/{id}")
	public Response deleteRevenueType(@PathParam("id")int id) {
		RevenueTypeDAO.deleteRevenueType(id);
		return Response.status(Status.NOT_IMPLEMENTED).build();
	}

	 
}
