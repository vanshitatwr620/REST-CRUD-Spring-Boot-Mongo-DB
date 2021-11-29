package com.restcrud.restcrud.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.restcrud.restcrud.model.UserDTO;

@Repository
public interface UserRepository extends MongoRepository<UserDTO, String> {

}
