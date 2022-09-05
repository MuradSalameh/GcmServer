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
import main.java.hibernate.dao.MemberDAO;
import main.java.hibernate.model.Member;

@Path("/member")
@Consumes(MediaType.APPLICATION_XML)
@Produces(MediaType.APPLICATION_XML)
public class MemberResource {

    // HTTP request methods

    // server Test
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/test")
    public String serverTest() {
	return "server test successful!";
    }

    // add new member
    @POST
    @Consumes(MediaType.APPLICATION_XML)
    @Path("/addMember")
    public Response postMember(Member newMember) {

	MemberDAO.addMember(newMember);
	return Response.status(Status.CREATED).build();

    }

    // assign member to team in MemberTeams table
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    @Path("/addMemberToTeam/{memberID}/{teamID}")
    public Response addMemberToTeam(@PathParam("memberID") int memberID, @PathParam("teamID") int teamID) {

	MemberDAO.addMemberToTeam(memberID, teamID);
	return Response.status(Status.NOT_IMPLEMENTED).build();
    }

    // get member
    @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("/member/{id}")
    public Response getMember(@PathParam("id") int id) {

	Member member = new Member();
	member = MemberDAO.getMember(id);
	return Response.status(Status.OK).entity(member).build();
    }

    // get member with highest id
    @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("/memberWithHighestId/")
    public Response getMemberWithhighestId() {

	Member member = new Member();
	member = MemberDAO.getMemberWithHighestId();
	return Response.status(Status.OK).entity(member).build();
    }

    // get list of all members
    @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("/memberlist")
    public Response getMemberList() {

	List<Member> members = new ArrayList<>();
	members = MemberDAO.getMembers();

	GenericEntity<List<Member>> ml = new GenericEntity<List<Member>>(Lists.newArrayList(members)) {
	};

	return Response.status(Status.OK).entity(ml).build();
    }

    // get all members who have birthday today
    @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("/getTodaysMembersBirthdays")
    public Response getTodaysMembersBirthdays() {

	List<Member> members = new ArrayList<>();
	members = MemberDAO.getTodaysMembersBirthdays();
	GenericEntity<List<Member>> ml = new GenericEntity<List<Member>>(Lists.newArrayList(members)) {
	};

	return Response.status(Status.OK).entity(ml).build();
    }

    // get members by team id from MemberTeam table
    @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("/getMembersByTeamId/{id}")
    public Response getMembersByTeamId(@PathParam("id") int id) {
	System.out.println("getMembersByTeamId" + " " + id);

	List<Member> members = new ArrayList<>();
	members = MemberDAO.getMembersByTeamId(id);
	GenericEntity<List<Member>> ml = new GenericEntity<List<Member>>(Lists.newArrayList(members)) {
	};

	return Response.status(Status.OK).entity(ml).build();
    }

    // update member
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    @Path("/updateMember/{id}")
    public Response putMember(@PathParam("id") int id, Member alteredMember) {

	MemberDAO.updateMember(id, alteredMember);
	return Response.status(Status.NOT_IMPLEMENTED).build();
    }

    // delete member from team in MemberTeam table
    @DELETE
    @Path("/deleteMemberFromTeam/{memberid}/{teamid}")
    public Response deleteMemberFromTeam(@PathParam("memberid") int memberid, @PathParam("teamid") int teamid) {

	MemberDAO.deleteMemberFromTeam(memberid, teamid);
	return Response.status(Status.NOT_IMPLEMENTED).build();
    }

    // delete member
    @DELETE
    @Path("/deleteMember/{id}")
    public Response deleteMember(@PathParam("id") int id) {

	MemberDAO.deleteMember(id);
	return Response.status(Status.NOT_IMPLEMENTED).build();
    }

    // delete member from event in MemberEvents table
    @DELETE
    @Path("/deleteMemberFromEvents/{id}")
    public Response deleteMemberFromEvents(@PathParam("id") int id) {

	MemberDAO.deleteMemberFromEvents(id);
	return Response.status(Status.NOT_IMPLEMENTED).build();
    }

    // delete member from all teams in MemberTeam table
    @DELETE
    @Path("/deleteMemberFromTeams/{id}")
    public Response deleteMemberFromTeams(@PathParam("id") int id) {

	MemberDAO.deleteMemberFromTeams(id);
	return Response.status(Status.NOT_IMPLEMENTED).build();
    }

    // delete member from all games in MemberGames Table
    @DELETE
    @Path("/deleteMemberFromGames/{id}")
    public Response deleteMemberFromGames(@PathParam("id") int id) {

	MemberDAO.deleteMemberFromGames(id);
	return Response.status(Status.NOT_IMPLEMENTED).build();
    }

    // delete member from all roles in MemberRoles table
    @DELETE
    @Path("/deleteMemberFromRoles/{id}")
    public Response deleteRoleFromMember(@PathParam("id") int id) {

	MemberDAO.deleteMemberFromRoles(id);
	return Response.status(Status.NOT_IMPLEMENTED).build();
    }

    // delete member from all socials in MemberSocials table
    @DELETE
    @Path("/deleteMemberFromSocials/{id}")
    public Response deleteMemberFromSocials(@PathParam("id") int id) {

	MemberDAO.deleteMemberFromSocials(id);
	return Response.status(Status.NOT_IMPLEMENTED).build();
    }

}
