package com.academy.patterns.servicelocator;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by keos on 22.06.15.
 */
public class ServiceCache {
    private final Map<String, Service> serviceCache = new HashMap<>();

    public Service getService(String serviceName) {
        return serviceCache.get(serviceName);
    }

    public void addService(Service service, String serviceName) {
        serviceCache.put(serviceName, service);
    }

}
