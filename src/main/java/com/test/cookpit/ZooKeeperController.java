package com.test.cookpit;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ZooKeeperController {

	@Autowired
	private DiscoveryClient discoveryClient;

	@RequestMapping("/services")
	public Object serviceUrl() {
		return discoveryClient.getServices();
	}
	
	@RequestMapping("/services/{instance}")
	public String serviceInstance(@PathVariable("instance") String instance) {
		
	    List<ServiceInstance> list = discoveryClient.getInstances(instance);
	    if (list != null && list.size() > 0 ) {
	        return list.get(0).getUri().toString();
	    }
	    return "Nothing in list";
	}
}
