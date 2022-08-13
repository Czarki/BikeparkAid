package pl.czrmjd.bikeparkaid.remote.model;

import java.math.BigDecimal;

public class PassDto {
    private Integer id; // pole id bedzie nadawane podczas umieszczania rekordu w bazie dancyh


//    zmieniłem pole name na type tak aby uzyc enuma, nasz aplikacja (biblioteka jakson) przerobi wartość tego enuma na stringa
//    przykład enum SEASON zostanie przerobiony na tekst "SEASON" itd. uzycie enumow jest wskazane
    private PassType type;
    private BigDecimal price; // poniewaz operujemy na finansach powinnismy zamiast obiektow double / fload uzywac klasy BigDecimal
//    double i float nie sa bezpieczne jesli chodzi o uzycie w finansach poniwaz wystepuja przeklamiania w przyblizaniu
//    dlatego zostałą wprowadzona klasa BigDecimal wolna od tego typu problemow

    public PassDto() {
    }

    public PassDto(Integer id, PassType type, BigDecimal price) {
        this.id = id;
        this.type = type;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PassType getType() {
        return type;
    }

    public void setType(PassType type) {
        this.type = type;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
