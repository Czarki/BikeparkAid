package pl.czrmjd.bikeparkaid.remote.model;

import lombok.NoArgsConstructor;
import lombok.Getter;
import java.math.BigDecimal;

@NoArgsConstructor
@Getter
public class BikeDto {
    private Integer id;
    private String brand;
    private String model;
    private BikeSize size;
    private BigDecimal price;
    private boolean isAvailable;
}
