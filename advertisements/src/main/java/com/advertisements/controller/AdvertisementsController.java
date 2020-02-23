package com.advertisements.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.bind.annotation.RestController;

import com.advertisements.services.PublishingService;
import com.advertisements.services.SearchService;

@SpringBootApplication
@RestController
@EnableMongoRepositories("com.advertisements.repo")
public class AdvertisementsController {
	
	@Autowired
	PublishingService publishingService;
	SearchService searchService;
	

}
