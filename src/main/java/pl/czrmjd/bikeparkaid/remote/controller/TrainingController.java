package pl.czrmjd.bikeparkaid.remote.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.czrmjd.bikeparkaid.remote.model.*;
import pl.czrmjd.bikeparkaid.service.DateUtils;
import pl.czrmjd.bikeparkaid.service.TrainingService;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/v1/date-training")
public class TrainingController {
    private final TrainingService trainingService;

    public TrainingController(TrainingService trainingService) {
        this.trainingService = trainingService;
    }

    @GetMapping
    public ResponseEntity<List<TrainingDto>> getTrainings(@RequestParam String dateStart,
                                                          @RequestParam String dateEnd,
                                                          @RequestParam TrainingType type) {

        List<TrainingDto> trainingDtos = trainingService.getAvailableTrainings(DateUtils.convertToDate(dateStart),
            DateUtils.convertToDate(dateEnd), type);
        return ResponseEntity.ok()
            .body(trainingDtos);
    }
}
