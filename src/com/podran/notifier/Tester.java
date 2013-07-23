package com.podran.notifier;

public class Tester {
	public static void main(String[] args)
	{
		
		MessageFetcher fetcher = new MessageFetcher();
		MessageData data;
		try {
			data = fetcher.getMessage("podran", MessageFetcher.ALERT);
			System.out.println("Message is "+data.getMessage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println(e);
		}
		
	}

}
