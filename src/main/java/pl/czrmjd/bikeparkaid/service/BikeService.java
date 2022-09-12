package pl.czrmjd.bikeparkaid.service;

import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import pl.czrmjd.bikeparkaid.data.entity.BikeEntity;
import pl.czrmjd.bikeparkaid.data.entity.OrderEntity;
import pl.czrmjd.bikeparkaid.data.repository.BikeRepository;
import pl.czrmjd.bikeparkaid.data.repository.OrderRepository;
import pl.czrmjd.bikeparkaid.remote.model.*;

import java.util.ArrayList;
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

            if (!bikeEntity.isAvailable()) {
                continue;
            }

            List<OrderEntity> orderEntities = orderRepository.findAllByBikeId(bikeEntity.getId());

            if (orderEntities.isEmpty()) {
                result.add(new BikeDto(bikeEntity.getId(), bikeEntity.getBrand(),
                        bikeEntity.getModel(), BikeSize.valueOf(bikeEntity.getSize()),
                        bikeEntity.getPrice(), bikeEntity.isAvailable()));
            } else {

                boolean canAddBike = true;

                for (OrderEntity orderEntity : orderEntities) {

                    if ((orderEntity.getDateStart().before(dateStart) && orderEntity.getDateEnd().after(dateStart)) ||
                            (orderEntity.getDateStart().before(dateEnd) && orderEntity.getDateEnd().after(dateEnd)) ||
                            (orderEntity.getDateStart().after(dateStart) && orderEntity.getDateEnd().before(dateEnd))) {
                        canAddBike = false;
//                    nie mozemy dodac poniewaz istnieje zamowienie w tym czasie
                        break;
                    }

                }
                if (canAddBike) {


                    result.add(new BikeDto(bikeEntity.getId(), bikeEntity.getBrand(),
                            bikeEntity.getModel(), BikeSize.valueOf(bikeEntity.getSize()),
                            bikeEntity.getPrice(), bikeEntity.isAvailable()));
                }
            }


        }

        return result;
    }
}
