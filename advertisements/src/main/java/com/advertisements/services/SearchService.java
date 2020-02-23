package com.advertisements.services;

import java.util.List;

import com.advertisements.dto.Advertisement;

public interface SearchService {

	List<Advertisement> getByTopic(String name);

	List<Advertisement> getByTitleOrDescriptionPart(String name);
}
