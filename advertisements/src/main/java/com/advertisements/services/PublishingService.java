package com.advertisements.services;

import com.advertisements.dto.Advertisement;
import com.advertisements.utils.Status;

public interface PublishingService {

	Status publish(Advertisement advertisement);
	
	

}
