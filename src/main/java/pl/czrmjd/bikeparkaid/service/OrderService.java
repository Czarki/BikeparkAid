package pl.czrmjd.bikeparkaid.service;

import pl.czrmjd.bikeparkaid.data.entity.BikeEntity;
import pl.czrmjd.bikeparkaid.data.entity.OrderEntity;
import pl.czrmjd.bikeparkaid.data.entity.PassEntity;
import pl.czrmjd.bikeparkaid.data.entity.TrainingEntity;
import pl.czrmjd.bikeparkaid.data.repository.OrderRepository;

import java.util.Date;

public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {

        this.orderRepository = orderRepository;
    }

    //metoda zapisująca zamówienie w bazie
    public void create(Integer passId, Integer bikeId,    //Zmiana na integer itd, bez sensu cały obiekt
                                Date dateStart, Date dateEnd,
                                TrainingEntity training) {

        OrderEntity order = new OrderEntity();
        order.setPassId(passId);
        order.setBikeId(bikeId);                      //Tu też sprawdzenie dostępności treningów i rowerów
        order.setDateStart(dateStart);
        order.setDateEnd(dateEnd);
        order.setTrainingId(training.getId());
        orderRepository.save(order);

    }


}
