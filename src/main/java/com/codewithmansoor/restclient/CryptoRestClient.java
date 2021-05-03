package com.codewithmansoor.restclient;



import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/ticker")
@RegisterRestClient
  public interface CryptoRestClient {

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public String getBitconPrice();

}
