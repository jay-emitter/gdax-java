package co.emitter.gdax.client;


import org.glassfish.jersey.client.ClientConfig;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

/**
 * Created by jeremy on 7/3/16.
 */
public class ClientFactory {
    private String url;

    public ClientFactory withBaseURL(String url){
        this.url = url;
        return this;
    }

    GDAXClient build() {
        ClientConfig clientConfig = new ClientConfig();

        Client client = ClientBuilder.newClient(clientConfig);

        return new ClientImpl(client, url);
    }
}
