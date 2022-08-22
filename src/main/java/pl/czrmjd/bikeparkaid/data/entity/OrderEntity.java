package pl.czrmjd.bikeparkaid.data.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


//klasa reprezentujaca tabele w bazie danych, tabela nizej przechowuje informacje o uzytkownikach
//@Entity - dajemy znac bibliotece ze w tej klasie znajduje sie reprezentacja modelu tabeli
//@Table - precyzujemy nazwe tabeli
//@Column - definiujemy nazwe kolumny

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "order")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "pass_id")
    private Integer passId;
    @Column(name = "bike_id")
    private Integer bikeId;
    @Column(name = "date_start")
    private Date dateStart;
    @Column(name = "date_end")
    private Date dateEnd;
    @Column(name = "training_id")
    private Integer trainingId;
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "price")
    private BigDecimal price;

}
