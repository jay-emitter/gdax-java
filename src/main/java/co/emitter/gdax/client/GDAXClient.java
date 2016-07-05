package co.emitter.gdax.client;

import co.emitter.gdax.models.*;

import java.util.Collection;

/**
 * Created by jeremy on 7/3/16.
 */
public interface GDAXClient {
    Collection<Product> getProducts();

    OrderBook getOrderBookForProductId(String id);
    OrderBook getOrderBookForProduct(Product product);

    Ticker getTickerForProduct(Product product);
    Ticker getTickerForProductId(String id);

    Collection<Trade> getTradesForProductId(String id);
    Collection<Trade> getTradesForProduct(Product product);

    Collection<HistoricRate> getHistoricRatesForProduct(Product product);

    Collection<HistoricRate> getHistoricRatesForProductId(String id);
}
