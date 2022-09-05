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
import main.java.hibernate.dao.PartnerDAO;
import main.java.hibernate.model.Partner;

@Path("/partner")

@Consumes(MediaType.APPLICATION_XML)
@Produces(MediaType.APPLICATION_XML)
public class PartnerResource {

    // HTTP request methods

    // server Test
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/test")
    public String serverTest() {
	return "server test successful!";
    }

    // get partner
    @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("/partner/{id}")
    public Response getPartner(@PathParam("id") int id) {

	Partner partner = new Partner();
	partner = PartnerDAO.getPartner(id);
	return Response.status(Status.OK).entity(partner).build();
    }

    // get list of all partners
    @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("/partnerlist")
    public Response getPartnerList() {

	List<Partner> partners = new ArrayList<>();
	partners = PartnerDAO.getPartners();
	GenericEntity<List<Partner>> ml = new GenericEntity<List<Partner>>(Lists.newArrayList(partners)) {
	};
	return Response.status(Status.OK).entity(ml).build();
    }

    // add new partner
    @POST
    @Consumes(MediaType.APPLICATION_XML)
    @Path("/addPartner")
    public Response postPartner(Partner newPartner) {

	PartnerDAO.addPartner(newPartner);
	return Response.status(Status.CREATED).build();
    }

    // update partner
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    @Path("/updatePartner/{id}")
    public Response putPartner(@PathParam("id") int id, Partner alteredPartner) {

	PartnerDAO.updatePartner(id, alteredPartner);
	return Response.status(Status.NOT_IMPLEMENTED).build();
    }

    // delete partner
    @DELETE
    @Path("/deletePartner/{id}")
    public Response deletePartner(@PathParam("id") int id) {
	PartnerDAO.deletePartner(id);
	return Response.status(Status.NOT_IMPLEMENTED).build();
    }
}
