package com.test.cookpit.camundaWrapper;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Component;

@Component
public class DeciderClass {

	@Autowired
    private LoadBalancerClient loadBalancerClient;
	
	public URI getMeTheUrl(String serviceId){
		return loadBalancerClient.choose(serviceId).getUri();
	}
}
