package com.stackroute.authentication.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.stackroute.authentication.domain.User;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtSecurityTokenGeneratorImpl implements SecurityTokenGenerator{

	@Override
	public Map<String, String> generateToken(User user) {
		// TODO Auto-generated method stub
		String jwtToken=null;
		jwtToken=Jwts.builder().setSubject(user.getUserName()).setIssuedAt(new Date())
				.signWith(SignatureAlgorithm.HS256,"secretkey").compact();
		Map<String,String>	map=new HashMap<>();
		map.put("token",jwtToken);
		map.put("message","User successfully logged in");
			
		return map;
	}

}
