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



public class ProfileService {
	
	private Map<String,Profile> profile = DatabaseDemo.getAllProfile();
	
	public List<Profile> getAllProfile()
	   {
		   return new ArrayList<>(profile.values());
	   }
	   
	   public List<Profile> getAllProfileYear(int year)
	   {
		   List<Profile> yearProfile = new ArrayList<>();
		   Calendar cal = Calendar.getInstance();
		   for (Profile profiles : profile.values())
		   {
			   cal.setTime(profiles.getDate());
			   if (cal.get(Calendar.YEAR)==year)
			   {
				   yearProfile.add(profiles);
			   }
		   }
		   return yearProfile;
	   }
	   
	   public List<Profile> getAllProfileSort(int start,int size)
	   {
		   List<Profile> yearProfile = new ArrayList<>(profile.values());
		   if (size+start>profile.size())
			   return new ArrayList<Profile>();
		   return yearProfile.subList(start,start+ size);
	   }
	   
	   public Profile getProfile(String uname)
	   {
		   return profile.get(uname);
	   }
	   
	   public Profile updateProfile(Profile prof)
	   {
		   if (prof.getUname().isEmpty())
			   return null;
		   else  
		   {
			   profile.put(prof.getUname(), prof);
			   return profile.get(prof.getUname());
		   }  
	   }
	   public Profile addProfile(Profile prof)
	   {
		  prof.setId(profile.size()+1);
		  prof.setDate(new Date()); 
		   profile.put(prof.getUname(), prof);
		   return profile.get(prof.getUname());
	   }
	   
	   public String deleteProfile(String uname)
	   {
		   if (!uname.isEmpty())
		   {
			   if (profile.remove(uname) != null)
			   return "deleted succesfully";
		   }
		   return "No entry with this profileName";
	   }

}
