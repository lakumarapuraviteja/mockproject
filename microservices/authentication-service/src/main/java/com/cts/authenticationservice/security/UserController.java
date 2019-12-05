package com.cts.authenticationservice.security;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.authenticationservice.model.User;
import com.cts.authenticationservice.repository.UserRepository;
import com.cts.authenticationservice.security.AppUserDetailsService;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
	@Autowired
	AppUserDetailsService appUserDetailsService;
	@Autowired
	UserRepository userRepository;

	

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
	public String signupAdmin(@RequestBody User user)  {
		return appUserDetailsService.signupAdmin(user);

	}
	@GetMapping("/admin")
    public List<User> adminInfo(){
           return userRepository.adminInfo();
    }
    @PutMapping("")
    public void response(@RequestBody User user){
           appUserDetailsService.response(user);
    }

}
