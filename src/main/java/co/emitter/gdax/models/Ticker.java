package co.emitter.gdax.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Created by jeremy on 7/4/16.
 */
@Data
public class Ticker {
    @JsonProperty("trade_id")
    private String tradeId;
    private String size;
    private String price;
    private String bid;
    private String ask;
    private String volume;
    private String time;
}
