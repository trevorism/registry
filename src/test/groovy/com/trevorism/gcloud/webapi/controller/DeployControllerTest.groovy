package com.trevorism.gcloud.webapi.controller

import com.trevorism.gcloud.webapi.controller.com.trevorism.gcloud.model.Deploy
import org.junit.Test

import javax.ws.rs.core.HttpHeaders

/**
 * @author tbrooks
 */
class DeployControllerTest extends GroovyTestCase {

    @Test
    void testStoreDeploy() {
        DeployController dc = new DeployController()
        assert !dc.storeDeploy([getHeaderString:{name -> "12345"}] as HttpHeaders, new Deploy())

    }
}
