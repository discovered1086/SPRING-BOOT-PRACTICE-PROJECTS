package com.kingshuk.springboot.springbootmvc.common;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component("hitCounter")
@Scope(value = WebApplicationContext.SCOPE_APPLICATION,
        proxyMode = ScopedProxyMode.TARGET_CLASS)
/**
 * The proxyMode attribute is necessary because at the moment of the
 * instantiation of the web application context, there is no active request.
 * Spring will create a proxy to be injected as a dependency, and
 * instantiate the target bean when it is needed in a request.
 *
 * This is required for request and session scoped beans as the
 * request or session is not available during the time of the bean creation
 */
public class HitCounter {

    private int hits;

    public HitCounter() {
        System.out.println("HitCounter constructor has been invoked");
    }

    public int getHits() {
        return hits;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }
}
