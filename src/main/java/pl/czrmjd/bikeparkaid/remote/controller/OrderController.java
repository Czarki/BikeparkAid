package pl.czrmjd.bikeparkaid.remote.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.czrmjd.bikeparkaid.remote.model.OrderDto;
import pl.czrmjd.bikeparkaid.service.AccessTokenService;
import pl.czrmjd.bikeparkaid.service.OrderService;

import static pl.czrmjd.bikeparkaid.service.DateUtils.convertToDate;


@RestController
@RequestMapping(value = "/api/v1/orders")
public class OrderController {
    private final AccessTokenService accessTokenService;
    private final OrderService orderService;

    public OrderController(AccessTokenService accessTokenService, OrderService orderService) {
        this.accessTokenService = accessTokenService;
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<String> createOrder(@RequestBody OrderDto orderDto,
                                              @RequestHeader("Authorization") String accessToken) {
        Integer userId = accessTokenService.getUserIdFromAccessToken(accessToken);
        if (userId == null) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN)
                .build();
        }
        return orderService.create(orderDto.getPassId(),
            orderDto.getBikeId(),
            convertToDate(orderDto.getBikeDateStart()),
            convertToDate(orderDto.getBikeDateEnd()),
            orderDto.getTrainingId(), userId);

    }
}
