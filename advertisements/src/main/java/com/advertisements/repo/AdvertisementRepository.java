package com.advertisements.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.advertisements.entities.AdvertisementDAO;

public interface AdvertisementRepository extends MongoRepository<AdvertisementDAO, String> {

}
