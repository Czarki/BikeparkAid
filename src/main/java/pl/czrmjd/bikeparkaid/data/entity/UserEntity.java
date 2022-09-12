package pl.czrmjd.bikeparkaid.data.entity;

import lombok.*;

import javax.persistence.*;


//klasa reprezentujaca tabele w bazie danych, tabela nizej przechowuje informacje o uzytkownikach
//@Entity - dajemy znac bibliotece ze w tej klasie znajduje sie reprezentacja modelu tabeli
//@Table - precyzujemy nazwe tabeli
//@Column - definiujemy nazwe kolumny

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "hash")
    private String hash;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "account_confirmed")
    private boolean accountConfirmed;
    @Column(name = "is_admin")
    private boolean isAdmin;
    @Column(name = "address")
    private String address;
    @Column(name = "tel_number")
    private String number;
}
