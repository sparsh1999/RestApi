package org.sparsh.MessengerAPI.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;


//this annotation is used to convert the list of messages to xml form  
//there is a jaxp comes with java sdk which can convert this directly to invoke that 
//we use this annotation

@XmlRootElement

public class Message
{
	int id ;
	Date createdDate;
	String author;
	String message ;
	List<Link> link = new ArrayList<>();
	
	
	public List<Link> getLink() {
		return link;
	}

	public void setLink(List<Link> link) {
		this.link = link;
	}

	public Message ()
	{
		
	}
	 
	 public Message(int id,String body,String author)
	 {
		 this.message = body;
		 this.id = id;
		 this.createdDate = new Date();
		 this.author = author;
	 }
	 
	 
	public String getMessage() {
		return message;
	}
	public void setMessage(String body) {
		this.message = body;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public void addLink(String uri,String rel)
	{
		Link link = new Link();
		link.setLink(uri);
		link.setRel(rel);
		this.link.add(link);
	}
	
	
}

