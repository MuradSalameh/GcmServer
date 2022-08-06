package main.java.server;

import java.util.ArrayList;
import java.util.List;

import org.glassfish.jersey.internal.guava.Lists;

import main.java.hibernate.model.Member;
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
import main.java.hibernate.dao.MemberDAO;

@Path("/member")

@Consumes(MediaType.APPLICATION_XML)
@Produces(MediaType.APPLICATION_XML)
public class MemberResource {
	


	// server Test	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/test")
	public String serverTest() {
		return "server test successful!";
	}

	

	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("/member/{id}")
	public Response getMember(@PathParam("id") int id) { 
			
		Member member = new Member();
		member = MemberDAO.getMember(id);	
		
		return Response.status(Status.OK).entity(member).build();
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	//@Consumes(MediaType.APPLICATION_XML)
	@Path("/memberlist")
	public Response getMemberList() {		
	
		List<Member> members = new ArrayList<>();			
		members = MemberDAO.getMembers();
		
		GenericEntity<List<Member>> ml = new GenericEntity<List<Member>>(Lists.newArrayList(members)) {};
	    
		return Response.status(Status.OK).entity(ml).build();			
	}
	
	
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	@Path("/addMember")
	public Response postMember(Member newMember) {
		
		MemberDAO.addMember(newMember);	
		return Response.status(Status.CREATED).build();
		
	}

	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	@Path("/updateMember/{id}")
	public Response putMember(@PathParam("memberid")int id, Member alteredMember) {
		
		MemberDAO.updateMember(id, alteredMember);
		return Response.status(Status.NOT_IMPLEMENTED).build();
	}

	@DELETE
	@Path("/deleteMember/{id}")
	public Response deleteMember(@PathParam("id")int id) {
		MemberDAO.deleteMember(id);
		return Response.status(Status.NOT_IMPLEMENTED).build();
	}

	 
}
