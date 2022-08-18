package main.java.server;

import java.util.ArrayList;
import java.util.List;

import org.glassfish.jersey.internal.guava.Lists;

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
import main.java.hibernate.dao.TeamDAO;
import main.java.hibernate.model.Member;
import main.java.hibernate.model.Team;

@Path("/team")

@Consumes(MediaType.APPLICATION_XML)
@Produces(MediaType.APPLICATION_XML)
public class TeamResource {

	// server Test
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/test")
	public String serverTest() {
		return "server test successful!";
	}

	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("/team/{id}")
	public Response getTeam(@PathParam("id") int id) {

		Team team = new Team();
		team = TeamDAO.getTeam(id);

		return Response.status(Status.OK).entity(team).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_XML)
	// @Consumes(MediaType.APPLICATION_XML)
	@Path("/teamlist")
	public Response getTeamList() {

		List<Team> teams = new ArrayList<>();
		teams = TeamDAO.getTeams();

		GenericEntity<List<Team>> ml = new GenericEntity<List<Team>>(Lists.newArrayList(teams)) {
		};

		return Response.status(Status.OK).entity(ml).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("/teamsByMember/{id}")
	public Response getTeamsByMember(@PathParam("id") int id) {

		List<Team> teams = TeamDAO.getTeamsByMemberId(id);

		GenericEntity<List<Team>> ml = new GenericEntity<List<Team>>(Lists.newArrayList(teams)) {
		};

		return Response.status(Status.OK).entity(ml).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("/getTeamsByTournamentId/{id}")
	public Response getTeamsByTournamentId(@PathParam("id") int id) {

		List<Team> teams = TeamDAO.getTeamsByTournamentId(id);

		GenericEntity<List<Team>> ml = new GenericEntity<List<Team>>(Lists.newArrayList(teams)) {
		};

		return Response.status(Status.OK).entity(ml).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("/membersByTeam/{id}")
	public Response getMembersByTeam(@PathParam("id") int id) {

		List<Member> members = TeamDAO.getMembersByTeamId(id);

		GenericEntity<List<Member>> ml = new GenericEntity<List<Member>>(Lists.newArrayList(members)) {
		};

		return Response.status(Status.OK).entity(ml).build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_XML)
	@Path("/addTeam")
	public Response postTeam(Team newTeam) {

		TeamDAO.addTeam(newTeam);
		return Response.status(Status.CREATED).build();

	}

	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	@Path("/addTeamToTournament/{teamId}/{tournamentId}")
	public Response addTeamToTournament(@PathParam("teamId") int teamId, @PathParam("tournamentId") int tournamentId) {

		TeamDAO.addTeamToTournament(teamId, tournamentId);
		return Response.status(Status.NOT_IMPLEMENTED).build();
	}

	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	@Path("/updateTeam/{id}")
	public Response putTeam(@PathParam("id") int id, Team alteredTeam) {

		TeamDAO.updateTeam(id, alteredTeam);
		return Response.status(Status.NOT_IMPLEMENTED).build();
	}

	@DELETE
	@Path("/deleteTeam/{id}")
	public Response deleteTeam(@PathParam("id") int id) {
		TeamDAO.deleteTeam(id);
		return Response.status(Status.NOT_IMPLEMENTED).build();
	}

	@DELETE
	@Path("/deleteTeamFromMember/{id}")
	public Response deleteTeamFromMember(@PathParam("id") int id) {
		TeamDAO.deleteTeamFromMember(id);
		return Response.status(Status.NOT_IMPLEMENTED).build();
	}

	@DELETE
	@Path("/deleteTeamFromTournaments/{id}")
	public Response deleteTeamFromTournaments(@PathParam("id") int id) {
		TeamDAO.deleteTeamFromTournaments(id);
		return Response.status(Status.NOT_IMPLEMENTED).build();
	}

	@DELETE
	@Path("/deleteTeamFromTournament/{teamid}/{tournamentid}")
	public Response deleteTeamFromTournament(@PathParam("teamid") int teamid,
			@PathParam("tournamentid") int tournamentid) {
		TeamDAO.deleteTeamFromTournament(teamid, tournamentid);
		return Response.status(Status.NOT_IMPLEMENTED).build();
	}

}
