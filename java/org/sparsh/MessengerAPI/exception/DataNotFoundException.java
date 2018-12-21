package org.sparsh.MessengerAPI.exception;

import org.sparsh.MessengerAPI.model.Message;

public class DataNotFoundException extends RuntimeException {
	
	private static final int serialId = 374892342;
	
	public String DataNotFoundException(Message message)
	{
		return "message not found with this id "+String.valueOf(message.getId());
	}
	
}
