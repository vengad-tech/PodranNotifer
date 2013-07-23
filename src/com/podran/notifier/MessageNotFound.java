package com.podran.notifier;

public class MessageNotFound extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String toString()
	{
		
		return "Message requested is not found";
	}

}
