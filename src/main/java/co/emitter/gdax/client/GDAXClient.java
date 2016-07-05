package co.emitter.gdax.client;

import co.emitter.gdax.models.OrderBook;
import co.emitter.gdax.models.Product;
import co.emitter.gdax.models.Ticker;

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
}
