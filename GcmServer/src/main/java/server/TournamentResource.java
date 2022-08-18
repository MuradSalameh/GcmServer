package main.java.server;

import java.util.ArrayList;
import java.util.List;

import org.glassfish.jersey.internal.guava.Lists;

import main.java.hibernate.model.Tournament;
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
import main.java.hibernate.dao.TournamentDAO;

@Path("/tournament")

@Consumes(MediaType.APPLICATION_XML)
@Produces(MediaType.APPLICATION_XML)
public class TournamentResource {
	


	// server Test	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/test")
	public String serverTest() {
		return "server test successful!";
	}

	

	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("/tournament/{id}")
	public Response getTournament(@PathParam("id") int id) { 
			
		Tournament tournament = new Tournament();
		tournament = TournamentDAO.getTournament(id);	
		
		return Response.status(Status.OK).entity(tournament).build();
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	//@Consumes(MediaType.APPLICATION_XML)
	@Path("/tournamentlist")
	public Response getTournamentList() {		
	
		List<Tournament> tournaments = new ArrayList<>();			
		tournaments = TournamentDAO.getTournaments();
		
		GenericEntity<List<Tournament>> ml = new GenericEntity<List<Tournament>>(Lists.newArrayList(tournaments)) {};
	    
		return Response.status(Status.OK).entity(ml).build();			
	}
	
	
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	@Path("/addTournament")
	public Response postTournament(Tournament newTournament) {
		
		TournamentDAO.addTournament(newTournament);	
		return Response.status(Status.CREATED).build();
		
	}

	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	@Path("/updateTournament/{id}")
	public Response putTournament(@PathParam("id")int id, Tournament alteredTournament) {
		
		TournamentDAO.updateTournament(id, alteredTournament);
		return Response.status(Status.NOT_IMPLEMENTED).build();
	}

	@DELETE
	@Path("/deleteTournament/{id}")
	public Response deleteTournament(@PathParam("id")int id) {
		TournamentDAO.deleteTournament(id);
		return Response.status(Status.NOT_IMPLEMENTED).build();
	}
	
	@DELETE
	@Path("/deleteTournamentFromTeams/{id}")
	public Response deleteTournamentsFromTeams(@PathParam("id")int id) {
		TournamentDAO.deleteTournamentsFromTeams(id);
		return Response.status(Status.NOT_IMPLEMENTED).build();
	}
	
	@DELETE
	@Path("/deleteTournamentFromGame/{id}")
	public Response deleteTournamentFromGame(@PathParam("id")int id) {
		TournamentDAO.deleteTournamentFromGame(id);
		return Response.status(Status.NOT_IMPLEMENTED).build();
	}
	

	 
}
