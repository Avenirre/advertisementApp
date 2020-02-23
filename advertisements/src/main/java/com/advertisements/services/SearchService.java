package com.advertisements.services;

import com.advertisements.utils.Status;

public interface SearchService {

	Status getByTopic(String name);

	Status getByTitle(String name);

	Status getByDescription(String name);

	

}
