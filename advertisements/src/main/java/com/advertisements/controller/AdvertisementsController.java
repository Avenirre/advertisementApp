package com.advertisements.controller;

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
	SearchService searchService;
	
	@PostMapping("/publish")
	Status publish(@RequestBody Advertisement advertisement) {
		return publishingService.publish(advertisement);
	}
	
	@GetMapping("/search/topic/{name}")
	Status getByTopic(@PathVariable("name") String name) {
		return searchService.getByTopic(name);
	}
	
	@GetMapping("/search/title/{name}")
	Status getByTitle(@PathVariable("name") String name) {
		return searchService.getByTitle(name);
	}
	
	@GetMapping("/search/description/{name}")
	Status getByDescription(@PathVariable("name") String name) {
		return searchService.getByDescription(name);
	}
}
