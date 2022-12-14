package pl.czrmjd.bikeparkaid.remote.model;

import lombok.AllArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor

public class TrainingDto {
    private Integer id;
    private String name;
    private TrainingType type;
    private String dateStart;
    private String dateEnd;
    private Integer duration;
    private BigDecimal price;


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

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(TrainingType type) {
        this.type = type;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
