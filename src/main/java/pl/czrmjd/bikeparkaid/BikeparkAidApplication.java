package pl.czrmjd.bikeparkaid;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BikeparkAidApplication {

    public static void main(String[] args) {
        SpringApplication.run(BikeparkAidApplication.class, args);
        //docker inspect -f '{{range.NetworkSettings.Networks}}{{.IPAddress}}{{end}}' 7bda781e53c6214667c3eb48804dc5cd35f602eaecb88abd8288e5df07bc185c
        //TODO:
        //1. Endpoint z zapisywaniem zamowienia
        // Jak okreslic datę zamówienia - przy treningach sprawa jest jasna, bo maja okreslona datę, ale jak
        // uwzględnić datę roweru
        //2. Mailer z potwierdzeniem rejestracji konta
    }

}
