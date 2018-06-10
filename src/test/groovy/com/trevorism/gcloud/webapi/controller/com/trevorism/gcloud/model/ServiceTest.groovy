package com.trevorism.gcloud.webapi.controller.com.trevorism.gcloud.model

import org.junit.Test

/**
 * @author tbrooks
 */
class ServiceTest {
    @Test
    void testFromDeploy() {
        Service expected = new Service(
                name: "azure-vm",
                giturl: "https://github.com/trevorism/azure-vm.git",
                host: "https://console.cloud.google.com/appengine/versions?project=trevorism-gcloud&serviceId=azure-vm",
                url: "https://azure-vm-dot-trevorism-gcloud.appspot.com",
                dns: "http://azure-vm.datastore.trevorism.com")

        Service actual = Service.fromDeploy(new Deploy(application: "trevorism-gcloud", service: "azure-vm", version: "1"))

        assert expected.name == actual.name
        assert expected.giturl == actual.giturl
        assert expected.host == actual.host
        assert expected.url == actual.url
        assert expected.dns == actual.dns


    }

    @Test
    void testFromDeployWithDefaultServiceName() {
        Service expected = new Service(name: "eventhub",
                giturl: "https://github.com/trevorism/eventhub.git",
                host: "https://console.cloud.google.com/appengine/versions?project=trevorism-eventhub&serviceId=default",
                url: "https://trevorism-eventhub.appspot.com",
                dns: "https://event.trevorism.com")

        Service actual = Service.fromDeploy(new Deploy(application: "trevorism-eventhub", service: "eventhub", version: "1"))

        assert expected.name == actual.name
        assert expected.giturl == actual.giturl
        assert expected.host == actual.host
        assert expected.url == actual.url
        assert expected.dns == actual.dns


    }

    @Test
    void testFromDeployPushButton() {
        Service expected = new Service(name: "push-button",
                giturl: "https://github.com/trevorism/push-button.git",
                host: "https://console.cloud.google.com/appengine/versions?project=trevorism-pushbutton&serviceId=default",
                url: "https://trevorism-pushbutton.appspot.com",
                dns: "https://click.trevorism.com")

        Service actual = Service.fromDeploy(new Deploy(application: "trevorism-pushbutton", service: "trevorism-pushbutton", version: "1"))

        assert expected.name == actual.name
        assert expected.giturl == actual.giturl
        assert expected.host == actual.host
        assert expected.url == actual.url
        assert expected.dns == actual.dns


    }
}