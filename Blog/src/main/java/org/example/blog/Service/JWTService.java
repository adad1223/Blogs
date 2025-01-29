//package org.example.blog.Service;
//
//import io.github.cdimascio.dotenv.Dotenv;
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.io.Decoders;
//import io.jsonwebtoken.security.Keys;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Service;
//import java.security.Key;
//import java.util.Date;
//import java.util.function.Function;
//
//@Service
//public class JWTService {
//    private String secretKey;
//
//    public JWTService() {
//        Dotenv dotenv = Dotenv.configure().directory("../").load();
//        this.secretKey = dotenv.get("SECRET_KEY");
//    }
//    public String fetchSecretKey() {
//
//        return secretKey;
//    }
//    private Key getKey() {
//        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
//        return Keys.hmacShaKeyFor(keyBytes);
//    }
//
//        public String extractUserName(String token) {
//            return extractClaim(token, Claims::getSubject);
//        }
//
//        private <T> T extractClaim(String token, Function<Claims, T> claimResolver) {
//            final Claims claims = extractAllClaims(token);
//            return claimResolver.apply(claims);
//        }
//
//        private Claims extractAllClaims(String token) {
//            return Jwts.parserBuilder()
//                    .setSigningKey(getKey())
//                    .build().parseClaimsJws(token).getBody();
//        }
//
//        public boolean validateToken(String token, UserDetails userDetails) {
//            final String userName = extractUserName(token);
//            return (userName.equals(userDetails.getUsername()) && !isTokenExpired(token));
//        }
//
//        private boolean isTokenExpired(String token) {
//            return extractExpiration(token).before(new Date());
//        }
//
//        private Date extractExpiration(String token) {
//            return extractClaim(token, Claims::getExpiration);
//        }
//}
