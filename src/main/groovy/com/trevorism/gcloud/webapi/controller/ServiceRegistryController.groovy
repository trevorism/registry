package com.trevorism.gcloud.webapi.controller

import com.trevorism.data.DatastoreRepository
import com.trevorism.data.Repository
import com.trevorism.domain.Service

import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

/**
 * @author tbrooks
 */
@Path("/service")
class ServiceRegistryController {

    Repository<Service> repository = new DatastoreRepository<>(Service)

    @GET
    @Path("web")
    @Produces(MediaType.APPLICATION_JSON)
    List<Service> listWebServices(){
        repository.list().findAll(){
            it.host.startsWith("https://console.cloud.google.com")
        }
    }

    @GET
    @Path("lib")
    @Produces(MediaType.APPLICATION_JSON)
    List<Service> listInternal(){
        repository.list().findAll(){
            it.host.startsWith("internal")
        }
    }
}
