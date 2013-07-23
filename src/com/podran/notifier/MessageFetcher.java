package com.podran.notifier;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Calendar;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class MessageFetcher {
	public final static int ALERT=0;
	public final static int MESSAGE=1;
	public final static int UPDATE =2;
	private String url="http://localhost:8000/podranmessage/default/getmessage/";
	/*
	 * Helper Function that Fetches JSON data from the given URL
	 */
	public String getJSON(String urlToRead) {
	      URL url;
	      HttpURLConnection conn;
	      BufferedReader rd;
	      String line;
	      String result = "";
	      try {
	         url = new URL(urlToRead);
	         conn = (HttpURLConnection) url.openConnection();
	         conn.setRequestMethod("GET");
	         rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	         while ((line = rd.readLine()) != null) {
	            result += line;
	         }
	         rd.close();
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	      return result;
	   }
	/*
	 * Fetches Message from the remote server , you need to provide appid and type
	 * as arguments
	 */
	public MessageData getMessage(String appid,int type) throws Exception
	{
		MessageData messageData = null;
		String extension="";
		switch(type)
		{
		case ALERT:
			
			
		case MESSAGE:
			
		case UPDATE:
			extension = appid+"/"+type;
			break;
		default:
			
			
		}
		//System.out.println("URL is "+url+extension);
		String JSONdata = getJSON(url+extension);
		JSONParser parser=new JSONParser();
		Object obj;
		try {
			obj = parser.parse(JSONdata);
			JSONObject result = (JSONObject)obj;
			//System.out.println("Message is "+result);
			result = (JSONObject)((JSONArray)result.get("data")).get(0);
			String validtill = result.get("validTill").toString();
			if(!validtill.equals("None"))
			{
				Calendar now = Calendar.getInstance();
				int year = now.get(Calendar.YEAR);
				int month = now.get(Calendar.MONTH); // Note: zero based!
				int day = now.get(Calendar.DAY_OF_MONTH);
				int cyear = Integer.parseInt(validtill.split("-")[2]);
				int cmonth = Integer.parseInt(validtill.split("-")[1]);
				int cday = Integer.parseInt(validtill.split("-")[0]);
				if(year>cyear || day>cday || month > cmonth)
				{
					throw new ValidityExpired();
				}
				
				
				
			}
			messageData = new MessageData(result.get("msg").toString(), Integer.parseInt(result.get("mtype").toString()), result.get("validTill").toString());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			throw new MessageNotFound();
		}
		
		return messageData;
	}

	
	/*
	 * sets new URL to use as EndPoint
	 */
	public void setURL(String url)
	{
		this.url = url;
		
	}
	
	

}
