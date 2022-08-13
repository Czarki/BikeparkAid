package pl.czrmjd.bikeparkaid.service;

import org.springframework.stereotype.Service;
import pl.czrmjd.bikeparkaid.data.repository.BikeRepository;
import pl.czrmjd.bikeparkaid.remote.model.BikeDtoBackup;
import pl.czrmjd.bikeparkaid.remote.model.BikeSize;

import java.util.Collections;
import java.util.List;

@Service
public class BikeService {
    private final BikeRepository bikeRepository;

    public BikeService(BikeRepository bikeRepository) {
        this.bikeRepository = bikeRepository;
    }

    public List<BikeDtoBackup> getBikes(String dateStart, String dateEnd, BikeSize size) {
//        TODO: tutaj trzeba dodac logike, logika bedzie bardziej skomplikowana poniewaz
//         musimy zwrocic tylko dostepne rowery w tych terminach
        return Collections.emptyList();
    }
}
