package com.main.spendwisely.server.interfaces;

import java.util.Date;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("Monthly")
public interface MonthlySpending {
  @GET
  @Path("/salary")
  @Produces(MediaType.APPLICATION_XML)
  @Consumes(MediaType.APPLICATION_XML)
  public void addAmount(@QueryParam("amount") double amount, @QueryParam("from") int fromMonth, @QueryParam("to") int toMonth);
  
  @Path("/repeatedExpense")
  @POST
  @Consumes(MediaType.APPLICATION_XML)
  @Produces(MediaType.APPLICATION_XML)
  public void repeatedExpense(@QueryParam("amount") double amount,@QueryParam("from") int fromMonth, @QueryParam("to") int toMonth,String description);
  
  @Path("/retrieveExpenses")
	@GET
	@Consumes(MediaType.APPLICATION_XML)
	  @Produces(MediaType.APPLICATION_XML)
	  public void retrieveExpenses(@QueryParam("month") Date month);
  
  @GET
  @Path("/addExtraAmount")
  @Produces(MediaType.APPLICATION_XML)
  @Consumes(MediaType.APPLICATION_XML)
  public void addExtraAmount(@QueryParam("amount") double amount,Date month);
  
  

}
