package com.cognizant.smartshopservice.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.smartshopservice.model.User;
import com.cognizant.smartshopservice.model.Users;
import com.cognizant.smartshopservice.security.AppUserDetailsService;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
	@Autowired
	AppUserDetailsService appUserDetailsService;

	/*
	 * @Autowired UserService userService;
	 */

	@GetMapping("/{name}")
	public UserDetails testFindByUsername(@PathVariable("name") String name) {
	return appUserDetailsService.loadUserByUsername(name);
		// LOGGER.debug("User:{}",user1);
	}

	/*
	 * @GetMapping("/user/{name}") public User
	 * testFindName(@PathVariable("name") String name){ return
	 * userService.findByUsername(name); }
	 */
	@PostMapping("/U")
	public String signupUser(@RequestBody User user)  {
		return appUserDetailsService.signupUser(user);

	}
	@PostMapping("/A")
	public String signupAdmin(@RequestBody Users user)  {
		return appUserDetailsService.signupAdmin(user);
	}
}
