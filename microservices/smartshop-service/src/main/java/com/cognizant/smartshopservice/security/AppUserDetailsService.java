package com.cognizant.smartshopservice.security;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cognizant.smartshopservice.exception.*;
import com.cognizant.smartshopservice.model.Role;
import com.cognizant.smartshopservice.model.User;
import com.cognizant.smartshopservice.model.Users;
import com.cognizant.smartshopservice.repository.RoleRepository;
import com.cognizant.smartshopservice.repository.UserRepository;

/*import com.cognizant.moviecruiser.exception.UserAlreadyExistsException;
import com.cognizant.moviecruiser.model.Role;
import com.cognizant.moviecruiser.model.User;
import com.cognizant.moviecruiser.model.Users;
import com.cognizant.moviecruiser.repository.RoleRepository;
import com.cognizant.moviecruiser.repository.UserRepository;*/

@Service
public class AppUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;
	@Autowired
	RoleRepository roleRepository;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      //  LOGGER.info("Start");
        User user = userRepository.findByUsername(username);
        //LOGGER.debug("user:", user);
        //LOGGER.debug(user.getStatus());
                        
        if (user == null ){
                        throw new UsernameNotFoundException("User not present");
        } else if(user.getStatus().equals("P")){
                        throw new UsernameNotFoundException("Admin status still pending");
        } else {
                        AppUser appUser = new AppUser(user);
                     //   LOGGER.debug("authorities:", appUser.getAuthorities());
                        return appUser;
        } 
}


	public String signupUser(User user) {
		User user1 = userRepository.findByUsername(user.getUserId());
		if (user1 != null) {
			return "false";
		}

		else {
			User users = new User();
			// System.out.println(user.getUsername());
			Role role = roleRepository.findById(1);
			Set<Role> roles = new HashSet<>();
			roles.add(role);
			users.setUserId(user.getUserId());
			users.setUserType("U");
			users.setStatus("A");
			users.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
			users.setRoleList(roles);
			userRepository.save(users);
			return "true";
		}
	}
	public String signupAdmin(Users user) {
		User user1 = userRepository.findByUsername(user.getUsername());
		if (user1 != null) {
			return "false";
		}

		else {
			User users = new User();
			// System.out.println(user.getUsername());
			Role role = roleRepository.findById(2);
			Set<Role> roles = new HashSet<>();
			roles.add(role);
			users.setUserId(user.getUserId());
			users.setUserType("A");
			users.setStatus("P");
			users.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
			users.setRoleList(roles);
			userRepository.save(users);
			return "true";
		}
	}
}
