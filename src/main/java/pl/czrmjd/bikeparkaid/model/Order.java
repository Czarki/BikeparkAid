package pl.czrmjd.bikeparkaid.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.util.Date;

@AllArgsConstructor
@Getter
public class Order {
    private final Integer id;
    private final Integer bikeId;
    private final Date bikeDateStart;
    private final Date bikeDateEnd;
    private final Integer trainingId;
    private final Integer userId;
}
