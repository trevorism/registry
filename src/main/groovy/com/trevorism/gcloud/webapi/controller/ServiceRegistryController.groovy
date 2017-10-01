package com.trevorism.gcloud.webapi.controller

import com.trevorism.data.PingingDatastoreRepository
import com.trevorism.data.Repository
import com.trevorism.gcloud.webapi.controller.com.trevorism.gcloud.model.Service

import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

/**
 * @author tbrooks
 */
@Path("/service")
class ServiceRegistryController {

    private final Repository<Service> repository = new PingingDatastoreRepository<>(Service)

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
