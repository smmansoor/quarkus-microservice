package com.codewithmansoor.service;

import com.codewithmansoor.restclient.AnyApiClient;
import com.codewithmansoor.restclient.CryptoRestClient;
import org.eclipse.microprofile.metrics.MetricUnits;
import org.eclipse.microprofile.metrics.annotation.Timed;
import org.eclipse.microprofile.opentracing.Traced;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("api")
@ApplicationScoped
public class AnyApiService {

    @Inject
    @RestClient
    AnyApiClient anyApiClient;

    @Traced(operationName = "To Do")
    @GET
    @Path("todo")
    @Timed(name = "StockTimed", description = "A measure of how long it takes to perform the operation", unit = MetricUnits.MILLISECONDS)
    @Produces(MediaType.APPLICATION_JSON)
    // @Timeout (value = 2 , unit = ChronoUnit.SECONDS)
    // @Retry(delay = 1000, maxRetries = 2)
    // @Fallback(StockFallBack.class)
    public String todo() {
        return anyApiClient.getToDo();
    }

}
