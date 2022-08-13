package pl.czrmjd.bikeparkaid.remote.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.czrmjd.bikeparkaid.remote.model.OrderDto;
import pl.czrmjd.bikeparkaid.remote.model.TrainingDto;
import pl.czrmjd.bikeparkaid.service.AccessTokenService;

//powinnismy uzywac liczby mnogiej , zmieniłem order na orders

@RestController
@RequestMapping(value = "/api/v1/orders")
public class OrderController {
    private final AccessTokenService accessTokenService;

    public OrderController(AccessTokenService accessTokenService) {
        this.accessTokenService = accessTokenService;
    }

    //    adnotacja @RequestBody oznacze ze do requestu jest dolaczone body (json) z danymi
//    w momencie kiedy klient przesle dane w body , my w metodzie dostaniemy obiekt klasy OrderDto wypełniony danymi
    @PostMapping
    public ResponseEntity<Void> createOrder(@RequestBody OrderDto orderDto,
                                            @RequestHeader("Authorization") String accessToken) {
        Integer userId = accessTokenService.getUserIdFromAccessToken(accessToken);
        if (userId == null) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN)
                .build();
        }



        return ResponseEntity.ok()
            .build();
    }
}
