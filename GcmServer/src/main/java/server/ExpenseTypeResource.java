package main.java.server;

import java.util.ArrayList;
import java.util.List;

import org.glassfish.jersey.internal.guava.Lists;

import main.java.hibernate.model.ExpenseType;
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
import main.java.hibernate.dao.ExpenseTypeDAO;

@Path("/expenseType")

@Consumes(MediaType.APPLICATION_XML)
@Produces(MediaType.APPLICATION_XML)
public class ExpenseTypeResource {
	


	// server Test	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/test")
	public String serverTest() {
		return "server test successful!";
	}

	

	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("/expenseType/{id}")
	public Response getExpenseType(@PathParam("id") int id) { 
			
		ExpenseType expenseType = new ExpenseType();
		expenseType = ExpenseTypeDAO.getExpenseType(id);	
		
		return Response.status(Status.OK).entity(expenseType).build();
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	//@Consumes(MediaType.APPLICATION_XML)
	@Path("/expenseTypelist")
	public Response getExpenseTypeList() {		
	
		List<ExpenseType> expenseTypes = new ArrayList<>();			
		expenseTypes = ExpenseTypeDAO.getExpenseTypes();
		
		GenericEntity<List<ExpenseType>> ml = new GenericEntity<List<ExpenseType>>(Lists.newArrayList(expenseTypes)) {};
	    
		return Response.status(Status.OK).entity(ml).build();			
	}
	
	
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	@Path("/addExpenseType")
	public Response postExpenseType(ExpenseType newExpenseType) {
		
		ExpenseTypeDAO.addExpenseType(newExpenseType);	
		return Response.status(Status.CREATED).build();
		
	}

	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	@Path("/updateExpenseType/{id}")
	public Response putExpenseType(@PathParam("id")int id, ExpenseType alteredExpenseType) {
		
		ExpenseTypeDAO.updateExpenseType(id, alteredExpenseType);
		return Response.status(Status.NOT_IMPLEMENTED).build();
	}

	@DELETE
	@Path("/deleteExpenseType/{id}")
	public Response deleteExpenseType(@PathParam("id")int id) {
		ExpenseTypeDAO.deleteExpenseType(id);
		return Response.status(Status.NOT_IMPLEMENTED).build();
	}

	 
}
