package com.track.courier.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.track.courier.model.User;
import com.track.courier.model.UserRepository;

@Component
public class UsersDAO {

	@Autowired
	private UserRepository userRepository;

	public User registerUser(User user) {
		return userRepository.save(user);
	}

	public User findUser(String username, String password) {
		return userRepository.findUser(username, password);
	}
}
