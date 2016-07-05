package co.emitter.gdax.models;

import lombok.Getter;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * Created by jeremy on 7/4/16.
 */
@Getter
public class HistoricRate {
    public HistoricRate(Double[] data) {
        time = Instant.ofEpochSecond(data[0].longValue()).atZone(ZoneId.of("UTC")).toLocalDateTime();
        low = BigDecimal.valueOf(data[1]);
        high = BigDecimal.valueOf(data[2]);
        open = BigDecimal.valueOf(data[3]);
        close = BigDecimal.valueOf(data[4]);
        volume = BigDecimal.valueOf(data[5]);
    }
    private LocalDateTime time;
    private BigDecimal low;
    private BigDecimal high;
    private BigDecimal open;
    private BigDecimal close;
    private BigDecimal volume;
}
