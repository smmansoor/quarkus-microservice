package com.codewithmansoor.heath;

import javax.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.health.Health;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.HealthCheckResponseBuilder;

@Health
@ApplicationScoped
public class ServiceDiskHealthCheck implements HealthCheck {

  @Override
  public HealthCheckResponse call() {
    HealthCheckResponseBuilder responseBuilder = HealthCheckResponse.named(ServiceDiskHealthCheck.class.getSimpleName());

    responseBuilder.withData("memory", Runtime.getRuntime().freeMemory());
    responseBuilder.withData("availableProcessors", Runtime.getRuntime().availableProcessors());

    return responseBuilder.state(true).build();

  }
}