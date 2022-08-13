package pl.czrmjd.bikeparkaid.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.czrmjd.bikeparkaid.data.entity.VerificationTokenEntity;
import pl.czrmjd.bikeparkaid.data.entity.UserEntity;

//repozytoria jpa sluza do interakcji z baza danych (wykonywac operacje CRUD)

@Repository
public interface VerificationTokenRepository extends JpaRepository<VerificationTokenEntity, Integer> {

    VerificationTokenEntity findByUserEmail(String userEmail);
    VerificationTokenEntity findByToken(String token);
}
