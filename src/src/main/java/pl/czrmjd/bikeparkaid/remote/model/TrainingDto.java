package pl.czrmjd.bikeparkaid.remote.model;

import java.math.BigDecimal;

public class TrainingDto {
    private Integer id;
    private String name;
    private TrainingType type;
    private String dateStart;
    private String dateEnd;
    private Integer duration;
    private BigDecimal price;


    public TrainingDto() {
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public TrainingType getType() {
        return type;
    }

    public String getDateStart() {
        return dateStart;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public Integer getDuration() {
        return duration;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
