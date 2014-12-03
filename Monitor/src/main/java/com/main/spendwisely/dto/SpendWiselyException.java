package com.main.spendwisely.dto;

// CHecked exception class to be used through out the application 
public class SpendWiselyException extends RuntimeException {

	
	Integer errorCode;
	
	public SpendWiselyException(){
		super();
	}

	public SpendWiselyException(String errorMessage, Integer errorCode) {
		super(errorMessage);
		this.errorCode = errorCode;
	}


	public Integer getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}
	
	

}
