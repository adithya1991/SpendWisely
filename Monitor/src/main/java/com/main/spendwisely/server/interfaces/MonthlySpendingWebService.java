package com.main.spendwisely.server.interfaces;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.main.spendwisely.dto.MonthlyListDto;
import com.main.spendwisely.dto.SpendWiselyResponse;


@Path("/Monthly")
public interface MonthlySpendingWebService {
  @PUT
  @Path("/addSalary")
  @Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
  @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
  public SpendWiselyResponse<Void> addAmount(@QueryParam("amount") double amount, @QueryParam("fromMonth") int fromMonth, @QueryParam("toMonth") int toMonth,
		  @QueryParam("fromYear") int fromYear, @QueryParam("toYear") int toYear);
  
  @POST
  @Path("/salary/limit")
  @Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
  @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
  public SpendWiselyResponse<Object> addLimit(@QueryParam("limit") double amount, @QueryParam("from") int fromMonth, @QueryParam("to") int toMonth);
  
  @Path("/repeatedExpense")
  @PUT
  @Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
  @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
  public SpendWiselyResponse<Object> repeatedExpense(@QueryParam("amount") double amount,@QueryParam("from") int fromMonth, @QueryParam("to") int toMonth,String description);
  
  @Path("/retrieveExpenses")
	@GET
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	  @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	  public MonthlyListDto retrieveExpenses(@QueryParam("fromMonth") int fromMonth,@QueryParam("toMonth") int toMonth,@QueryParam("fromYear") int fromYear,@QueryParam("toYear") int toYear);
  
  
  

}
