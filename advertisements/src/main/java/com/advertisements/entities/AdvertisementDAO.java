package com.advertisements.entities;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;

import com.advertisements.dto.Advertisement;
@Document(collection="advertisements")
public class AdvertisementDAO {
	@Id
	private String title;
	private String description;
	private String topic;
	private LocalDate timestamp;
	@Version
	private Long version;
	
	public AdvertisementDAO() {}
	
	public AdvertisementDAO(Advertisement advertisement) {
		this.title = advertisement.getTitle();
		this.description = advertisement.getDescription();
		this.topic = advertisement.getTopic();
		this.timestamp = advertisement.getTimestamp();
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
	
	public Advertisement getAdvertisement() {
		return new Advertisement(title, description, topic, timestamp);
	}
}
