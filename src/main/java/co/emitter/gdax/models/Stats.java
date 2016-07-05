package co.emitter.gdax.models;

import lombok.Data;

/**
 * Created by jeremy on 7/4/16.
 */
@Data
public class Stats {
    private String open;
    private String high;
    private String low;
    private String volume;
    private String volume_30day;
}
