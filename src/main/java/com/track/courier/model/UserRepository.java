package com.track.courier.model;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, UserId> {

}
