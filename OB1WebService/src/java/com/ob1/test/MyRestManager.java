package com.ob1.test;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;

@Path("/")
public class MyRestManager {
    
    @GET
    public Response Root() {
        return Response.ok( "MyRest ROOT 3").build();
    }
    
    
    @Path("square/{num}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response Square( @PathParam("num") int _num, @Context Request _req ) {
        return Response.ok( Integer.toString( _num * _num ) ).build();
    }
}
