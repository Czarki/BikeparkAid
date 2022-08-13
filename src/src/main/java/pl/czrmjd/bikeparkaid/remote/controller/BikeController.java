package pl.czrmjd.bikeparkaid.remote.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.czrmjd.bikeparkaid.remote.model.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/bikes")
public class BikeController {

//    metoda nie ma zadnych prameterow poniewaz w requscie nie dodajemy dodatkowych informacji
    @GetMapping
    public ResponseEntity<List<BikeDto>> getBikes(@RequestParam String dateStart,
                                                  @RequestParam String dateEnd,
                                                  @RequestParam BikeSize size) {
//Request param -> w postamanie to sa tak zwane query params, sa to dane przesylane w requscie w endpoincie
//       przykład
//        /api/v1/bikes?paramA=123&paramB=abc
//        taki requet oznacza ze zostały wysłany 2 query params,
//        pierwszy: paramA o wartosci 123 i drugi: paramB o wartosci abc
//        w naszej aplikacji przekazujemy daty (dateStart i dateEnd) jako stringu, daty musza miec odpowiedni format
//        wykorzystamy taki YYYY-mm-dd HH:mm:ss np. (2022-04-28 15:35:39)
//        te stringi (daty) bedziemy zamieniac pozniej na obiekty javove reprezentujace daty np. klasa Date

        return ResponseEntity.ok()
            .body(List.of(new BikeDto()));
    }
}
