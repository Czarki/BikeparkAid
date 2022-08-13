package pl.czrmjd.bikeparkaid.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.czrmjd.bikeparkaid.data.entity.UserEntity;
import pl.czrmjd.bikeparkaid.data.entity.VerificationTokenEntity;
import pl.czrmjd.bikeparkaid.data.repository.UserRepository;
import pl.czrmjd.bikeparkaid.data.repository.VerificationTokenRepository;
import pl.czrmjd.bikeparkaid.remote.model.RegistrationDto;

import java.util.Date;

//klasa sluzaca do interakcji z baza danych z tabela users
@Service
public class UserService extends RuntimeException {
    //    klasa sluzaca do generowania hasha i sprawdzania czy pasuje
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final VerificationTokenRepository verificationTokenRepository;
    private final AccountConfirmationService accountConfirmationService;

    public UserService(PasswordEncoder passwordEncoder, UserRepository userRepository,
                       VerificationTokenRepository verificationTokenRepository,
                       AccountConfirmationService accountConfirmationService) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.verificationTokenRepository = verificationTokenRepository;
        this.accountConfirmationService = accountConfirmationService;
    }

    //    metoda do umieszczenia uzytkownika w bazie danych
    public void register(RegistrationDto registrationDto) throws RuntimeException {

        if (checkExistUserByEmail(registrationDto.getEmail())) {
            throw new RuntimeException("This email address already exists in our database");
        } else {
            String passwordHash = passwordEncoder.encode(registrationDto.getPassword());
            UserEntity user = new UserEntity();
            user.setHash(passwordHash);
            user.setEmail(registrationDto.getEmail());
            user.setFirstName(registrationDto.getName());
            user.setLastName(registrationDto.getSurname());
            user.setAccountConfirmed(false);
            user.setAdmin(false);
            userRepository.save(user);
        }
        accountConfirmationService.storeToken(registrationDto);

    }

    //    metoda sprawdzajaca czy istnieje w bazie user o takim emailu i hasle
    public boolean checkExistUserByEmailAndPassword(String email, String password) {
        String passwordHash = passwordEncoder.encode(password);
        UserEntity user = getUserByEmail(email);
        if (user != null && user.getHash().equals(passwordHash)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkExistUserByEmail(String email) {
        if (getUserByEmail(email) != null) {
            return true;
        } else {
            return false;
        }
    }

    //    pobranie usera na podstawie emaila
    public UserEntity getUserByEmail(String email) throws RuntimeException {
        return userRepository.findByEmail(email);
    }

    public void confirmAccount(String token) {
        Date now = new Date();
        VerificationTokenEntity verificationTokenEntity = verificationTokenRepository.findByToken(token);
        if (verificationTokenEntity == null || verificationTokenEntity.getConfirmedAt() != null
            || verificationTokenEntity.getExpiresAt().before(now)) {
            return;
        }
        verificationTokenEntity.setConfirmedAt(new Date());
        UserEntity userEntity = userRepository.findByEmail(verificationTokenEntity.getUserEmail());
        if (userEntity == null) {
            return;
        }
        userEntity.setAccountConfirmed(true);

        userRepository.save(userEntity);
        verificationTokenRepository.save(verificationTokenEntity);
    }
}
