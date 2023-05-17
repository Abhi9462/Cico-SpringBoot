package com.cico.Util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtil {
	@Value("${secret}")
	private String secret;

	private String generateToken(Map<String, Object> claims, String subject) {

		return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(5)))
				.setIssuer("Abhishek").signWith(SignatureAlgorithm.HS256, secret).compact();

	}
	
	public String generateToken(String subject) {
		Map<String, Object> claims=new HashMap<>();
		return generateToken(claims,subject);
	}
	
	private Claims getClaims(String token) {
		return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
	}
	
	public  String getUsername(String token) {
		return getClaims(token).getSubject();
		
	}
}
