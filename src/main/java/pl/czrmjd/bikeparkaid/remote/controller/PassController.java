package pl.czrmjd.bikeparkaid.remote.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.czrmjd.bikeparkaid.remote.model.PassDto;
import pl.czrmjd.bikeparkaid.service.PassService;

import java.util.List;


//powinnismy uzywac liczby mnogiej , zmieniłem pass na passes
@RestController
@CrossOrigin
@RequestMapping(value = "/api/v1/passes")
public class PassController {
    private final PassService passService;

    public PassController(PassService passService) {
        this.passService = passService;
    }

    //    metoda nie ma zadnych prameterow poniewaz w requscie nie dodajemy dodatkowych informacji
    @GetMapping
    public ResponseEntity<List<PassDto>> getPasses() {
        List<PassDto> passDtos = passService.getPasses();
//        jeśli chcemy wystać status odpowiedzi 200 OK nie trzeba uzywac metody .status() mozna bezposrednio
//        uzyc metody .ok() jest ona rownoznaczna z metoda .status(HttpStatus.OK)
        return ResponseEntity.ok()
            .body(passDtos);
    }
}
