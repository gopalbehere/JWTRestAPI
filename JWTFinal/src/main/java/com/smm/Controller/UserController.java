package com.smm.Controller;
import java.util.Date;

import javax.print.attribute.standard.JobOriginatingUserName;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smm.Entity.User;
import com.smm.Service.UserService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.ServletException;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService us;
	
	@PostMapping("/login")
	public String validate(@RequestBody User user) throws ServletException {
		String jwt_token="";
		if (user.getUsername()==null || user.getPassword()==null) {
			throw new ServletException("Please enter user and password");
		}
		String uname=user.getUsername();
		String upass=user.getPassword();
		
		User u1=us.login(uname,upass);
		
		if(user==null) {
			throw new ServletException("Please enter user and password");

		}
		jwt_token= Jwts.builder().setSubject(uname).claim("uname",user.getUsername()).setIssuedAt(new Date()).signWith(SignatureAlgorithm.HS256,"secretKey").compact();
		return jwt_token;	
	}
	
}
