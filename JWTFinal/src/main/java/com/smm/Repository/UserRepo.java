package com.smm.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smm.Entity.User;

public interface UserRepo extends JpaRepository<User,Integer> {
	
	User findByUsernameAndPassword(String username, String password);

}
