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
import main.java.hibernate.dao.SocialDAO;
import main.java.hibernate.model.Social;

@Path("/social")

@Consumes(MediaType.APPLICATION_XML)
@Produces(MediaType.APPLICATION_XML)
public class SocialResource {

    // HTTP request Methods

    // server Test
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/test")
    public String serverTest() {
	return "server test successful!";
    }

    // Get social by id
    @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("/social/{id}")
    public Response getSocial(@PathParam("id") int id) {

	Social social = new Social();
	social = SocialDAO.getSocial(id);
	return Response.status(Status.OK).entity(social).build();
    }

    // Get social with highest id
    @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("/socialWithHighestId/")
    public Response getSocialWithhighestId() {

	Social social = new Social();
	social = SocialDAO.getSocialWithHighestId();
	return Response.status(Status.OK).entity(social).build();
    }

    // Get list of all socials
    @GET
    @Produces(MediaType.APPLICATION_XML)
    // @Consumes(MediaType.APPLICATION_XML)
    @Path("/sociallist")
    public Response getSocialList() {

	List<Social> socials = new ArrayList<>();
	socials = SocialDAO.getSocials();
	GenericEntity<List<Social>> ml = new GenericEntity<List<Social>>(Lists.newArrayList(socials)) {
	};

	return Response.status(Status.OK).entity(ml).build();
    }

    // get socials by member id from MemberSocials table
    @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("/socialsByMember/{id}")
    public Response getSocialsByMember(@PathParam("id") int id) {

	List<Social> s = SocialDAO.getSocialsByMemberId(id);
	GenericEntity<List<Social>> sl = new GenericEntity<List<Social>>(Lists.newArrayList(s)) {
	};

	return Response.status(Status.OK).entity(sl).build();
    }

    // add new social
    @POST
    @Consumes(MediaType.APPLICATION_XML)
    @Path("/addSocial")
    public Response postSocial(Social newSocial) {

	SocialDAO.addSocial(newSocial);
	return Response.status(Status.CREATED).build();
    }

    // update social
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    @Path("/updateSocial/{id}")
    public Response putSocial(@PathParam("id") int id, Social alteredSocial) {

	SocialDAO.updateSocial(id, alteredSocial);
	return Response.status(Status.NOT_IMPLEMENTED).build();
    }

    // assign social to specific member in MemberSocials table
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    @Path("/addSocialToMember/{memberID}/{socialID}")
    public Response putSocial(@PathParam("memberID") int memberID, @PathParam("socialID") int socialID) {

	SocialDAO.addSocialToMember(memberID, socialID);
	return Response.status(Status.NOT_IMPLEMENTED).build();
    }

    // delete social
    @DELETE
    @Path("/deleteSocial/{id}")
    public Response deleteSocial(@PathParam("id") int id) {

	SocialDAO.deleteSocialFromMember(id);
	return Response.status(Status.NOT_IMPLEMENTED).build();
    }
}
