package org.sparsh.MessengerAPI.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;

import org.sparsh.MessengerAPI.Database.DatabaseDemo;
import org.sparsh.MessengerAPI.model.Message;
import org.sparsh.MessengerAPI.model.Profile;



public class MessageService 
{

		private Map<Integer,Message> message = DatabaseDemo.getAllMessage();
		
		
		// Remember the variable names in code and the variables supplied on the 
		// server i.e in json if must be same otherwise data will not be implemented automatically
		//
		
	   public List<Message> getAllMssg()
	   {
		   return new ArrayList<>(message.values());
	   }
	   
	   public List<Message> getAllMssYear(int year)
	   {
		   List<Message> yearMssg = new ArrayList<>();
		   Calendar cal = Calendar.getInstance();
		   for (Message messag : message.values())
		   {
			   cal.setTime(messag.getCreatedDate());
			   if (cal.get(Calendar.YEAR)==year)
			   {
				   yearMssg.add(messag);
			   }
		   }
		   return yearMssg;
	   }
	   
	   public List<Message> getAllMessSort(int start,int size)
	   {
		   List<Message> yearMssg = new ArrayList<>(message.values());
		   if (size+start>message.size())
			   return new ArrayList<Message>();
		   return yearMssg.subList(start,start+ size);
	   }
	   
	   public Message getMessage(int id)
	   {
		   return message.get(id);
	   }
	   
	   public Message updateMessage(Message mssg)
	   {
		   if (mssg.getId()<=0)
			   return null;
		   else  
		   {
			   message.put(mssg.getId(), mssg);
			   return message.get(mssg.getId());
		   }  
	   }
	   public Message addMessage(Message mssg)
	   {
		   mssg.setId(message.size()+1);
		  mssg.setCreatedDate(new Date()); 
		   message.put(mssg.getId(), mssg);
		   return message.get(mssg.getId());
	   }
	   
	   public String deleteMessage(int id)
	   {
		   if (message.remove(id) != null)
		   {
			   return "deleted succesfully";
		   }
		   return "No entry with this id";
	   }
	   
	 
}
