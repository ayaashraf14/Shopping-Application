//package com.example.demo.config;
//
//import com.example.demo.service.CustomerDetailsService;
//import com.example.demo.service.CustomerPrincipal;
//import io.jsonwebtoken.*;
//import lombok.Value;
//import org.slf4j.LoggerFactory;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Component;
//
//import java.util.Base64;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.function.Function;
//import java.util.logging.Logger;
//
//@Component
//public class JwtUnil {
//    private static final Logger logger = (Logger) LoggerFactory.getLogger(JwtUnil.class);
//
//
//    private String jwtSecret;
//
//    private int jwtExpirationMs;
//
//    public String generateJwtToken(Authentication authentication) {
//
//        CustomerPrincipal customerDetailsService = (CustomerPrincipal) authentication.getPrincipal();
//
//        return Jwts.builder().setSubject((customerDetailsService.getUsername())).setIssuedAt(new Date())
//                .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs)).signWith(SignatureAlgorithm.HS512, jwtSecret)
//                .compact();
//    }
//
//    public String getUserNameFromJwtToken(String token) {
//        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
//    }
//
//    public boolean validateJwtToken(String authToken) {
//        try {
//            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
//            return true;
//        } catch (SignatureException e) {
//            logger.info("Invalid JWT signature: {}");
//        } catch (MalformedJwtException e) {
//            logger.info("Invalid JWT token: {}");
//        } catch (ExpiredJwtException e) {
//            logger.info("JWT token is expired: {}");
//        } catch (UnsupportedJwtException e) {
//            logger.info("JWT token is unsupported: {}");
//        } catch (IllegalArgumentException e) {
//            logger.info("JWT claims string is empty: {}");
//        }
//
//        return false;
//    }
//}
