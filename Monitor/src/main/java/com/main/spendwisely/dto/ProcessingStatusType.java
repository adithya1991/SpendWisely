package com.main.spendwisely.dto;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "ProcessingStatusType")
@XmlEnum
public enum ProcessingStatusType {
	@XmlEnumValue("Ok")
	OK("Ok"),
	@XmlEnumValue("Error")
	ERROR("Error");
	
	private final String value;
	
	
	private ProcessingStatusType(String value)
	{
		this.value = value;
	}
	
	
	
	public static ProcessingStatusType fromString(String s)
	{
		for(ProcessingStatusType value : ProcessingStatusType.values())
		{
			if(s.equals(value.value))
			{
				return value;
			}
		}
		return null;
	}

}
