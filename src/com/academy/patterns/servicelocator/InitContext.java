package com.academy.patterns.servicelocator;

/**
 * Created by keos on 22.06.15.
 */
public class InitContext {

    public Object lookup(String serviceName) {
        if(serviceName.equals("jndi/securityService")) {
            return new ServiceImpl("jndi/securityService");
        } else if(serviceName.equals("jndi/controlService")) {
            return new ServiceImpl("jndi/controlService");
        } else {
            return null;
        }
    }
}
