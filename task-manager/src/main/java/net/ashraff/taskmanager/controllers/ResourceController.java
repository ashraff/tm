package net.ashraff.taskmanager.controllers;

import javax.servlet.http.HttpServletRequest;

import net.ashraff.taskmanager.entities.Resource;
import net.ashraff.taskmanager.json.CustomGenericResponse;
import net.ashraff.taskmanager.service.ResourceService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.markserrano.jsonquery.jpa.mapper.JsonObjectMapper;
import com.github.markserrano.jsonquery.jpa.response.JqgridResponse;

/**
 * Handles requests for the application Resource page.
 */
@Controller
public class ResourceController {

	private static final Logger logger = LoggerFactory
			.getLogger(ResourceController.class);

	@Autowired
	private ResourceService resService;

	@RequestMapping("/resource")
	public String resource() {
		return "resource";
	}

	@RequestMapping(value = "/resource/getList", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody
	JqgridResponse<Resource> getResources(
			@RequestParam("_search") Boolean search,
			@RequestParam(value = "filters", required = false) String filters,
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "rows", required = false) Integer rows,
			@RequestParam(value = "sidx", required = false) String sidx,
			@RequestParam(value = "sord", required = false) String sord) {

		Page<Resource> results = resService.getList(rows, page, sord, filters);

		// Map response
		JqgridResponse<Resource> response = new JqgridResponse<Resource>();
		response.setRows(results.getContent());
		response.setRecords(Long.valueOf(results.getTotalElements()).toString());
		response.setTotal(Integer.valueOf(results.getTotalPages()).toString());
		response.setPage(Integer.valueOf(results.getNumber() + 1).toString());

		return response;
	}

	/**
	 * Add a new user
	 */
	@RequestMapping(value = "/resource/add", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody
	CustomGenericResponse add(HttpServletRequest request,
			@RequestBody String str) {

		logger.debug("Received request to add a new user");

		JsonObjectMapper<Resource> mapper = new JsonObjectMapper<Resource>();
		Resource res = mapper.mapToType(str, Resource.class);

		// Call service to add
		Boolean success = resService.add(res);

		// Check if successful
		if (success == true) {
			// Success. Return a custom response
			CustomGenericResponse response = new CustomGenericResponse();
			response.setSuccess(true);
			response.setMessage("Action successful!");
			return response;

		} else {
			// A failure. Return a custom response as well
			CustomGenericResponse response = new CustomGenericResponse();
			response.setSuccess(false);
			response.setMessage("Action failure!");
			return response;
		}

	}

	/**
	 * Edit a existing user
	 */
	@RequestMapping(value = "/resource/edit", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody
	CustomGenericResponse edit(HttpServletRequest request,
			@RequestBody String str) {

		logger.debug("Received request to edit a existing user");

		JsonObjectMapper<Resource> mapper = new JsonObjectMapper<Resource>();
		Resource res = mapper.mapToType(str, Resource.class);

		// Call service to add
		Boolean success = resService.edit(res);

		// Check if successful
		if (success == true) {
			// Success. Return a custom response
			CustomGenericResponse response = new CustomGenericResponse();
			response.setSuccess(true);
			response.setMessage("Action successful!");
			return response;

		} else {
			// A failure. Return a custom response as well
			CustomGenericResponse response = new CustomGenericResponse();
			response.setSuccess(false);
			response.setMessage("Action failure!");
			return response;
		}

	}

	/**
	 * Delete a existing user
	 */
	@RequestMapping(value = "/resource/delete", method = RequestMethod.POST)
	public @ResponseBody
	CustomGenericResponse delete(HttpServletRequest request,
			@RequestParam("id") String id) {

		logger.debug("Received request to delete a user");
		Resource res = new Resource();
		res.setId(Integer.valueOf(id));
		// Call service to add
		Boolean success = resService.delete(res);

		// Check if successful
		if (success == true) {
			// Success. Return a custom response
			CustomGenericResponse response = new CustomGenericResponse();
			response.setSuccess(true);
			response.setMessage("Action successful!");
			return response;

		} else {
			// A failure. Return a custom response as well
			CustomGenericResponse response = new CustomGenericResponse();
			response.setSuccess(false);
			response.setMessage("Action failure!");
			return response;
		}

	}

	@RequestMapping(value = "/resource/getProjects", method = RequestMethod.GET)
	@ResponseBody
	public String getProjects() {
		return "<select><option value='IMPORTS'>IMPORTS</option><option value='PAYMENTS'>PAYMENTS</option></select>";
	}

	@RequestMapping(value = "/resource/getSkills", method = RequestMethod.GET)
	@ResponseBody
	public String getSkills() {
		return "<select><option value=''>Select</option><option value='UI'>UI</option><option value='JAVA'>JAVA</option><option value='CRYSTAL'>CRYSTAL REPORTS</option><option value='AI'>AB-INITIO</option></select>";
	}

}
