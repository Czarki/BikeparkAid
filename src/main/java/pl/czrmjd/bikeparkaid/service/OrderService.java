package pl.czrmjd.bikeparkaid.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.czrmjd.bikeparkaid.data.entity.*;
import pl.czrmjd.bikeparkaid.data.repository.*;

import java.math.BigDecimal;
import java.time.temporal.ChronoUnit;
import java.util.*;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final BikeRepository bikeRepository;
    private final PassRepository passRepository;
    private final TrainingRepository trainingRepository;

    public OrderService(OrderRepository orderRepository, BikeRepository bikeRepository, PassRepository passRepository,
                        TrainingRepository trainingRepository) {
        this.orderRepository = orderRepository;
        this.bikeRepository = bikeRepository;
        this.passRepository = passRepository;
        this.trainingRepository = trainingRepository;
    }

    //metoda zapisująca zamówienie w bazie
    public ResponseEntity<String> create(Integer passId, Integer bikeId,
                                         Date dateStart, Date dateEnd,
                                         Integer trainingId) {

        Optional<BikeEntity> bikeOpt = bikeRepository.findById(bikeId);
        if (bikeOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Nie istnieje rower o podanym id");
        }
// sprawdzamy czy istnieje juz zamowienie na rower w tym czasie
        List<OrderEntity> orderEntities = orderRepository.findAllByBikeId(bikeId);

        for (OrderEntity orderEntity : orderEntities) {
            if ((orderEntity.getDateStart().before(dateStart) && orderEntity.getDateEnd().after(dateStart)) ||
                (orderEntity.getDateStart().before(dateEnd) && orderEntity.getDateEnd().after(dateEnd)) ||
                (orderEntity.getDateStart().after(dateStart) && orderEntity.getDateEnd().before(dateEnd))) {
//                istnieje juz zamowienie w tym czasie
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Podany rower jest zarezerwowany pomiedzy datami start i end");
            }
        }

        Optional<PassEntity> passOpt = passRepository.findById(passId);
        if (passOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Nie istnieje karnet o podanym id");
        }

        Optional<TrainingEntity> trainingEntityOpt = trainingRepository.findById(trainingId);
        if (trainingEntityOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Nie istnieje trening o podanym id");
        }

//        teraz liczymy cene roweru
        long daysBetween = ChronoUnit.DAYS.between(dateStart.toInstant(), dateEnd.toInstant());
        double bikePrice = bikeOpt.get().getPrice().doubleValue() * daysBetween;

//        teraz liczymy cene calego zamowienia
        double orderPrice = bikePrice + trainingEntityOpt.get().getPrice().doubleValue()
            + passOpt.get().getPrice().doubleValue();

        OrderEntity order = new OrderEntity();
        order.setPassId(passId);
        order.setBikeId(bikeId);
        order.setDateStart(dateStart);
        order.setDateEnd(dateEnd);
        order.setTrainingId(trainingId);
        order.setPrice(BigDecimal.valueOf(orderPrice));
        orderRepository.save(order);
        return ResponseEntity.status(HttpStatus.CREATED)
            .body("Zamowienie zostało utworzone");
    }
}