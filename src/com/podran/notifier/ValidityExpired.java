package com.podran.notifier;

public class ValidityExpired extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String toString()
	{
		return "Date overrun, Message not valid";
		
	}

}
