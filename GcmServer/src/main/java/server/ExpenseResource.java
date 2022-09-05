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
import main.java.hibernate.dao.ExpenseDAO;
import main.java.hibernate.model.Expense;

@Path("/expense")

@Consumes(MediaType.APPLICATION_XML)
@Produces(MediaType.APPLICATION_XML)
public class ExpenseResource {

    // HTTP request methods

    // server Test
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/test")
    public String serverTest() {
	return "server test successful!";
    }

    // get expense
    @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("/expense/{id}")
    public Response getExpense(@PathParam("id") int id) {

	Expense expense = new Expense();
	expense = ExpenseDAO.getExpense(id);
	return Response.status(Status.OK).entity(expense).build();
    }

    // get list of all expenses
    @GET
    @Produces(MediaType.APPLICATION_XML)
    // @Consumes(MediaType.APPLICATION_XML)
    @Path("/expenselist")
    public Response getExpenseList() {

	List<Expense> expenses = new ArrayList<>();
	expenses = ExpenseDAO.getExpenses();
	GenericEntity<List<Expense>> ml = new GenericEntity<List<Expense>>(Lists.newArrayList(expenses)) {
	};

	return Response.status(Status.OK).entity(ml).build();
    }

    // add new expense
    @POST
    @Consumes(MediaType.APPLICATION_XML)
    @Path("/addExpense")
    public Response postExpense(Expense newExpense) {

	ExpenseDAO.addExpense(newExpense);
	return Response.status(Status.CREATED).build();

    }

    // update expense
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    @Path("/updateExpense/{id}")
    public Response putExpense(@PathParam("id") int id, Expense alteredExpense) {

	ExpenseDAO.updateExpense(id, alteredExpense);
	return Response.status(Status.NOT_IMPLEMENTED).build();
    }

    // delete expense
    @DELETE
    @Path("/deleteExpense/{id}")
    public Response deleteExpense(@PathParam("id") int id) {

	ExpenseDAO.deleteExpense(id);
	return Response.status(Status.NOT_IMPLEMENTED).build();
    }

}
