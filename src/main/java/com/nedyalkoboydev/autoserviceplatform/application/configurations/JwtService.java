package com.nedyalkoboydev.autoserviceplatform.application.configurations;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nedyalkoboydev.autoserviceplatform.domain.dtos.UserDTO;
import com.nedyalkoboydev.autoserviceplatform.domain.entities.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import io.jsonwebtoken.Claims;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {
    @Value("${secret.key}")
    private String SECRET_KEY;

    public String extractUsername(String token) throws JsonProcessingException {
        String sub = extractClaim(token, Claims::getSubject);
        UserDTO userDto = new ObjectMapper().readValue(sub, UserDTO.class);
        return userDto.getEmail();
    }

    private <T> T extractClaim(java.lang.String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts
                .parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public String generateToken(User userDetails) {
        return generateToken(new HashMap<>(), userDetails);
    }

    public String generateToken(
            Map<String, Object> extraClaims,
            User userDetails
    ) {
        return Jwts
                .builder()
                .setClaims(extraClaims)
                .setSubject(UserDTO.builder()
                        .id(userDetails.getId())
                        .firstname(userDetails.getFirstName())
                        .lastname(userDetails.getLastName())
                        .email(userDetails.getEmail())
                        .role(userDetails.getRole().name())
                        .build().toString())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24)) // One day
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public boolean isTokenValid(String token, UserDetails userDetails) throws JsonProcessingException {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }


}
