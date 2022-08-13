package pl.czrmjd.bikeparkaid.data.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.czrmjd.bikeparkaid.remote.model.BikeSize;

import javax.persistence.*;
import java.math.BigDecimal;


//klasa reprezentujaca tabele w bazie danych, tabela nizej przechowuje informacje o uzytkownikach
//@Entity - dajemy znac bibliotece ze w tej klasie znajduje sie reprezentacja modelu tabeli
//@Table - precyzujemy nazwe tabeli
//@Column - definiujemy nazwe kolumny

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "bike")
public class BikeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "brand")
    private String brand;
    @Column(name = "model")
    private String model;
    @Column(name = "bike_size")
    private String size;
    @Column(name = "price")
    private BigDecimal price; //było string, ale jak wtedy wykonywać operacje na bazie?
    @Column(name = "is_available")
    private boolean isAvailable;
}
