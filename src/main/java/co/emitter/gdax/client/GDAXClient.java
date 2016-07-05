package co.emitter.gdax.client;

import co.emitter.gdax.models.*;

import java.io.IOException;
import java.util.Collection;

/**
 * Created by jeremy on 7/3/16.
 */
public interface GDAXClient {
    Collection<Product> getProducts() throws IOException;

    OrderBook getOrderBookForProductId(String id) throws IOException;
    OrderBook getOrderBookForProduct(Product product) throws IOException;

    Ticker getTickerForProduct(Product product) throws IOException;
    Ticker getTickerForProductId(String id) throws IOException;

    Collection<Trade> getTradesForProductId(String id) throws IOException;
    Collection<Trade> getTradesForProduct(Product product) throws IOException;

    Collection<HistoricRate> getHistoricRatesForProduct(Product product) throws IOException;
    Collection<HistoricRate> getHistoricRatesForProductId(String id) throws IOException;

    Stats getStatsForProduct(Product product) throws IOException;
    Stats getStatsForProductId(String id) throws IOException;
}
