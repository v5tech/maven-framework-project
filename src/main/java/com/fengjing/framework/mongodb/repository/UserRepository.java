package com.fengjing.framework.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.fengjing.framework.mongodb.domain.User;

public interface UserRepository extends MongoRepository<User, String> {
	
	User findByUsername(String username);
}
