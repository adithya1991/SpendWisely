package com.main.spendwisely.server.interfaces;

import java.util.Date;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/Monthly")
public interface MonthlySpending {

@Path("/salary")
@Produces(MediaType.APPLICATION_XML)
@Consumes(MediaType.APPLICATION_XML)
public void addAmount(@QueryParam("amount")double amount,@QueryParam("from")Date from,@QueryParam("to")Date to);	



	
	

}
