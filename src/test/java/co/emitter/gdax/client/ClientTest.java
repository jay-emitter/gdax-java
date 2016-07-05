package co.emitter.gdax.client;

import co.emitter.gdax.models.*;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Collection;

import static org.junit.Assert.assertNotNull;

/**
 * Created by jeremy on 7/3/16.
 */
public class ClientTest {
    //private String url = "https://api-public.sandbox.gdax.com";
    private String url = "https://api.gdax.com";
    private GDAXClient client;

    @Before
    public void setup() {
     client = new ClientFactory().withBaseURL(url).build();
    }

    @Test
    public void testGetProducts() throws IOException {
        Collection<Product> products = client.getProducts();
        assertNotNull(products);
    }

    @Test
    public void testGetOrderBook() throws IOException {
        OrderBook orderBook = client.getOrderBookForProductId("BTC-USD");
        assertNotNull(orderBook);
        assertNotNull(orderBook.getAskOrders());
        assertNotNull(orderBook.getBidOrders());
    }

    @Test
    public void testGetTicker() throws IOException {
        Ticker ticker =client.getTickerForProductId("BTC-USD");
        assertNotNull(ticker);
    }

    @Test
    public void testGetHistoricRates() throws IOException {
        Collection<HistoricRate> rates = client.getHistoricRatesForProductId("BTC-USD");
        assertNotNull(rates);
    }

    @Test
    public void testGetStats() throws IOException {
        Stats stats = client.getStatsForProductId("BTC-USD");
        assertNotNull(stats);
    }
}
