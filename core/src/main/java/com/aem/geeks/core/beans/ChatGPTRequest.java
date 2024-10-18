package com.aem.geeks.core.beans;


import java.util.List;
import java.util.ArrayList;

public class ChatGPTRequest {
	private String model;
	private List<Message> messages;

	public ChatGPTRequest(String text, String model, String role) {
		this.model = model;
		this.messages = new ArrayList<>();
		Message message = new Message();
		message.setRole(role);
		message.setContent(text);
		this.messages.add(message);
	}

}