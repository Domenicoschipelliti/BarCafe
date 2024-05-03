package Domenico.BarCafe.Security;

import Domenico.BarCafe.Enteties.Utente;
import Domenico.BarCafe.Exceptions.Unauthorized;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Jwts {
    @Value("${spring_JwT_key}")
    private String jwtsKey;

    public String createToken(Utente user){
        return io.jsonwebtoken.Jwts.builder().subject(String.valueOf(user.getUserId())) // Subject <-- A chi appartiene il token (id dell'utente)
                .issuedAt(new Date(System.currentTimeMillis())) // Data di emissione (IAT - Issued At)
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 8)) // Data di scadenza (Expiration Date)
                .signWith(Keys.hmacShaKeyFor(jwtsKey.getBytes())) // Firmo il token
                .compact();
    }


    public void verifyToken(String token){
        try {
            io.jsonwebtoken.Jwts.parser().verifyWith(Keys.hmacShaKeyFor(jwtsKey.getBytes())).build().parse(token);
        } catch (Exception ex) {
            throw new Unauthorized("Problemi col token! Per favore effettua di nuovo il login!");
        }
    }
    public String extractIdFromToken(String token) {
        return io.jsonwebtoken.Jwts.parser()
                .verifyWith(Keys.hmacShaKeyFor(jwtsKey.getBytes()))
                .build()
                .parseSignedClaims(token).getPayload().getSubject();
    }

}
