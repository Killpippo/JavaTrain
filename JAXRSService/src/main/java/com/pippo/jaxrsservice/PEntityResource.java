/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pippo.jaxrsservice;

import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;

/**
 * REST Web Service
 *
 * @author pippo
 */
public class PEntityResource {

    private String name;

    /**
     * Creates a new instance of PEntityResource
     */
    private PEntityResource(String name) {
        this.name = name;
    }

    /**
     * Get instance of the PEntityResource
     */
    public static PEntityResource getInstance(String name) {
        // The user may use some kind of persistence mechanism
        // to store and restore instances of PEntityResource class.
        return new PEntityResource(name);
    }

    /**
     * Retrieves representation of an instance of com.pippo.jaxrsservice.PEntityResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of PEntityResource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }

    /**
     * DELETE method for resource PEntityResource
     */
    @DELETE
    public void delete() {
    }
}
