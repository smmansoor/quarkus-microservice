package com.codewithmansoor.service;


import com.codewithmansoor.fallback.StockFallBack;
import com.codewithmansoor.restclient.CryptoRestClient;
import java.time.temporal.ChronoUnit;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.faulttolerance.Timeout;
import org.eclipse.microprofile.metrics.MetricUnits;
import org.eclipse.microprofile.metrics.annotation.Timed;
import org.eclipse.microprofile.opentracing.Traced;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/api")
@ApplicationScoped
public class StockService {

  @Inject
  @RestClient
  CryptoRestClient cryptoRestClient;

  @Traced(operationName = "Stock Price")
  @GET
  @Path("/stock")
  @Timed(name = "StockTimed", description = "A measure of how long it takes to perform the operation", unit = MetricUnits.MILLISECONDS)
  @Produces(MediaType.APPLICATION_JSON)
  @Timeout (value = 2 , unit = ChronoUnit.SECONDS)
  @Retry(delay = 1000, maxRetries = 2)
  @Fallback(StockFallBack.class)
  public String stock() {
    return cryptoRestClient.getBitconPrice();
  }


}
