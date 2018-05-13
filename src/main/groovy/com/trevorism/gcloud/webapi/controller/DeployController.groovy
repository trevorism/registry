package com.trevorism.gcloud.webapi.controller

import com.trevorism.data.PingingDatastoreRepository
import com.trevorism.data.Repository
import com.trevorism.gcloud.webapi.controller.com.trevorism.gcloud.model.Deploy
import com.trevorism.gcloud.webapi.controller.com.trevorism.gcloud.model.Service
import com.trevorism.http.headers.HeadersHttpClient
import io.swagger.annotations.Api

import javax.ws.rs.Consumes
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.Context
import javax.ws.rs.core.HttpHeaders
import javax.ws.rs.core.MediaType
import java.util.logging.Logger

/**
 * @author tbrooks
 */
@Api("Deploy Operations")
@Path("/deploy")
class DeployController {

    private static final Logger log = Logger.getLogger(DeployController.class.name)
    private final Repository<Service> repository = new PingingDatastoreRepository<>(Service)

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    boolean storeDeploy(@Context HttpHeaders headers, Deploy deployData){
        Service service = Service.fromDeploy(deployData)
        List<Service> allServices = repository.list()

        def found = allServices.find{ service.name == it.name }
        if(found || !service.name)
            return false

        return repository.create(service, headers.getHeaderString(HeadersHttpClient.CORRELATION_ID_HEADER_KEY))
    }
}
