/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pippo.jaxrsservice;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.POST;

/**
 * REST Web Service
 *
 * @author pippo
 */
@Path("RSTest")
public class HelloWorld {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public HelloWorld() {
    }

    /**
     * Retrieves representation of an instance of com.pippo.jaxrsservice.GenericResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/xml")
    public String getXml() {
        //TODO return proper representation object
        //throw new UnsupportedOperationException();
        return "<html><body><h1>Hello by Pippo!!</body></h1></html>";
    }

    /**
     * PUT method for updating or creating an instance of GenericResource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/xml")
    public void putXml(String content) {
    }
    
    @GET
    @Produces("text/html")
    @Path("htmltest")
    public String getHtml() {
        return "<html><body><h1>Hello by Pippo!!</body></h1></html>";
    }
    
    @GET
    @Produces("application/json")
    @Path("json/{value}")
    public String getJSON( @PathParam("value") int value ) {
        return "{a:1, b:2, b:3, name:" + value / 2 + "}";
    }
}
