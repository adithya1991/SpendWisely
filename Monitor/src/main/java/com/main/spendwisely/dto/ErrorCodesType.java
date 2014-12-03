package com.main.spendwisely.dto;

import org.apache.commons.lang3.StringUtils;

public enum ErrorCodesType {
	INTERNAL_ERROR(10000);
	
	
	Integer errorCode;
	
	
	
	public Integer getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}

	private ErrorCodesType(Integer errorCode) {
		this.errorCode = errorCode;
	}
	
	public Enum<ErrorCodesType> fromString(String s)
	{
		if(StringUtils.isNotEmpty(s))
		{
			ErrorCodesType[] errors = ErrorCodesType.values();
			for(ErrorCodesType error : errors)
			{
				if(s.equals(error.name()))
				{
					return error;
				}
			}
		}
		return null;
	}  

}
