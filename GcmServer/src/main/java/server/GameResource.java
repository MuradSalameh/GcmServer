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
import main.java.hibernate.dao.GameDAO;
import main.java.hibernate.model.Game;

@Path("/game")
@Consumes(MediaType.APPLICATION_XML)
@Produces(MediaType.APPLICATION_XML)
public class GameResource {

    // HTTP request methods

    // server Test
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/test")
    public String serverTest() {
	return "server test successful!";
    }

    // game
    @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("/game/{id}")
    public Response getGame(@PathParam("id") int id) {

	Game game = new Game();
	game = GameDAO.getGame(id);
	return Response.status(Status.OK).entity(game).build();
    }

    // get list of all games
    @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("/gamelist")
    public Response getGameList() {

	List<Game> games = new ArrayList<>();
	games = GameDAO.getGames();
	GenericEntity<List<Game>> g = new GenericEntity<List<Game>>(Lists.newArrayList(games)) {
	};

	return Response.status(Status.OK).entity(g).build();
    }

    // get games by member id from MemberGames table
    @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("/gamesByMember/{id}")
    public Response getGamesByMember(@PathParam("id") int id) {

	List<Game> s = GameDAO.getGamesByMemberId(id);
	GenericEntity<List<Game>> sl = new GenericEntity<List<Game>>(Lists.newArrayList(s)) {
	};

	return Response.status(Status.OK).entity(sl).build();
    }

    // get games by tournament from Tournament Games table
    @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("/getGamesByTournamentId/{id}")
    public Response getGamesByTournamentId(@PathParam("id") int id) {

	List<Game> s = GameDAO.getGamesByTournamentId(id);
	GenericEntity<List<Game>> sl = new GenericEntity<List<Game>>(Lists.newArrayList(s)) {
	};

	return Response.status(Status.OK).entity(sl).build();
    }

    // add new game
    @POST
    @Consumes(MediaType.APPLICATION_XML)
    @Path("/addGame")
    public Response postGame(Game newGame) {

	GameDAO.addGame(newGame);
	return Response.status(Status.CREATED).build();

    }

    // assign game to member in MemberGames table
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    @Path("/addGameToMember/{memberID}/{gameID}")
    public Response putGame(@PathParam("memberID") int memberID, @PathParam("gameID") int gameID) {

	GameDAO.addGameToMember(memberID, gameID);
	return Response.status(Status.NOT_IMPLEMENTED).build();
    }

    // assign game to tournament in TournamtGame table
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    @Path("/addGameToTournament/{gameId}/{tournamentId}")
    public Response addGameToTournament(@PathParam("gameId") int gameId, @PathParam("tournamentId") int tournamentId) {

	GameDAO.addGameToTournament(gameId, tournamentId);
	return Response.status(Status.NOT_IMPLEMENTED).build();
    }

    // update game
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    @Path("/updateGame/{id}")
    public Response putGame(@PathParam("id") int id, Game alteredGame) {

	GameDAO.updateGame(id, alteredGame);
	return Response.status(Status.NOT_IMPLEMENTED).build();
    }

    // delete game from Member in MemberGames table
    @DELETE
    @Path("/deleteGameFromMember/{gameid}/{memberid}")
    public Response deleteGameFromMember(@PathParam("gameid") int gameid, @PathParam("memberid") int memberid) {

	GameDAO.deleteGameFromMember(gameid, memberid);
	return Response.status(Status.NOT_IMPLEMENTED).build();
    }

    // delete game from all members in MemberGames table
    @DELETE
    @Path("/deleteGameFromAllMembers/{id}")
    public Response deleteGameFromAllMembers(@PathParam("id") int id) {

	GameDAO.deleteGameFromAllMembers(id);
	return Response.status(Status.NOT_IMPLEMENTED).build();
    }

    // delete game from specific tournament in TournamentGame table
    @DELETE
    @Path("/deleteGameFromTournament/{gameid}/{tournamentid}")
    public Response deleteGameFromTournament(@PathParam("gameid") int gameid,
	    @PathParam("tournamentid") int tournamentid) {

	GameDAO.deleteGameFromTournament(gameid, tournamentid);
	return Response.status(Status.NOT_IMPLEMENTED).build();
    }

    // delete game from all tournaments in TournamentGame table
    @DELETE
    @Path("/deleteGameFromAllTournaments/{id}")
    public Response deleteGameFromAllTournaments(@PathParam("id") int id) {

	GameDAO.deleteGameFromAllTournaments(id);
	return Response.status(Status.NOT_IMPLEMENTED).build();
    }

    // delete game
    @DELETE
    @Path("/deleteGame/{id}")
    public Response deleteGame(@PathParam("id") int id) {

	GameDAO.deleteGame(id);
	return Response.status(Status.NOT_IMPLEMENTED).build();
    }

}
