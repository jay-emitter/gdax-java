package co.emitter.gdax.client;

import co.emitter.gdax.models.OrderBook;
import co.emitter.gdax.models.Product;
import co.emitter.gdax.models.Ticker;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.StringReader;
import java.util.Arrays;
import java.util.Collection;

/**
 * Created by jeremy on 7/3/16.
 */
@AllArgsConstructor
class ClientImpl implements GDAXClient {
    private Client client;
    private String targetURL;

    public Collection<Product> getProducts() {
        try {
            WebTarget target = client.target(targetURL).path("/products");
            Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON);

            Response response = invocationBuilder.get();
            String s = response.readEntity(String.class);
            ObjectMapper mapper = new ObjectMapper();
            return Arrays.asList(mapper.readValue(new StringReader(s), Product[].class));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public OrderBook getOrderBookForProductId(String id) {
        try {
            WebTarget target = client.target(targetURL).path("/products/" + id + "/book").queryParam("level", 3);
            Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON);

            Response response = invocationBuilder.get();
            String s = response.readEntity(String.class);
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(new StringReader(s), OrderBook.class);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public OrderBook getOrderBookForProduct(Product product) {
        return getOrderBookForProductId(product.getId());
    }

    @Override
    public Ticker getTickerForProduct(Product product) {
        return getTickerForProductId(product.getId());
    }

    @Override
    public Ticker getTickerForProductId(String id) {
        try {
            WebTarget target = client.target(targetURL).path("/products/" + id + "/ticker");
            Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON);

            Response response = invocationBuilder.get();
            String s = response.readEntity(String.class);
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(new StringReader(s), Ticker.class);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }


}
