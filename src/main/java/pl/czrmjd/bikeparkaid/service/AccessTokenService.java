package pl.czrmjd.bikeparkaid.service;

import io.jsonwebtoken.*;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.concurrent.TimeUnit;


//adnotacja Service oznacza ze mozemy korzystac z instancji klasy AccessTokenService wstrzykując ją poprzez konstruktor w innych
//klasach oznaczonych @Service @Repository lub @Component (te adnotacje sa rownoznaczne) rozniza sie tylko nazwa
@Service
public class AccessTokenService {
    private static final String SECRET = "secret";

    //    implementacja jwt metody generujacej access tokeny po zalogowaniu, jako parametr przyjmuje id uzytkownika z bazy danych
//    drugi parameter to flaga isAdmin , jesli uzytkownik jest adminem to w tokenie wpisujemy ta wartosc na true
//    pozniej przy korzystaniu z endpointu na podstawie tej flagi mozemy sie dowiedziec czy uzytkownik ma wymagane uprawnienia
    public String generateAccessToken(Integer userId, Boolean isAdmin) {
//        tutaj zdefiniowany czas zycia access tokenu jako date
        Date expirationDate = new Date(System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(15));
        byte[] secret = SECRET.getBytes();
        JwtBuilder jwtBuilder = Jwts.builder()
            .setSubject(String.valueOf(userId))
            .setExpiration(expirationDate)
            .claim("admin", isAdmin)
            .signWith(SignatureAlgorithm.HS256, secret);
        return jwtBuilder.compact();
    }

    public Integer getUserIdFromAccessToken(String accessToken) {
        byte[] secret = SECRET.getBytes();
        try {
            Jws<Claims> parsedToken = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(accessToken.replace("Bearer ", ""));
            return Integer.parseInt(parsedToken.getBody().getSubject());
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public Boolean getSuperAdminFlagFromAccessToken(String accessToken) {
        byte[] secret = SECRET.getBytes();
        try {
            Jws<Claims> parsedToken = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(accessToken.replace("Bearer ", ""));
            return parsedToken.getBody().get("admin", Boolean.class);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

}
