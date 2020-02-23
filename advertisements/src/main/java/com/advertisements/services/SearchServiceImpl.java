package com.advertisements.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advertisements.dto.Advertisement;
import com.advertisements.entities.AdvertisementDAO;
import com.advertisements.repo.AdvertisementRepository;
@Service
public class SearchServiceImpl implements SearchService {
	
	@Autowired
	AdvertisementRepository advertisements;

	@Override
	public List<Advertisement> getByTopic(String name) {
		return advertisements.findByTopic(name).map(AdvertisementDAO::getAdvertisement).collect(Collectors.toList());
	}

	@Override
	public List<Advertisement> getByTitleOrDescriptionPart(String name) {
		return advertisements.findByTitleOrDescriptionPart(name).map(AdvertisementDAO::getAdvertisement).collect(Collectors.toList());
	}
}
