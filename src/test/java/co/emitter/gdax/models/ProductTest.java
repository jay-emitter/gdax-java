package co.emitter.gdax.models;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.io.StringReader;

import static org.junit.Assert.assertNotNull;

/**
 * Created by jeremy on 7/3/16.
 */
public class ProductTest {
    private Product product;
    private String json = "{\n" +
            "        \"id\": \"BTC-USD\",\n" +
            "        \"base_currency\": \"BTC\",\n" +
            "        \"quote_currency\": \"USD\",\n" +
            "        \"base_min_size\": \"0.01\",\n" +
            "        \"base_max_size\": \"10000.00\",\n" +
            "        \"quote_increment\": \"0.01\"\n" +
            "    }";

    private String jsonArray = "[{\"id\":\"BTC-USD\",\"base_currency\":\"BTC\",\"quote_currency\":\"USD\",\"base_min_size\":\"0.01\",\"base_max_size\":\"10000\",\"quote_increment\":\"0.01\",\"display_name\":\"BTC/USD\"},{\"id\":\"ETH-USD\",\"base_currency\":\"ETH\",\"quote_currency\":\"USD\",\"base_min_size\":\"0.01\",\"base_max_size\":\"100000\",\"quote_increment\":\"0.01\",\"display_name\":\"ETH/USD\"},{\"id\":\"BTC-GBP\",\"base_currency\":\"BTC\",\"quote_currency\":\"GBP\",\"base_min_size\":\"0.01\",\"base_max_size\":\"10000\",\"quote_increment\":\"0.01\",\"display_name\":\"BTC/GBP\"},{\"id\":\"BTC-EUR\",\"base_currency\":\"BTC\",\"quote_currency\":\"EUR\",\"base_min_size\":\"0.01\",\"base_max_size\":\"10000\",\"quote_increment\":\"0.01\",\"display_name\":\"BTC/EUR\"},{\"id\":\"BTC-CAD\",\"base_currency\":\"BTC\",\"quote_currency\":\"CAD\",\"base_min_size\":\"0.01\",\"base_max_size\":\"10000\",\"quote_increment\":\"0.01\",\"display_name\":\"BTC/CAD\"},{\"id\":\"ETH-BTC\",\"base_currency\":\"ETH\",\"quote_currency\":\"BTC\",\"base_min_size\":\"0.01\",\"base_max_size\":\"100000\",\"quote_increment\":\"0.00001\",\"display_name\":\"ETH/BTC\"}]";
    @Before
    public void setup() {
        product = new Product();
        product.setBaseCurrency("BTC");
        product.setId("BTC-USD");
        product.setQuoteCurrency("USD");
    }

    @Test
    public void unmarshallTest() throws JAXBException, IOException {
        ObjectMapper mapper = new ObjectMapper();

        Product product = mapper.readValue(new StringReader(json), Product.class);
        assertNotNull(product);
    }

    @Test
    public void unmarshallArrayTest() throws JAXBException, IOException {
        ObjectMapper mapper = new ObjectMapper();

        Product[] product = mapper.readValue(new StringReader(jsonArray), Product[].class);
        assertNotNull(product);
    }

}
