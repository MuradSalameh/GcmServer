package main.java.server;

import java.util.ArrayList;
import java.util.List;

import org.glassfish.jersey.internal.guava.Lists;

import main.java.hibernate.model.Genre;
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
import main.java.hibernate.dao.GenreDAO;

@Path("/genre")

@Consumes(MediaType.APPLICATION_XML)
@Produces(MediaType.APPLICATION_XML)
public class GenreResource {
	


	// server Test	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/test")
	public String serverTest() {
		return "server test successful!";
	}

	

	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("/genre/{id}")
	public Response getGenre(@PathParam("id") int id) { 
			
		Genre genre = new Genre();
		genre = GenreDAO.getGenre(id);	
		
		return Response.status(Status.OK).entity(genre).build();
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	//@Consumes(MediaType.APPLICATION_XML)
	@Path("/genrelist")
	public Response getGenreList() {		
	
		List<Genre> genres = new ArrayList<>();			
		genres = GenreDAO.getGenres();
		
		GenericEntity<List<Genre>> ml = new GenericEntity<List<Genre>>(Lists.newArrayList(genres)) {};
	    
		return Response.status(Status.OK).entity(ml).build();			
	}
	
	
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	@Path("/addGenre")
	public Response postGenre(Genre newGenre) {
		
		GenreDAO.addGenre(newGenre);	
		return Response.status(Status.CREATED).build();
		
	}

	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	@Path("/updateGenre/{id}")
	public Response putGenre(@PathParam("id")int id, Genre alteredGenre) {
		
		GenreDAO.updateGenre(id, alteredGenre);
		return Response.status(Status.NOT_IMPLEMENTED).build();
	}

	@DELETE
	@Path("/deleteGenre/{id}")
	public Response deleteGenre(@PathParam("id")int id) {
		GenreDAO.deleteGenre(id);
		return Response.status(Status.NOT_IMPLEMENTED).build();
	}

	 
}
