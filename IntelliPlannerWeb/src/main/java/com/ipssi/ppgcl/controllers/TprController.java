package com.ipssi.ppgcl.controllers;

import java.util.LinkedHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ipssi.ppgcl.entity.TPRecordEO;
import com.ipssi.ppgcl.response.ServiceResponse;
import com.ipssi.ppgcl.services.TpRecordService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = "Tpr Api's")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/tpr")
public class TprController {

	@Autowired
	TpRecordService tpRecordService;

	@RequestMapping(value = "/getTpRecordById", method = RequestMethod.GET)
	@ApiOperation(value = "This method is used to get the getTpRecord.")
	public ServiceResponse getTpRecordByTprId(@RequestParam("id") int tprID) throws Exception {
		return tpRecordService.fetchTprByTprId(tprID);
	}

	@RequestMapping(value = "/getTpRecordListByStatus", method = RequestMethod.GET)
	@ApiOperation(value = "This method is used to get the ExamResultList.")
	public ServiceResponse getTpRecordListByStatus(@RequestParam("tprStatus") Integer tprStatus) throws Exception {
		return tpRecordService.fetchTpRecordDetailsByStatus(tprStatus);
	}

	@RequestMapping(value = "/getTpRecordList", method = RequestMethod.GET)
	@ApiOperation(value = "This method is used to get the ExamResultList.")
	public ServiceResponse getTpRecordList() throws Exception {
		return tpRecordService.fetchTpRecordDetails();
	}

	@RequestMapping(value = "/updateTpRecord", method = RequestMethod.GET)
	public ServiceResponse updateTpRecord(@RequestBody TPRecordEO dto) throws Exception {
		return tpRecordService.updateTpRecord(dto);
	}

	@RequestMapping(value = "/getCounts", method = RequestMethod.GET)
	public LinkedHashMap<Object, Object> getCounts() throws Exception {
		return tpRecordService.getCounts();
	}

}
