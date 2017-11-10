package com.test.cookpit.camundaWrapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Configuration
@EnableFeignClients
@EnableDiscoveryClient
public class CamundaClient {

	@Autowired
	private TheClient theClient;

	@FeignClient(name = "producer1")
	interface TheClient {

		@RequestMapping(path = "/rest/engine/default/process-definition", method = RequestMethod.GET)
		@ResponseBody
		Object getProcessDefinition();

		@RequestMapping(path = "/rest/engine/default/deployment", method = RequestMethod.GET)
		@ResponseBody
		Object getDeployments();
		
		@RequestMapping(path = "/rest/engine/default/deployment/count", method = RequestMethod.GET)
		@ResponseBody
		Object getDeploymentsCount();
		
		@RequestMapping(path = "/rest/engine/default/process-instance", method = RequestMethod.GET)
		@ResponseBody
		Object getRunningProcessInstances();
		
		@RequestMapping(path = "/rest/engine/default/process-instance/count", method = RequestMethod.GET)
		@ResponseBody
		Object getRunningProcessInstancesCount();
		
		@RequestMapping(path = "/rest/engine/default/process-instance/{id}/variables", method = RequestMethod.GET)
		@ResponseBody
		Object getVariablesInARunningProcessInstances(@PathVariable("id")  String id);
		
		@RequestMapping(path = "/rest/engine/default/task", method = RequestMethod.GET)
		@ResponseBody
		Object getTask();

	}

	public Object getProcessDefinition() {
		return theClient.getProcessDefinition();
	}
	
	public Object getDeployments() {
		return theClient.getDeployments();
	}
	
	public Object getDeploymentsCount() {
		return theClient.getDeploymentsCount();
	}
	
	public Object getRunningProcessInstances() {
		return theClient.getRunningProcessInstances();
	}
	
	public Object getRunningProcessInstancesCount() {
		return theClient.getRunningProcessInstancesCount();
	}
	
	
	public Object getVariablesInARunningProcessInstances(String variableId) {
		return theClient.getVariablesInARunningProcessInstances(variableId);
	}
	
	public Object getTask() {
		return theClient.getTask();
	}
}