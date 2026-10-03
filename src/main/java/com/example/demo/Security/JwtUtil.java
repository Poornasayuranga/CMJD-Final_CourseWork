package com.example.demo.Security;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import com.example.demo.Entity.UserRoles;
import java.util.Date;

@Component
public class JwtUtil {
    private final long EXPIRATION_TIME = 1000*60*30; //0.5hour
    private final String SECRETE_KEY =  "a8f9c3e7b1d4a6f92c8e5f7a1b3d6c9e8f2a4b6c7d9e1f3a5c7b9d2e4f6a8c1";
    private final SecretKey key = Keys.hmacShaKeyFor(SECRETE_KEY.getBytes());

    public String generateToken(String userName, UserRoles role) {
        return Jwts.builder()
                .setSubject(userName)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+EXPIRATION_TIME))
                .claim("role", role)
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    private Claims extractClaims(String token){
        return Jwts.parser()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public String extractUsername(String token){
        return extractClaims(token).getSubject();
    }

    private boolean isTokenExpired(String token){
        return extractClaims(token).getExpiration().before(new Date(System.currentTimeMillis()));
    }

    public boolean isTokenValid(String userName, UserDetails user, String token){
        return userName.equals(user.getUsername()) && !isTokenExpired(token);
    }

}
