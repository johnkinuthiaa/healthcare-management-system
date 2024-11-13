package com.slippery.healthcare_management_system.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtService {
    private final long EXPIRATIONTIME =86400000L;
    private final String SECRETSTRING ="";

    protected SecretKey generateSecretKey(){
        byte[] keyBytes = Base64.getDecoder().decode(SECRETSTRING);
        return Keys.hmacShaKeyFor(keyBytes);
    }
    public String generateJwtToken(String username){
        Map<String,Object> claims =new HashMap<>();
        return Jwts.builder()
                .claims()
                .add(claims)
                .subject(username)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis()+EXPIRATIONTIME))
                .and()
                .signWith(generateSecretKey())
                .compact();
    }
}
