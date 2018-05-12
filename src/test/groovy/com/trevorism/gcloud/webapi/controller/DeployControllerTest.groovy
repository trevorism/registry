package com.trevorism.gcloud.webapi.controller

import org.junit.Test

/**
 * @author tbrooks
 */
class DeployControllerTest extends GroovyTestCase {

    @Test
    void testStoreDeploy() {
        DeployController dc = new DeployController()
        assert dc.storeDeploy([:])

    }
}
