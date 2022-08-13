package pl.czrmjd.bikeparkaid.remote.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.czrmjd.bikeparkaid.remote.model.TrainingDto;

//powinnismy uzywac liczby mnogiej , zmieniłem order na orders

@RestController
@RequestMapping(value = "/api/v1/orders")
public class OrderController {
//    adnotacja @RequestBody oznacze ze do requestu jest dolaczone body (json) z danymi
//    w momencie kiedy klient przesle dane w body , my w metodzie dostaniemy obiekt klasy TrainingDto wypełniony danymi
    @PostMapping
    public ResponseEntity<Void> createOrder(@RequestBody TrainingDto trainingDto) {

        return ResponseEntity.ok()
            .build();
    }
}
