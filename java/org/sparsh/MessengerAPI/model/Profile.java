package org.sparsh.MessengerAPI.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Profile
{
	String firstname,lastname,uname ;
	int id ;
	Date date ;
	
	public Profile()
	{}
	
	public Profile(String profile,String firstname,String lastname,int id )
	{
		this.firstname = firstname;
		this.uname = profile;
		this.lastname = lastname;
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String profilename) {
		this.uname = profilename;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date created) {
		this.date = created;
	}
	
	

}
