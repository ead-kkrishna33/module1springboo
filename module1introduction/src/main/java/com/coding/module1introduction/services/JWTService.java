package com.coding.module1introduction.services;

import com.coding.module1introduction.entities.UserEntity;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Set;

@Service
public class JWTService {

    @Value("${jwt.secretKey}")
    private String jwtSecretKey;
// here we create 2 methode 1 . to create the token 2. to verify the token // subject is something to identify the user
    public String generateToken(UserEntity userEntity){
     return Jwts.builder()
                .subject(userEntity.getId().toString())
                .claim("email", userEntity.getEmail())
                .claim("roles", Set.of("ADMN","USER"))
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 600000))
                .signWith(getSecretKey())
                .compact();
        }
        // to generate ScretKey Obj
        private SecretKey getSecretKey() {
           return Keys.hmacShaKeyFor(jwtSecretKey.getBytes(StandardCharsets.UTF_8));
        }
     public Long getUserIdFromToken(String token){
          Claims claims = Jwts.parser()
                  .verifyWith(getSecretKey())
                  .build()
                  .parseSignedClaims(token)
                  .getPayload();
        //  return Long.parseLong(String.valueOf(claims.get("id")));
            return Long.valueOf(claims.getSubject());
     }
}
