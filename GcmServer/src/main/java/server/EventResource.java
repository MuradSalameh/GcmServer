package main.java.server;

import java.util.ArrayList;
import java.util.List;

import org.glassfish.jersey.internal.guava.Lists;

import main.java.hibernate.model.Event;
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
import main.java.hibernate.dao.EventDAO;

@Path("/event")

@Consumes(MediaType.APPLICATION_XML)
@Produces(MediaType.APPLICATION_XML)
public class EventResource {
	


	// server Test	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/test")
	public String serverTest() {
		return "server test successful!";
	}

	

	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("/event/{id}")
	public Response getEvent(@PathParam("id") int id) { 
			
		Event event = new Event();
		event = EventDAO.getEvent(id);	
		
		return Response.status(Status.OK).entity(event).build();
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	//@Consumes(MediaType.APPLICATION_XML)
	@Path("/eventlist")
	public Response getEventList() {		
	
		List<Event> events = new ArrayList<>();			
		events = EventDAO.getEvents();
		
		GenericEntity<List<Event>> ml = new GenericEntity<List<Event>>(Lists.newArrayList(events)) {};
	    
		return Response.status(Status.OK).entity(ml).build();			
	}
	
	
	@GET 
	@Produces(MediaType.APPLICATION_XML)
	@Path("/eventsByMember/{id}")
	public Response getEventsByMember(@PathParam("id") int id) { 
		List<Event> s = EventDAO.getEventsByMemberId(id);
				
		GenericEntity<List<Event>> sl = new GenericEntity<List<Event>>(Lists.newArrayList(s)) {};
	    
		return Response.status(Status.OK).entity(sl).build();	
	}
	
	
	
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	@Path("/addEvent")
	public Response postEvent(Event newEvent) {
		
		EventDAO.addEvent(newEvent);	
		return Response.status(Status.CREATED).build();
		
	}

	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	@Path("/updateEvent/{id}")
	public Response putEvent(@PathParam("id")int id, Event alteredEvent) {
		
		EventDAO.updateEvent(id, alteredEvent);
		return Response.status(Status.NOT_IMPLEMENTED).build();
	}
	
	@DELETE
	@Path("/deleteEventFromMember/{id}")
	public Response deleteEventFromMember(@PathParam("id")int id) {
		EventDAO.deleteEventFromMember(id);
		return Response.status(Status.NOT_IMPLEMENTED).build();
	}
	

	@DELETE
	@Path("/deleteEvent/{id}")
	public Response deleteEvent(@PathParam("id")int id) {
		EventDAO.deleteEvent(id);
		return Response.status(Status.NOT_IMPLEMENTED).build();
	}

	 
}
