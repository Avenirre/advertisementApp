package com.advertisements.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advertisements.dto.Advertisement;
import com.advertisements.entities.AdvertisementDAO;
import com.advertisements.repo.AdvertisementRepository;
import com.advertisements.utils.Status;
@Service
public class PublishingServiceImpl implements PublishingService {
	
	@Autowired
	AdvertisementRepository advertisements;

	@Override
	public Status publish(Advertisement advertisement) {
		if (advertisement.getTitle().length() == 0 || advertisement.getDescription().length() == 0 || 
				advertisement.getTopic().length() == 0) {
			return Status.INVALID_ADVERTISEMENT_FORMAT;
		}
		if(advertisements.existsById(advertisement.getTitle())) {
			return Status.ADVERTISEMENT_EXISTS;
		}
		advertisements.save(new AdvertisementDAO(advertisement));
		return Status.ADVERTISEMENT_ADDED_SUCCESSFULLY;
	}

}
