package com.aem.geeks.core.beans;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true )
public class ChatGptResponse {
    private List<Choice> choices;

    @JsonIgnoreProperties(ignoreUnknown = true )
    public static class Choice {
        private Message message;

		public Message getMessage() {
			return message;
		}

    }

	public List<Choice> getChoices() {
		return choices;
	}
}

