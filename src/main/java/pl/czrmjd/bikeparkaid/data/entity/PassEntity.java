package pl.czrmjd.bikeparkaid.data.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
@Table(name = "pass")
public class PassEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "type")
    private String type;
    @Column(name = "price")
    private BigDecimal price;


}
