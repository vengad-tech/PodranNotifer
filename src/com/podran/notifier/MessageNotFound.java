package com.podran.notifier;

public class MessageNotFound extends Exception {
	public String toString()
	{
		
		return "Message requested is not found";
	}

}
