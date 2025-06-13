package com.comp.cus.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.comp.cus.model.User;



public interface UserRepository extends JpaRepository<User,Integer>{

	User findByUsername(String username);




	
//
	@Query("select u from User u where u.username=?1")
	User getByUsername(String username);

}