package co.emitter.gdax.client;

import co.emitter.gdax.models.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
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

    public Collection<Product> getProducts() throws IOException {
        WebTarget target = client.target(targetURL).path("/products");
        Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON);

        Response response = invocationBuilder.get();
        String s = response.readEntity(String.class);
        ObjectMapper mapper = new ObjectMapper();
        return Arrays.asList(mapper.readValue(new StringReader(s), Product[].class));
    }

    public OrderBook getOrderBookForProductId(String id) throws IOException {
        WebTarget target = client.target(targetURL).path("/products/" + id + "/book").queryParam("level", 3);
        Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON);

        Response response = invocationBuilder.get();
        String s = response.readEntity(String.class);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new StringReader(s), OrderBook.class);
    }

    public OrderBook getOrderBookForProduct(Product product) throws IOException {
        return getOrderBookForProductId(product.getId());
    }

    @Override
    public Ticker getTickerForProduct(Product product) throws IOException {
        return getTickerForProductId(product.getId());
    }

    @Override
    public Ticker getTickerForProductId(String id) throws IOException {

            WebTarget target = client.target(targetURL).path("/products/" + id + "/ticker");
            Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON);

            Response response = invocationBuilder.get();
            String s = response.readEntity(String.class);
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(new StringReader(s), Ticker.class);

    }

    @Override
    public Collection<Trade> getTradesForProductId(String id) throws IOException {
        WebTarget target = client.target(targetURL).path("/products/" + id + "/trades" );
        Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON);

        Response response = invocationBuilder.get();
        String s = response.readEntity(String.class);
        ObjectMapper mapper = new ObjectMapper();
        return Arrays.asList(mapper.readValue(new StringReader(s), Trade[].class));
    }

    @Override
    public Collection<Trade> getTradesForProduct(Product product) throws IOException {
        return getTradesForProductId(product.getId());
    }

    @Override
    public Collection<HistoricRate> getHistoricRatesForProduct(Product product) throws IOException {
        return getHistoricRatesForProductId(product.getId());
    }

    @Override
    public Collection<HistoricRate> getHistoricRatesForProductId(String id) throws IOException {

        WebTarget target = client.target(targetURL).path("/products/" + id + "/candles" );
        Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON);

        Response response = invocationBuilder.get();
        String s = response.readEntity(String.class);
        ObjectMapper mapper = new ObjectMapper();
        List<Double[]> doubles = Arrays.asList(mapper.readValue(new StringReader(s), Double[][].class));
        return doubles.stream().map(HistoricRate::new).collect(Collectors.toList());

    }

    @Override
    public Stats getStatsForProduct(Product product) throws IOException {
        return getStatsForProductId(product.getId());
    }

    @Override
    public Stats getStatsForProductId(String id) throws IOException {

        WebTarget target = client.target(targetURL).path("/products/" + id + "/stats" );
        Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON);

        Response response = invocationBuilder.get();
        String s = response.readEntity(String.class);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new StringReader(s), Stats.class);

    }


}
