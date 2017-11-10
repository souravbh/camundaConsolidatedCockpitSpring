package com.test.cookpit.camundaWrapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/process1")
public class CamundaController1 {

	@Autowired
	private CamundaClient camundaClient;

	@RequestMapping("/rest/engine/default/process-definition/{serviceId}")
	public Object getProcessDefinition() {
		return camundaClient.getProcessDefinition();
	}

	@RequestMapping("/rest/engine/default/deployment")
	public Object getDeployments() {
		return camundaClient.getProcessDefinition();
	}

	@RequestMapping(path = "/rest/engine/default/deployment/count", method = RequestMethod.GET)
	public Object getDeploymentsCount() {
		return camundaClient.getDeploymentsCount();
	}
	
	@RequestMapping(path = "/rest/engine/default/process-instance", method = RequestMethod.GET)
	public Object getRunningProcessInstances() {
		return camundaClient.getRunningProcessInstances();
	}


	@RequestMapping(path = "/rest/engine/default/process-instance/count", method = RequestMethod.GET)
	public Object getRunningProcessInstancesCount() {
		return camundaClient.getRunningProcessInstancesCount();
	}

	@RequestMapping(path = "/rest/engine/default/process-instance/{id}/variables", method = RequestMethod.GET)
	public Object getVariablesInARunningProcessInstances(@PathVariable("id") String id) {
		return camundaClient.getVariablesInARunningProcessInstances(id);
	}

	@RequestMapping(path = "/rest/engine/default/task", method = RequestMethod.GET)
	public Object getTask() {
		return camundaClient.getTask();
	}
}
