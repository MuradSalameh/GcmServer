package main.java.server;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("/gcm")

@Consumes(MediaType.APPLICATION_XML)
@Produces(MediaType.APPLICATION_XML)
public class GcmResource {
	
/*
	static {
		GcmDBReturn dr = Datenbank.createTable();
		if(!dr.isRc())
			System.out.println(dr.getMeldung());
	}

	*/
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/test")
	public String serverTest() {
		return "Test erfolgreich";
	}
	
	/*
	
		@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("wein")
	public Response getWeine() {
		GcmDBReturnData<WeinList> dr = Datenbank.leseWeine();
		if(dr.isRc()) {
			// WeinList wird automatisch auf XML serialisiert
			return Response.status(Status.OK).entity(dr.getData()).build();
		}
		else {
			// SQL Exception text an Client senden
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(dr.getMeldung()).build();
		}
	}
	

	
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	@Path("wein")
	public Response postWein(Wein neuerWein) {
		GcmDBReturn dr = Datenbank.insertWein(neuerWein);
		if(dr.isRc()) {
			return Response.status(Status.CREATED).build();
		}
		else {
			// SQL Exception text an Client senden
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(dr.getMeldung()).build();
		}
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	@Path("wein/{weinid}")
	public Response putWein(@PathParam("weinid")String weinid, Wein geaenderterWein) {
		return Response.status(Status.NOT_IMPLEMENTED).build();
	}
	
	@DELETE
	@Path("wein/{weinid}")
	public Response deleteWein(@PathParam("weinid")String id) {
		return Response.status(Status.NOT_IMPLEMENTED).build();
	}

*/
}
