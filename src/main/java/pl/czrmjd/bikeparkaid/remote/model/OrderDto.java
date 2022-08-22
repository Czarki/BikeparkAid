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

    public void setPassId(Integer passId) {
        this.passId = passId;
    }

    public void setBikeId(Integer bikeId) {
        this.bikeId = bikeId;
    }

    public void setBikeDateStart(String bikeDateStart) {
        this.bikeDateStart = bikeDateStart;
    }

    public void setBikeDateEnd(String bikeDateEnd) {
        this.bikeDateEnd = bikeDateEnd;
    }

    public void setTrainingId(Integer trainingId) {
        this.trainingId = trainingId;
    }
}
