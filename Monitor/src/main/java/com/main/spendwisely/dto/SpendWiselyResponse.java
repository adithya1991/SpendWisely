package com.main.spendwisely.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="SpendWiselyResponse")
public class SpendWiselyResponse<T> {
	@XmlAnyElement(lax=true)
	public List<T> content;
	
	@XmlElement(name="Status")
	public ProcessingStatusType generalProcessingStatus;
	
	@XmlElement(name="ErrorResponse")
	public ErrorResponseType errorResponse;

	public List<T> getContent() {
		return content;
	}

	public void setContent(List<T> content) {
		this.content = content;
	}

	public ProcessingStatusType getGeneralProcessingStatus() {
		return generalProcessingStatus;
	}

	public void setGeneralProcessingStatus(ProcessingStatusType generalProcessingStatus) {
		this.generalProcessingStatus = generalProcessingStatus;
	}

	public ErrorResponseType getErrorResponse() {
		return errorResponse;
	}

	public void setErrorResponse(ErrorResponseType errorResponse) {
		this.errorResponse = errorResponse;
	}
	
	

}
