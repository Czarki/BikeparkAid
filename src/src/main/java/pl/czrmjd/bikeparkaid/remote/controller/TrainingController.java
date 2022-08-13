package pl.czrmjd.bikeparkaid.remote.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.czrmjd.bikeparkaid.remote.model.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/date-training")
public class TrainingController {
    @GetMapping
    public ResponseEntity<List<TrainingDto>> getTrainings(@RequestParam String dateStart,
                                                          @RequestParam String dateEnd,
                                                          @RequestParam TrainingType type) {

        return ResponseEntity.ok()
            .body(List.of(new TrainingDto()));
    }
}
