package com.smm.Config;

import java.io.IOException;

import org.hibernate.service.spi.ServiceException;
import org.springframework.web.filter.GenericFilterBean;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtFilter extends GenericFilterBean {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
			final HttpServletRequest req = (HttpServletRequest)request;
			final HttpServletResponse res = (HttpServletResponse)response;
			final String authHeader=req.getHeader("Authrization");
	
			if (authHeader==null || !authHeader.startsWith("Bearer")) {
				throw new ServiceException("Missing Authrization");
			
			}
			final String token=authHeader.substring(7);
			
			try {
			
				//final Claims claims=Jwts.parser().setSigningKey(key).build().parseClaimsJws();


				final Claims claims=Jwts.parser().setSigningKey("secretKey").build().parseClaimsJws(token).getBody();
				
			}catch(Exception e) {
			
			}
	}
	
	
	
}
