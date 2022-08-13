package pl.czrmjd.bikeparkaid.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.czrmjd.bikeparkaid.data.entity.TrainingEntity;

import java.util.List;

//repozytoria jpa sluza do interakcji z baza danych (wykonywac operacje CRUD)

@Repository
public interface TrainingRepository extends JpaRepository<TrainingEntity, Integer> {
    /*tutaj bardzo wazna jest nazwa metody. jest to metoda generyczna ktora pozwala w zaleznosci od slow kluczowych w nazwie generowac \
    * odpowiednie zapytania sql*/

    List<TrainingEntity> findAllByType(String type);
}
