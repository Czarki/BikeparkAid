package pl.czrmjd.bikeparkaid.service;

import org.springframework.stereotype.Service;
import pl.czrmjd.bikeparkaid.data.entity.PassEntity;
import pl.czrmjd.bikeparkaid.data.repository.PassRepository;
import pl.czrmjd.bikeparkaid.remote.model.PassDto;
import pl.czrmjd.bikeparkaid.remote.model.PassType;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PassService {
    private final PassRepository passRepository;

    public PassService(PassRepository passRepository) {
        this.passRepository = passRepository;
    }

    public List<PassDto> getPasses() {
        List<PassEntity> passEntities = passRepository.findAll();
        return passEntities.stream()
            .map(passEntity -> new PassDto(passEntity.getId(), PassType.valueOf(passEntity.getType().toUpperCase()),
                passEntity.getPrice()))
            .collect(Collectors.toList());
    }
}
