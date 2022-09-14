package pl.czrmjd.bikeparkaid.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.czrmjd.bikeparkaid.data.entity.VerificationTokenEntity;
import pl.czrmjd.bikeparkaid.data.repository.VerificationTokenRepository;
import pl.czrmjd.bikeparkaid.remote.model.RegistrationDto;

import java.util.*;
import java.util.concurrent.TimeUnit;

@Service
@AllArgsConstructor

public class AccountConfirmationService {

    private final VerificationTokenRepository tokenRepository;

    //metoda generująca token dla nowo stworzonego konta
    public String generateConfirmationToken() {
        return UUID.randomUUID().toString();
    }

    //metoda umieszczajaca token w bazie danych
    public String storeToken(RegistrationDto registrationDto) {
        Date now = new Date();
        VerificationTokenEntity token = new VerificationTokenEntity();
        String tokenBody = generateConfirmationToken();

        token.setToken(tokenBody);
        token.setCreatedAt(now);
        token.setExpiresAt(new Date(now.getTime() + TimeUnit.DAYS.toMillis(1)));
        token.setUserEmail(registrationDto.getEmail());
        tokenRepository.save(token);

        return tokenBody;
    }

//    //metoda sprawdzająca czy konto z danym emailem jest juz potwierdzone
//    public boolean checkIfAccountConfirmed(RegistrationDto registrationDto) {
//        if (tokenRepository.findByUserEmail(registrationDto.getEmail()) != null) {
//            return false;
//        } else {
//            return true;
//        }
//    }
}
