package org.sparsh.MessengerAPI.resources;

public class Exception {
	
	private String errorMessage ;
	private int errorId;
	private String documentaion;
	
	public Exception()
	{
		
	}
	
	public Exception(String error,int id ,String document)
	{
		errorMessage = error;
		errorId = id;
		documentaion = document;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public int getErrorId() {
		return errorId;
	}
	public void setErrorId(int errorId) {
		this.errorId = errorId;
	}
	public String getDocumentaion() {
		return documentaion;
	}
	public void setDocumentaion(String documentaion) {
		this.documentaion = documentaion;
	}
	
	

}
