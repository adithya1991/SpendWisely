package com.main.spendwisely.util;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.main.spendwisely.dto.ErrorResponseType;
import com.main.spendwisely.dto.ProcessingStatusType;
import com.main.spendwisely.dto.SpendWiselyException;
import com.main.spendwisely.dto.SpendWiselyResponse;

@Provider
public class SpendwiselyExceptionMapper implements ExceptionMapper<SpendWiselyException> {

  @Override
  public Response toResponse(SpendWiselyException exception) {
    ErrorResponseType error = new ErrorResponseType();
    SpendWiselyResponse<Void> errorResp = new SpendWiselyResponse<Void>();
    if (exception instanceof SpendWiselyException) {
      SpendWiselyException exceptionCaught = exception;
      error.setErrorCode(exceptionCaught.getErrorCode());
      error.setErrorMessage(exceptionCaught.getMessage());
    }
    else {
      // we need to throw the exception caught
      error.setErrorMessage(exception.getCause().toString());
    }
    errorResp.setErrorResponse(error);
    errorResp.setGeneralProcessingStatus(ProcessingStatusType.ERROR);
    return Response.ok(errorResp).build();

  }

}
