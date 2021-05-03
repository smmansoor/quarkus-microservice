package com.codewithmansoor.service;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.opentracing.Traced;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


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
  public String hello() {
    return "hello "+name;
  }

}