package com.CarBokingWeb.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.CarBokingWeb.Entities.User;


public interface UserRepository extends JpaRepository<User, Integer >{

	 @Query("SELECT u FROM User u WHERE u.name = ?1")
	    User findByName(String name);

	
	 public boolean existsByEmail(String email);

	 @Query("SELECT u FROM User u WHERE u.id = :id")
	    User findById(int id);
	 
	 
}
