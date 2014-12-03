package com.main.spendwisely.util;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

import com.main.spendwisely.dto.ErrorResponseType;
import com.main.spendwisely.dto.ProcessingStatusType;
import com.main.spendwisely.dto.SpendWiselyException;
import com.main.spendwisely.dto.SpendWiselyResponse;

public class SpendwiselyExceptionMapper implements ExceptionMapper<Throwable>{

	public Response toResponse(Throwable arg0) {
		
		ErrorResponseType error = new ErrorResponseType();
		SpendWiselyResponse<Void> errorResp = new SpendWiselyResponse<Void>();
		if(arg0 instanceof SpendWiselyException)
		{
			SpendWiselyException exceptionCaught = (SpendWiselyException)arg0;
		error.setErrorCode(exceptionCaught.getErrorCode());
		error.setErrorMessage(exceptionCaught.getMessage());
		}
		else
		{
			// we need to throw the exception caught
			error.setErrorMessage(arg0.getCause().toString());
		}
		errorResp.setErrorResponse(error);
		errorResp.setGeneralProcessingStatus(ProcessingStatusType.ERROR);
		Response.ok(errorResp).build();
		return null;
	}

}
