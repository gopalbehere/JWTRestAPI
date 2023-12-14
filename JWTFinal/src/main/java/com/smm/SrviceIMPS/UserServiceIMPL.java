package com.smm.SrviceIMPS;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smm.Entity.User;
import com.smm.Repository.UserRepo;
import com.smm.Service.UserService;
@Service
public class UserServiceIMPL implements UserService {
	@Autowired
	UserRepo ur;
	@Override
	public User login(String username, String password) {
		// TODO Auto-generated method stub
		return ur.findByUsernameAndPassword(username, password);
	}

}
