package com.trevorism.gcloud.webapi.controller

import org.junit.Test

/**
 * @author tbrooks
 */
class ServiceRegistryControllerTest {

    ServiceRegistryController controller = new ServiceRegistryController()

    @Test
    void testListWebServices() {
        assert controller.listWebServices().size() > 2
    }

    @Test
    void testListInternal() {
        assert controller.listInternal().size() > 5
    }
}
