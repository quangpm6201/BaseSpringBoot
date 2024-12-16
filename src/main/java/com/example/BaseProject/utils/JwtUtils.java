package com.example.BaseProject.utils;

import com.example.BaseProject.modal.request.User.UserLoginRequest;
import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Component
public class JwtUtils {

    public String generateToken(UserLoginRequest user) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("username", user.getUsername());
        claims.put("role", "ADMIN");
        return createToken(claims);
    }

    private String createToken(Map<String, Object> claims)
    {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject("AuthenticateForProject")
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + TimeUnit.HOURS.toMillis(24)))
                .signWith(SignatureAlgorithm.HS256, "AuthKeyForMyProject")
                .compact();
    }

    public Claims getInfoFromToken (String token) {
        return Jwts.parser()
                .setSigningKey("AuthKeyForMyProject")
                .parseClaimsJws(token).getBody();
    }

}
