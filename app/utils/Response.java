package utils;

import play.libs.Json;

import com.fasterxml.jackson.databind.node.ObjectNode;

public class Response {
	private static final String SUCCESS_MSG = "Success";
	private static final String ERROR_MSG = "Error";
	private String message;
	private String reponseStatus;
	
	public Response() {
	}
	
	public Response(String message, boolean success) {
		this.message = message;
		this.reponseStatus = success? SUCCESS_MSG: ERROR_MSG;
	}
	
	public ObjectNode getJSON() {
		ObjectNode result = Json.newObject();
		result.put("Status", this.reponseStatus);
		result.put("Message", this.message);
		return result;
	}
}
