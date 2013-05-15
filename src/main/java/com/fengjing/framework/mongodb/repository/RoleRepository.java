package com.fengjing.framework.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.fengjing.framework.mongodb.domain.Role;

public interface RoleRepository extends MongoRepository<Role, String> {
}
