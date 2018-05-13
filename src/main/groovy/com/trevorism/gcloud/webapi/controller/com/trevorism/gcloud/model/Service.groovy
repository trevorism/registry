package com.trevorism.gcloud.webapi.controller.com.trevorism.gcloud.model

/**
 * @author tbrooks
 */
class Service {
    long id
    String name
    String giturl
    String host

    String url
    String dns

    static Service fromDeploy(Deploy deploy) {
        Service service = new Service()
        if(!deploy.application || !deploy.service)
            return service

        service.name = deploy.service
        service.giturl = "https://github.com/trevorism/${deploy.service}.git"

        boolean defaultService = deploy.application.endsWith(deploy.service)
        service.host = "https://console.cloud.google.com/appengine/versions?project=${deploy.application}&serviceId=${computeServiceId(deploy.service, defaultService)}"
        service.url = computeUrl(deploy, defaultService)
        service.dns = computeDns(deploy, defaultService)
        return service

    }

    private static String computeDns(Deploy deploy, boolean defaultService) {
        if (defaultService) {
            return "https://${getSimpleName(deploy.application)}.trevorism.com"
        }
        return "http://${deploy.service}.${getSimpleName(deploy.application)}.trevorism.com"

    }

    private static String computeUrl(Deploy deploy, boolean defaultService) {
        if (defaultService) {
            return "https://${deploy.application}.appspot.com"
        }
        return "https://${deploy.service}-dot-${deploy.application}.appspot.com"
    }

    private static String computeServiceId(String service, boolean defaultService) {
        if(defaultService)
            return "default"
        return service
    }

    private static String getSimpleName(String application) {
        if(application == "trevorism-eventhub"){
            return "event"
        }
        if(application == "trevorism-pushbutton"){
            return "click"
        }
        return "datastore"
    }
}
