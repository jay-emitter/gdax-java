package co.emitter.gdax.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Created by jeremy on 7/4/16.
 */
@Data
public class Trade {
    private String time;
    @JsonProperty("trade_id")
    private String tradeId;
    private String price;
    private String size;
    private String side; // buy or sell
}
