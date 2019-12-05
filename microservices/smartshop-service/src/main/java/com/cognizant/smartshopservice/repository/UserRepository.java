package com.cognizant.smartshopservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.smartshopservice.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	@Query("from User u where u.userId=?1")
	User findByUsername(String name);

	@Query("from User u where u.contactNumber=?1")
	User findByUser(String name);

	//@Query("select users from User users where users.userId=?1")
	//User getMovies(String name);

}
