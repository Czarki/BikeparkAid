package pl.czrmjd.bikeparkaid.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.czrmjd.bikeparkaid.remote.model.BikeSize;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
public class Bike {
    private final Integer id;
    private final String brand;
    private final String model;
    private final BikeSize size;
    private final BigDecimal price;
    private final boolean isAvailable;
}
