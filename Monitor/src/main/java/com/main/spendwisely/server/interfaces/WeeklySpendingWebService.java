package com.main.spendwisely.server.interfaces;

import java.util.Date;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;



import com.main.spendwisely.dto.SpendWiselyResponse;
import com.main.spendwisely.dto.WeeklyListDto;

@Path("/Weekly")
public interface WeeklySpendingWebService {
	
	@Path("/storeExpense")
	  @POST
	  @Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	  @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	  public SpendWiselyResponse<Void> storeExpense(@QueryParam("amount") double amount,@QueryParam("month") int month,@QueryParam("week") int week,@QueryParam("year") int year,String description);
	
	@Path("/retrieveExpenses")
	@GET
	 @Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	  @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	  public WeeklyListDto retrieveExpenses(@QueryParam("fromWeek") int fromWeek,@QueryParam("toWeek")int toWeek,@QueryParam("fromMonth") int fromMonth,@QueryParam("toMonth") int toMonth);
}
