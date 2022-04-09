package com.groupa15.utils;

import io.jsonwebtoken.*;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author Zirui Zhou
 * @date 2022/3/15
 */

@Data
@Component
@ConfigurationProperties(prefix = "jwt")
public class JwtUtils {

    private String secret;
    private long expire;
    private String header;

    public String generateToken(Long userId) {
        Date nowDate = new Date();
        Date expireDate = new Date(nowDate.getTime() + expire * 1000);

        /*
            TODO(Zirui): Define `iss`, `exp`, and `aud`.
         */
        return Jwts.builder()
                 .setHeaderParam(Header.TYPE, Header.JWT_TYPE)
                 .setSubject(Long.toString(userId))
                 .setIssuedAt(nowDate)
                 .setExpiration(expireDate)
                 .signWith(SignatureAlgorithm.HS512, secret)
                 .compact();
    }

    public Claims getClaimByToken(String token) throws JwtException {
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
    }

    public Long getUserIdByToken(String token) {
        return Long.parseLong(this.getClaimByToken(token).getSubject());
    }

    public boolean isTokenExpired(Date expiration) {
        return expiration.before(new Date());
    }

}
