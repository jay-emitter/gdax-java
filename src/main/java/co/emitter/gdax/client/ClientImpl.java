package co.emitter.gdax.client;

import co.emitter.gdax.models.*;
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
import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public Collection<Trade> getTradesForProductId(String id) {
        try {
            WebTarget target = client.target(targetURL).path("/products/" + id + "/trades" );
            Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON);

            Response response = invocationBuilder.get();
            String s = response.readEntity(String.class);
            ObjectMapper mapper = new ObjectMapper();
            return Arrays.asList(mapper.readValue(new StringReader(s), Trade[].class));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public Collection<Trade> getTradesForProduct(Product product) {
        return getTradesForProductId(product.getId());
    }

    @Override
    public Collection<HistoricRate> getHistoricRatesForProduct(Product product) {
        return getHistoricRatesForProductId(product.getId());
    }

    @Override
    public Collection<HistoricRate> getHistoricRatesForProductId(String id) {
        try {
            WebTarget target = client.target(targetURL).path("/products/" + id + "/candles" );
            Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON);

            Response response = invocationBuilder.get();
            String s = response.readEntity(String.class);
            ObjectMapper mapper = new ObjectMapper();
            List<Double[]> doubles = Arrays.asList(mapper.readValue(new StringReader(s), Double[][].class));
            return doubles.stream().map(HistoricRate::new).collect(Collectors.toList());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }


}
