package org.acme.restclient;

import org.eclipse.microprofile.rest.client.RestClientBuilder;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.net.URI;
import java.util.Set;

@Path("/country")
public class CountriesResource {

    @GET
    @Path("/name/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Set<Country> name(@PathParam("name") String name) {
        return RestClientBuilder.newBuilder()
                .baseUri(URI.create("https://restcountries.eu/rest"))
                .build(CountriesService.class)
                .getByName(name);
    }
}