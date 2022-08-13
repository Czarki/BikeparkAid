package pl.czrmjd.bikeparkaid.remote.model;

import java.math.BigDecimal;

public class BikeDto {
    private Integer id;
    private String name;
    private BikeSize size;
    private BigDecimal price;

    public BikeDto() {
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BikeSize getSize() {
        return size;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
