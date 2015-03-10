package com.main.spendwisely.server.interfaces;

import java.util.Date;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;


import com.main.spendwisely.dto.MonthlyDto;


@Path("/Monthly")
public interface MonthlySpendingWebService {
  @POST
  @Path("/salary")
  @Produces(MediaType.APPLICATION_XML)
  @Consumes(MediaType.APPLICATION_XML)
  public void addAmount(@QueryParam("amount") double amount, @QueryParam("from") int fromMonth, @QueryParam("to") int toMonth);
  
  @POST
  @Path("/salary/limit")
  @Produces(MediaType.APPLICATION_XML)
  @Consumes(MediaType.APPLICATION_XML)
  public void addLimit(@QueryParam("limit") double amount, @QueryParam("from") int fromMonth, @QueryParam("to") int toMonth);
  
  @Path("/repeatedExpense")
  @POST
  @Consumes(MediaType.APPLICATION_XML)
  @Produces(MediaType.APPLICATION_XML)
  public void repeatedExpense(@QueryParam("amount") double amount,@QueryParam("from") int fromMonth, @QueryParam("to") int toMonth,String description);
  
  @Path("/retrieveExpenses")
	@GET
	@Consumes(MediaType.APPLICATION_XML)
	  @Produces(MediaType.APPLICATION_XML)
	  public MonthlyDto retrieveExpenses(@QueryParam("fromMonth") int fromMonth,@QueryParam("toMonth") int toMonth);
  
  @POST
  @Path("/addExtraAmount")
  @Produces(MediaType.APPLICATION_XML)
  @Consumes(MediaType.APPLICATION_XML)
  public void addExtraAmount(@QueryParam("amount") double amount,@QueryParam("month") int month,String description);
  
  

}
