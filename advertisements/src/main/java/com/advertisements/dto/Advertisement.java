package com.advertisements.dto;

import java.io.Serializable;
import java.time.LocalDate;

@SuppressWarnings("serial")
public class Advertisement implements Serializable{
	
	private String title;
	private String description;
	private String topic;
	private LocalDate timestamp;
	
	public Advertisement() {}

	public Advertisement(String title, String description, String topic, LocalDate timestamp) {
		this.title = title;
		this.description = description;
		this.topic = topic;
		this.timestamp = timestamp;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public LocalDate getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDate timestamp) {
		this.timestamp = timestamp;
	}
}
