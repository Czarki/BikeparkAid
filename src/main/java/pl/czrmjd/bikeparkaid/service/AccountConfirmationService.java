package pl.czrmjd.bikeparkaid.service;

import org.springframework.stereotype.Service;
import pl.czrmjd.bikeparkaid.data.entity.VerificationTokenEntity;
import pl.czrmjd.bikeparkaid.remote.model.RegistrationDto;

import java.nio.charset.Charset;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Service
public class AccountConfirmationService {

    //metoda generująca token dla nowo stworzonego konta
    public String generateConfirmationToken() {
        byte[] array = new byte[7]; //
        new Random().nextBytes(array);
        String token = new String(array, Charset.forName("UTF-8"));
        return token;
    }

    //metoda umieszczajaca token w bazie danych
    public void storeToken(RegistrationDto registrationDto) {
        Date now = new Date();
        VerificationTokenEntity token = new VerificationTokenEntity();
        token.setToken(generateConfirmationToken());
        token.setConfirmedAt(now);
        token.setExpiresAt(new Date(now.getTime() + TimeUnit.DAYS.toMillis(1)));
        token.setUserEmail(registrationDto.getEmail());
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
