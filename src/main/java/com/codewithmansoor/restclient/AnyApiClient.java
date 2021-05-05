package com.codewithmansoor.restclient;

import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/todos/1")
@RegisterRestClient
public interface AnyApiClient {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getToDo();

}