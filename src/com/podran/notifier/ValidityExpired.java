package com.podran.notifier;

public class ValidityExpired extends Exception {
	public String toString()
	{
		return "Date overrun, Message not valid";
		
	}

}
