package co.emitter.gdax.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Created by jeremy on 7/3/16.
 */
@Data
public class Product {
    private String id;
    @JsonProperty("base_currency")
    private String baseCurrency;
    @JsonProperty("quote_currency")
    private String quoteCurrency;
    @JsonProperty("base_min_size")
    private String baseMinSize;
    @JsonProperty("base_max_size")
    private String baseMaxSize;
    @JsonProperty("quote_increment")
    private String quoteIncrement;
    @JsonProperty("display_name")
    private String displayName;
}
