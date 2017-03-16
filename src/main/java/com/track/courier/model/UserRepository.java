package com.track.courier.model;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<User, UserId> {

	@Query("SELECT u FROM User u WHERE u.username = :username and u.password = :password")
	public User findUser(@Param("username") String username, @Param("password") String password);
	
	public User findByUsernameOrEmailId(String username, String emailId);
}
