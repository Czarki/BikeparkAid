package pl.czrmjd.bikeparkaid.remote.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class BikeDto {
    private Integer id;
    private String brand;
    private String model;
    private BikeSize size;
    private BigDecimal price;
    private boolean isAvailable;



    @Override
    public String toString() {
        return "BikeDto{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", size=" + size +
                ", price=" + price +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
