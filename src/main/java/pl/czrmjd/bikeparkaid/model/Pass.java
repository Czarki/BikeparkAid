package pl.czrmjd.bikeparkaid.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.czrmjd.bikeparkaid.remote.model.PassType;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
public class Pass {
    private final Integer id;
    private final PassType type;
    private final BigDecimal price;
}
