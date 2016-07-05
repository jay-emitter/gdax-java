package co.emitter.gdax.client;

import co.emitter.gdax.models.HistoricRate;
import co.emitter.gdax.models.OrderBook;
import co.emitter.gdax.models.Product;
import co.emitter.gdax.models.Ticker;
import org.junit.Test;

import java.util.Collection;

import static org.junit.Assert.assertNotNull;

/**
 * Created by jeremy on 7/3/16.
 */
public class ClientTest {
    //private String url = "https://api-public.sandbox.gdax.com";
private String url = "https://api.gdax.com";

    @Test
    public void testGetProducts() {
        Collection<Product> products = new ClientFactory().withBaseURL(url).build().getProducts();
        assertNotNull(products);
    }

    @Test
    public void testGetOrderBook() {
        OrderBook orderBook = new ClientFactory().withBaseURL(url).build().getOrderBookForProductId("BTC-USD");
        assertNotNull(orderBook);
        assertNotNull(orderBook.getAskOrders());
        assertNotNull(orderBook.getBidOrders());
    }

    @Test
    public void testGetTicker() {
        Ticker ticker = new ClientFactory().withBaseURL(url).build().getTickerForProductId("BTC-USD");
        assertNotNull(ticker);
    }

    @Test
    public void testGetHistoricRates() {
        Collection<HistoricRate> rates = new ClientFactory().withBaseURL(url).build().getHistoricRatesForProductId("BTC-USD");
        assertNotNull(rates);
    }
}
