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
import main.java.hibernate.dao.RoleDAO;
import main.java.hibernate.model.Role;

@Path("/role")

@Consumes(MediaType.APPLICATION_XML)
@Produces(MediaType.APPLICATION_XML)
public class RoleResource {

    // HTTP request methods

    // server Test
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/test")
    public String serverTest() {
	return "server test successful!";
    }

    // get role by id
    @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("/role/{id}")
    public Response getRole(@PathParam("id") int id) {

	Role role = new Role();
	role = RoleDAO.getRole(id);
	return Response.status(Status.OK).entity(role).build();
    }

    // get role with highest id
    @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("/roleWithHighestId/")
    public Response getRoleWithhighestId() {

	Role role = new Role();
	role = RoleDAO.getRoleWithHighestId();
	return Response.status(Status.OK).entity(role).build();
    }

    // get list of all roles
    @GET
    @Produces(MediaType.APPLICATION_XML)
    // @Consumes(MediaType.APPLICATION_XML)
    @Path("/rolelist")
    public Response getRoleList() {

	List<Role> roles = new ArrayList<>();
	roles = RoleDAO.getRoles();
	GenericEntity<List<Role>> ml = new GenericEntity<List<Role>>(Lists.newArrayList(roles)) {
	};

	return Response.status(Status.OK).entity(ml).build();
    }

    // get roles by member id from MemberRoles table
    @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("rolesByMember/{id}")
    public Response getRolesByMember(@PathParam("id") int id) {

	List<Role> roles = RoleDAO.getRolesByMemberId(id);
	GenericEntity<List<Role>> ml = new GenericEntity<List<Role>>(Lists.newArrayList(roles)) {
	};

	return Response.status(Status.OK).entity(ml).build();
    }

    // add new role
    @POST
    @Consumes(MediaType.APPLICATION_XML)
    @Path("/addRole")
    public Response postRole(Role newRole) {

	RoleDAO.addRole(newRole);
	return Response.status(Status.CREATED).build();
    }

    // update role
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    @Path("/updateRole/{id}")
    public Response putRole(@PathParam("id") int id, Role alteredRole) {

	RoleDAO.updateRole(id, alteredRole);
	return Response.status(Status.NOT_IMPLEMENTED).build();
    }

    // assign role to member in MemberRoles table
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    @Path("/addRoleToMember/{memberID}/{roleID}")
    public Response putRole(@PathParam("memberID") int memberID, @PathParam("roleID") int roleID) {

	RoleDAO.addRoleToMember(memberID, roleID);
	return Response.status(Status.NOT_IMPLEMENTED).build();
    }

    // delete role
    @DELETE
    @Path("/deleteRole/{id}")
    public Response deleteRole(@PathParam("id") int id) {

	RoleDAO.deleteRole(id);
	return Response.status(Status.NOT_IMPLEMENTED).build();
    }

    // delete role assignment from specific member in MemberRoles table
    @DELETE
    @Path("/deleteRoleFromMember/{roleid}/{memberid}")
    public Response deleteRoleFromMember(@PathParam("roleid") int roleid, @PathParam("memberid") int memberid) {

	RoleDAO.deleteRoleFromMember(roleid, memberid);
	return Response.status(Status.NOT_IMPLEMENTED).build();
    }
}
