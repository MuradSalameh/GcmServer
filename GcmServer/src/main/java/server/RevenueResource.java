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
import main.java.hibernate.dao.RevenueDAO;
import main.java.hibernate.model.Revenue;

@Path("/revenue")

@Consumes(MediaType.APPLICATION_XML)
@Produces(MediaType.APPLICATION_XML)
public class RevenueResource {

    // HTTP request methods

    // server Test
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/test")
    public String serverTest() {
	return "server test successful!";
    }

    // get revenue
    @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("/revenue/{id}")
    public Response getRevenue(@PathParam("id") int id) {

	Revenue revenue = new Revenue();
	revenue = RevenueDAO.getRevenue(id);
	return Response.status(Status.OK).entity(revenue).build();
    }

    // get list of all revenues
    @GET
    @Produces(MediaType.APPLICATION_XML)
    // @Consumes(MediaType.APPLICATION_XML)
    @Path("/revenuelist")
    public Response getRevenueList() {

	List<Revenue> revenues = new ArrayList<>();
	revenues = RevenueDAO.getRevenues();
	GenericEntity<List<Revenue>> ml = new GenericEntity<List<Revenue>>(Lists.newArrayList(revenues)) {
	};

	return Response.status(Status.OK).entity(ml).build();
    }

    // add new revenue
    @POST
    @Consumes(MediaType.APPLICATION_XML)
    @Path("/addRevenue")
    public Response postRevenue(Revenue newRevenue) {

	RevenueDAO.addRevenue(newRevenue);
	return Response.status(Status.CREATED).build();
    }

    // update revenue
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    @Path("/updateRevenue/{id}")
    public Response putRevenue(@PathParam("id") int id, Revenue alteredRevenue) {

	RevenueDAO.updateRevenue(id, alteredRevenue);
	return Response.status(Status.NOT_IMPLEMENTED).build();
    }

    // delete revenue
    @DELETE
    @Path("/deleteRevenue/{id}")
    public Response deleteRevenue(@PathParam("id") int id) {
	RevenueDAO.deleteRevenue(id);
	return Response.status(Status.NOT_IMPLEMENTED).build();
    }
}
