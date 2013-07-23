package com.podran.notifier;

public class MessageData {
	private String message;
	private int type;
	private String validTill;
	public MessageData(String message,int type,String validTill)
	{
		this.message = message;
		this.type = type;
		this.validTill = validTill;
		
	}
	public String getMessage()
	{
		return message;
	}
	public int getType()
	{
		
		return type;
	}
	public String getValidTill()
	{
		return validTill;
	}
	
	

}
