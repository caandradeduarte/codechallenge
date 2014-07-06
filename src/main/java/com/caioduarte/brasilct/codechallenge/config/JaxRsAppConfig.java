package com.caioduarte.brasilct.codechallenge.config;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;

/**
 * Registers the components to be used by the JAX-RS application
 * 
 * @author Caio Duarte
 *
 */
public class JaxRsAppConfig extends ResourceConfig {
	
	public JaxRsAppConfig() {
		
		// Filters
		register(RequestContextFilter.class);
 
        // Features
        register(JacksonFeature.class);
        register(MultiPartFeature.class);
	}

}
