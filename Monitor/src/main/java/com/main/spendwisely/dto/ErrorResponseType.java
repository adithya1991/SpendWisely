package com.main.spendwisely.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="ErrorResponseType")
@XmlAccessorType(XmlAccessType.FIELD)
public class ErrorResponseType {
	
	@XmlElement(name = "ErrorCode")
	public Integer errorCode;
	@XmlElement(name = "ErrorMessage")
	public String errorMessage;

	public Integer getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	
	
	

}
