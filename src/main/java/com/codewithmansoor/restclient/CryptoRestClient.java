package com.codewithmansoor.restclient;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;


@Path("/ticker")
@RegisterRestClient
  public interface CryptoRestClient {

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public String getBitconPrice();

}
