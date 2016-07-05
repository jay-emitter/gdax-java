package co.emitter.gdax.models;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by jeremy on 7/4/16.
 */
@Data
public class OrderBook {
    private String sequence;
    @Getter(AccessLevel.PACKAGE)
    private String[][] bids;
    @Getter(AccessLevel.PACKAGE)
    private String[][] asks;


    public List<Order> getAskOrders() {
        return Arrays.asList(asks).stream().map(Order::new).collect(Collectors.toList());
    }

    public List<Order> getBidOrders() {
        return Arrays.asList(bids).stream().map(Order::new).collect(Collectors.toList());
    }
}
