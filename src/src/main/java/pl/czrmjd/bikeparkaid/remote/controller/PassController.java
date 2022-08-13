package pl.czrmjd.bikeparkaid.remote.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.czrmjd.bikeparkaid.remote.model.PassDto;

import java.util.List;


//powinnismy uzywac liczby mnogiej , zmieniłem pass na passes
@RestController
@RequestMapping(value = "/api/v1/passes")
public class PassController {

//    metoda nie ma zadnych prameterow poniewaz w requscie nie dodajemy dodatkowych informacji
    @GetMapping
    public ResponseEntity<List<PassDto>> getPasses() {

//        jeśli chcemy wystać status odpowiedzi 200 OK nie trzeba uzywac metody .status() mozna bezposrednio
//        uzyc metody .ok() jest ona rownoznaczna z metoda .status(HttpStatus.OK)
        return ResponseEntity.ok()
            .build();
    }
}
