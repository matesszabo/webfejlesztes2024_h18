package hu.unideb.inf.edzesnaplo.service.impl;

import hu.unideb.inf.edzesnaplo.service.JwtService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtServiceImpl implements JwtService {
    @Override
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    @Override
    public String generateToken(UserDetails userDetails) {//(UserDetails|String user, Map<String, Ojbject> publicClaims)
        Map<String, Object> claims = new HashMap<>();
        userDetails.getAuthorities().forEach(authority -> claims.put(authority.getAuthority(), authority));
        return Jwts.builder()
                .claims(claims)
                .subject(userDetails.getUsername())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis()+150000))
                .signWith(getKey())
                .compact();
    }

    @Override
    public boolean validateToken(String token, UserDetails userDetails) {
        Date d = extractClaim(token, Claims::getExpiration);
        boolean expired = d.before(new Date());
        final String username = extractClaim(token, Claims::getSubject);
        return (username.equals(userDetails.getUsername()) && !expired);
    }

    private <T> T extractClaim(String token, Function<Claims, T> claimsResolver){
        final Claims claims = Jwts.parser()
                .verifyWith(getKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();

        return claimsResolver.apply(claims);
    }

    private SecretKey getKey(){
        byte[] keyBytes = Decoders.BASE64.decode("z7zt68t8z7t687t6r78zftt77tdf8ztf98zfrt8z7tfr78ztf98uff8zgtfr78ztfd7ztd");
        return Keys.hmacShaKeyFor(keyBytes);
    }
}







