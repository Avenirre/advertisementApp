package com.advertisements.repo;

import java.util.stream.Stream;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.advertisements.entities.AdvertisementDAO;

public interface AdvertisementRepository extends MongoRepository<AdvertisementDAO, String> {

	Stream<AdvertisementDAO> findByTopic(String name);
	
	@Query(value = "{ $or: [ { 'title' : {$regex:?0, $options:'i'} }, { 'description' : {$regex:?0,$options:'i'} } ] }")
	Stream<AdvertisementDAO> findByTitleOrDescriptionPart(String regexp);
}
