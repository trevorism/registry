package com.trevorism.gcloud.webapi.controller

import com.trevorism.data.PingingDatastoreRepository
import com.trevorism.data.Repository
import com.trevorism.gcloud.webapi.controller.com.trevorism.gcloud.model.Service
import io.swagger.annotations.Api

import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import java.util.logging.Logger

/**
 * @author tbrooks
 */
@Api("Deploy Operations")
@Path("/deploy")
class DeployController {

    private static final Logger log = Logger.getLogger(DeployController.class.name)
    //private final Repository<Service> repository = new PingingDatastoreRepository<>(Service)

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    boolean storeDeploy(Map data){
        log.info("Data:: ${data}")
        return true
    }
}
