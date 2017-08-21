package com.trevorism.gcloud.webapi.controller

import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("/")
class RootController {

    @GET
    @Path("ping")
    @Produces(MediaType.APPLICATION_JSON)
    String ping(){
        "pong"
    }

    @GET
    @Path("")
    String getEndpoints(){
        '<a href="/api/ping">/ping</a> </br> <a href="/api/help">/help</a>'
    }

    @GET
    @Path("help")
    String help(){
        return """
<h3>API documentation for registry </h3><br/><br/>
HTTP GET <a href="/api/ping">/ping</a> -- Returns "pong" if the application is working
"""
    }
}
