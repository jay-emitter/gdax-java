package co.emitter.gdax.models;

import lombok.Getter;

import java.math.BigDecimal;

/**
 * Created by jeremy on 7/4/16.
 */
@Getter
public class Order {
    private String orderId;
    private BigDecimal size;
    private BigDecimal price;


    Order(String[] data) {
        price = BigDecimal.valueOf(Double.valueOf(data[0]));
        size = BigDecimal.valueOf(Double.valueOf(data[1]));
        orderId = data[2];
    }
}
