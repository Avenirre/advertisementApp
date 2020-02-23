package com.advertisements.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.advertisements.dto.Advertisement;
import com.advertisements.services.PublishingService;
import com.advertisements.services.SearchService;
import com.advertisements.utils.Status;
@RestController
@EnableMongoRepositories("com.advertisements.repo")
public class AdvertisementsController {
	
	@Autowired
	PublishingService publishingService;
	@Autowired
	SearchService searchService;
	
	@PostMapping("/publish")
	Status publish(@RequestBody Advertisement advertisement) {
		return publishingService.publish(advertisement);
	}
	
	@GetMapping("/topic/{name}")
	List<Advertisement> getByTopic(@PathVariable("name") String name) {
		return searchService.getByTopic(name);
	}
	
	@GetMapping("/titleOrDescriptionPart/{name}")
	List<Advertisement> getByTitle(@PathVariable("name") String name) {
		return searchService.getByTitleOrDescriptionPart(name);
	}
}
