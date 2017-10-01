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
    String getEndpoints(){
        """
<a href="/api/ping">Ping</a> </br>
<a href="/api/service/web">All webapps</a> </br>
<a href="/api/service/lib">All libraries</a> </br>
        """
    }


}
