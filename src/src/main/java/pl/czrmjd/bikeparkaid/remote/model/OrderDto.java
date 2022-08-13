package pl.czrmjd.bikeparkaid.remote.model;

public class OrderDto {
    private Integer passId;
    private Integer bikeId;
    private String bikeDateStart;
    private String bikeDateEnd;
    private Integer trainingId;

    public OrderDto() {
    }

    public Integer getPassId() {
        return passId;
    }

    public Integer getBikeId() {
        return bikeId;
    }

    public String getBikeDateStart() {
        return bikeDateStart;
    }

    public String getBikeDateEnd() {
        return bikeDateEnd;
    }

    public Integer getTrainingId() {
        return trainingId;
    }
}
