package com.test.cookpit.camundaWrapper;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CommonController {

	@Autowired
	private DeciderClass deciderClass;

	@Autowired
	private ServletContext servletContext;

	@Autowired
	HttpServletRequest request;

	@Autowired
	RestTemplate restTemplate;

	@RequestMapping("/setValue/{serviceId}")
	public String getDeployments(@PathVariable("serviceId") String id) {
		// HttpSession session = request.getSession();
		// session.setAttribute("serviceId",id);
		servletContext.setAttribute("serviceId", id);
		return "done";
	}

	@RequestMapping("/rest/engine/default/deployment")
	public Object getDeployments() {
		// HttpSession session = request.getSession();
		// String serviceId = null != session.getAttribute("serviceId")?
		// (String)session.getAttribute("serviceId"):null ;
		String serviceId = null != servletContext.getAttribute("serviceId")
				? (String) servletContext.getAttribute("serviceId") : null;
		if (null == serviceId) {
			return "please select a valid service id from the selector";
		} else {
			ResponseEntity<Object> response = restTemplate.getForEntity(
					deciderClass.getMeTheUrl(serviceId) + "/rest/engine/default/deployment", Object.class);
			return response.getBody();
		}
	}

	@RequestMapping("/rest/process-instance/count")
	public Object getProcessCount() {
		// HttpSession session = request.getSession();
		// String serviceId = null != session.getAttribute("serviceId")?
		// (String)session.getAttribute("serviceId"):null ;
		String serviceId = null != servletContext.getAttribute("serviceId")
				? (String) servletContext.getAttribute("serviceId") : null;
		if (null == serviceId) {
			return "please select a valid service id from the selector";
		} else {
			ResponseEntity<Object> response = restTemplate
					.getForEntity(deciderClass.getMeTheUrl(serviceId) + "/rest/process-instance/count", Object.class);
			return response.getBody();
		}
	}

	@RequestMapping("/rest/process-instance/{id}/variables")
	public Object getVariablesInARunningProcessInstances(@PathVariable("id") String id) {
		// HttpSession session = request.getSession();
		// String serviceId = null != session.getAttribute("serviceId")?
		// (String)session.getAttribute("serviceId"):null ;
		String serviceId = null != servletContext.getAttribute("serviceId")
				? (String) servletContext.getAttribute("serviceId") : null;
		if (null == serviceId) {
			return "please select a valid service id from the selector";
		} else {
			ResponseEntity<Object> response = restTemplate.getForEntity(
					deciderClass.getMeTheUrl(serviceId) + "/rest/process-instance/" + id + "/variables",
					Object.class);
			return response.getBody();
		}
	}

	@RequestMapping("/rest/history/process-instance")
	public Object getHistory() {
		// HttpSession session = request.getSession();
		// String serviceId = null != session.getAttribute("serviceId")?
		// (String)session.getAttribute("serviceId"):null ;
		String serviceId = null != servletContext.getAttribute("serviceId")
				? (String) servletContext.getAttribute("serviceId") : null;
		if (null == serviceId) {
			return "please select a valid service id from the selector";
		} else {
			ResponseEntity<Object> response = restTemplate
					.getForEntity(deciderClass.getMeTheUrl(serviceId) + "/rest/history/process-instance", Object.class);
			return response.getBody();
		}
	}

	@RequestMapping("/rest/process-instance")
	public Object getProcessInstance() {
		// HttpSession session = request.getSession();
		// String serviceId = null != session.getAttribute("serviceId")?
		// (String)session.getAttribute("serviceId"):null ;
		String serviceId = null != servletContext.getAttribute("serviceId")
				? (String) servletContext.getAttribute("serviceId") : null;
		if (null == serviceId) {
			return "please select a valid service id from the selector";
		} else {
			ResponseEntity<Object> response = restTemplate
					.getForEntity(deciderClass.getMeTheUrl(serviceId) + "/rest/process-instance", Object.class);
			return response.getBody();
		}
	}

	@RequestMapping("/rest/process-definition")
	public Object getProcessDefinition() {
		// HttpSession session = request.getSession();
		// String serviceId = null != session.getAttribute("serviceId")?
		// (String)session.getAttribute("serviceId"):null ;
		String serviceId = null != servletContext.getAttribute("serviceId")
				? (String) servletContext.getAttribute("serviceId") : null;
		if (null == serviceId) {
			return "please select a valid service id from the selector";
		} else {
			ResponseEntity<Object> response = restTemplate
					.getForEntity(deciderClass.getMeTheUrl(serviceId) + "/rest/process-definition", Object.class);
			return response.getBody();
		}
	}
}
