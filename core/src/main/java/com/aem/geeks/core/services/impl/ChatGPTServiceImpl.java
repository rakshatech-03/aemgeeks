package com.aem.geeks.core.services.impl;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.Designate;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

import com.aem.geeks.core.services.ChatGPTService;

@Component(
        service = ChatGPTService.class,
        immediate = true)
@Designate(ocd = ChatGPTServiceImpl.ChatGPTConfiguration.class)
public class ChatGPTServiceImpl implements ChatGPTService {
	
	private String chatGPTHostname;
	private String chatGPTApiEndpoint;
	private String chatGPTApiKey;
	private String chatGPTRole;
	private String chatGPTModel;
	
	@Activate
	@Modified
	protected void activate(final ChatGPTConfiguration chatGPTConfiguration) {
		chatGPTHostname = chatGPTConfiguration.chatGPTApiHostname();
		chatGPTApiEndpoint = chatGPTConfiguration.chatGPTApiEndpoint();
		chatGPTApiKey = chatGPTConfiguration.chatGPTApiKey();
		chatGPTRole = chatGPTConfiguration.chatGPTRole();
		chatGPTModel = chatGPTConfiguration.chatGPTModel();
	}
	
	@ObjectClassDefinition(name = "Chat GPT Configuration")
	public @interface ChatGPTConfiguration {

		@AttributeDefinition(name = "Chat GPT API Hostname", description = "API Hostname for Chat GPT")
		String chatGPTApiHostname() default "https://api.openai.com";
		
		@AttributeDefinition(name = "Chat GPT API Endpoint", description = "API Endpoint for Chat GPT")
		String chatGPTApiEndpoint() default "/v1/chat/completions";
		
		@AttributeDefinition(name = "Chat GPT API Key", description = "API Key for Chat GPT")
		String chatGPTApiKey() default "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";
		
		@AttributeDefinition(name = "Chat GPT Role", description = "The ‘role’ can take one of three values: ‘system’, ‘user’ or the ‘assistant’")
		String chatGPTRole() default "user";
		
		@AttributeDefinition(name = "Chat GPT Model", description = "The AI Model to be used")
		String chatGPTModel() default "gpt-3.5-turbo";

	}

	@Override
	public String getChatGPTApiEndpoint() {
		return chatGPTApiEndpoint;
	}

	@Override
	public String getChatGPTHostname() {
		return chatGPTHostname;
	}

	@Override
	public String getChatGPTApiKey() {
		return chatGPTApiKey;
	}
	
	@Override
	public String getChatGPTRole() {
		return chatGPTRole;
	}
	
	@Override
	public String getChatGPTModel() {
		return chatGPTModel;
	}

}
