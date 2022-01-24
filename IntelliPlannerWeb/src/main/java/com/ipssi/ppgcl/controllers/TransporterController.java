package com.ipssi.ppgcl.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ipssi.ppgcl.response.ServiceResponse;
import com.ipssi.ppgcl.services.TransporterService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Api(tags = "Transporter Api's")
@RequestMapping("/api/transporter")
public class TransporterController {
	@Autowired
	TransporterService transporterService;

	@RequestMapping(value = "/getTransporterList", method = RequestMethod.GET)
	@ApiOperation(value = "This method is used to get the getTransporterList.")
	public ServiceResponse getTransporterList() throws Exception {
		return transporterService.fetchTransporterList();
	}
	
	@RequestMapping(value = "/getTransporterById", method = RequestMethod.GET)
	@ApiOperation(value = "This method is used to get the getTransporterById.")
	public ServiceResponse getTransporterById(@RequestParam("id") int id) throws Exception {
		return transporterService.fetchTransporterById(id);
	}
}
