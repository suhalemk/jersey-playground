
package com.mk.jersey.cdi;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

// The Java class will be hosted at the URI path "/myresource"
@Path("/myresource")
public class MyResource {

    // TODO: update the class to suit your needs

    @Inject
    MyService service;
    // The Java method will process HTTP GET requests
    @GET 
    // The Java method will produce content identified by the MIME Media
    // type "text/plain"
    @Produces("text/plain")
    public String getIt() {
        return service.serviceCall();
        //return "Got it!";
    }


    @GET
    // The Java method will produce content identified by the MIME Media
    // type "text/plain"
    @Produces("text/plain")
    @Path("another")
    public String getAnother() {
        return "Another Got it!";
    }
}
