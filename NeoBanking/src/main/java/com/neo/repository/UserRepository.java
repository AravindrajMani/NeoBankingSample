package com.neo.repository;
import org.springframework.data.repository.CrudRepository;

import com.neo.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	
	
}