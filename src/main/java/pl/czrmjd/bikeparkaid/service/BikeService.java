package pl.czrmjd.bikeparkaid.service;

import org.springframework.stereotype.Service;
import pl.czrmjd.bikeparkaid.data.entity.BikeEntity;
import pl.czrmjd.bikeparkaid.data.entity.OrderEntity;
import pl.czrmjd.bikeparkaid.data.entity.TrainingEntity;
import pl.czrmjd.bikeparkaid.data.repository.BikeRepository;
import pl.czrmjd.bikeparkaid.data.repository.OrderRepository;
import pl.czrmjd.bikeparkaid.model.Bike;
import pl.czrmjd.bikeparkaid.remote.model.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class BikeService {
    private final BikeRepository bikeRepository;
    private final OrderRepository orderRepository;

    public BikeService(BikeRepository bikeRepository, OrderRepository orderRepository) {

        this.bikeRepository = bikeRepository;
        this.orderRepository = orderRepository;
    }

    public List<BikeDto> getAvailableBikes(Date dateStart, Date dateEnd, BikeSize size) {
        List<BikeEntity> bikeEntities = bikeRepository.findBySize(size.name());

        List<BikeDto> result = new ArrayList<>();
        for (BikeEntity bikeEntity : bikeEntities) {
            List<OrderEntity> orderEntities = orderRepository.findAllByBikeId(bikeEntity.getId());
            for (OrderEntity orderEntity : orderEntities) {
                if ((orderEntity.getDateStart().before(dateStart) && orderEntity.getDateEnd().after(dateStart)) ||
                        (orderEntity.getDateStart().before(dateEnd) && orderEntity.getDateEnd().after(dateEnd)) ||
                        (orderEntity.getDateStart().after(dateStart) && orderEntity.getDateEnd().before(dateEnd))) {
//                    nie mozemy dodac poniewaz istnieje zamowienie w tym czasie
                    continue;
                }
                if (bikeEntity.isAvailable()) {
                    result.add(new BikeDto(bikeEntity.getId(), bikeEntity.getBrand(),
                            bikeEntity.getModel(), BikeSize.valueOf(bikeEntity.getSize()),
                            bikeEntity.getPrice()));
                }
            }
        }
        return result;
    }
}
