package org.sparsh.MessengerAPI.Database;

import java.util.HashMap;
import java.util.Map;

import org.sparsh.MessengerAPI.model.Message;
import org.sparsh.MessengerAPI.model.Profile;

public class DatabaseDemo {

	private static Map<String,Profile> profile = new HashMap<String,Profile>();
	private static Map<Integer,Message> message = new HashMap<Integer,Message>();
	
	public static Map<String,Profile> getAllProfile()
	{
		return profile;
	}
	
	public static Map<Integer,Message> getAllMessage()
	{
		return message;
	}
}
