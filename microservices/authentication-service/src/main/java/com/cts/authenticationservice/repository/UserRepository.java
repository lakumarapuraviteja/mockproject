package com.cts.authenticationservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cts.authenticationservice.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	@Query("from User u where u.userId=?1")
	User findByUsername(String name);

    @Query(value="FROM User user join user.roleList role where role.roleName='admin'")
    List<User> adminInfo();

}
