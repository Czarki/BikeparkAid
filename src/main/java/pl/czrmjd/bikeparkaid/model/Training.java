package pl.czrmjd.bikeparkaid.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.czrmjd.bikeparkaid.remote.model.TrainingType;

import java.math.BigDecimal;
import java.time.Period;
import java.util.Date;

@AllArgsConstructor
@Getter
public class Training {
    private final Integer id;
    private final String name;
    private final TrainingType type;
    private final Date dateStart; //shift + F6
    private final Date dateEnd;
    private final Integer duration; //w TrainingDto jest Integer. Do czego potrzebny będzie czas trwania?
    private final BigDecimal price;
}
