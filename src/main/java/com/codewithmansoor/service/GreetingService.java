package com.codewithmansoor.service;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.metrics.MetricUnits;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Timed;
import org.eclipse.microprofile.opentracing.Traced;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/api")
@ApplicationScoped
public class GreetingService {


  @Inject
  @ConfigProperty(name = "greet.name")
  private String name;

  @Traced(operationName = "greet")
  @GET
  @Path("/greet")
  @Produces(MediaType.TEXT_PLAIN)

  @Counted(name = "performedChecks", monotonic = true, description = "How many primality checks have been performed.")
  public String hello() {
    return "hello "+name;
  }

}