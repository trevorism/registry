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

    @Test
    void testFromDeployPredict() {
        Service expected = new Service(name: "predict",
                giturl: "https://github.com/trevorism/predict.git",
                host: "https://console.cloud.google.com/appengine/versions?project=trevorism-predict&serviceId=default",
                url: "https://trevorism-predict.appspot.com",
                dns: "https://predict.trevorism.com")

        Service actual = Service.fromDeploy(new Deploy(application: "trevorism-predict", service: "trevorism-predict", version: "1"))

        assert expected.name == actual.name
        assert expected.giturl == actual.giturl
        assert expected.host == actual.host
        assert expected.url == actual.url
        assert expected.dns == actual.dns
    }

    @Test
    void testFromDeployTesting() {
        Service expected = new Service(name: "testing",
                giturl: "https://github.com/trevorism/testing.git",
                host: "https://console.cloud.google.com/appengine/versions?project=trevorism-testing&serviceId=default",
                url: "https://trevorism-testing.appspot.com",
                dns: "https://testing.trevorism.com")

        Service actual = Service.fromDeploy(new Deploy(application: "trevorism-testing", service: "trevorism-testing", version: "1"))

        assert expected.name == actual.name
        assert expected.giturl == actual.giturl
        assert expected.host == actual.host
        assert expected.url == actual.url
        assert expected.dns == actual.dns
    }
}
