package com.ipssi.ppgcl.serviceImpl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipssi.ppgcl.constant.StatusMaster;
import com.ipssi.ppgcl.repository.TransporterRepoJpa;
import com.ipssi.ppgcl.response.CustomReponseStatus;
import com.ipssi.ppgcl.response.ServiceResponse;
import com.ipssi.ppgcl.response.TransporterResponseDto;
import com.ipssi.ppgcl.services.TransporterService;

@Service
public class TransporterServiceImpl implements TransporterService {

	private static final Logger LOGGER = LoggerFactory.getLogger(TransporterServiceImpl.class);

	@Autowired
	private TransporterRepoJpa transporterRepoJpa;

	@Override
	public ServiceResponse fetchTransporterList() {
		ServiceResponse serviceResponse = new ServiceResponse();
		LinkedHashMap<Object, Object> response = new LinkedHashMap<>();
		CustomReponseStatus customResponse = null;
		List<TransporterResponseDto> tprResplist = new ArrayList<TransporterResponseDto>();
		List<Object[]> datalist = transporterRepoJpa.fetchTransporterList();
		for (Object[] obj : datalist) {
			TransporterResponseDto eo = new TransporterResponseDto();
			eo.setId(obj[0] + "");
			eo.setName(obj[1] + "");
			eo.setCreated_on(obj[2] + "");
			eo.setStatus(obj[3] + "");
			tprResplist.add(eo);
		}

		customResponse = new CustomReponseStatus(StatusMaster.SUCCESS.getResponseId(),
				StatusMaster.SUCCESS.getResponseCode(), StatusMaster.SUCCESS.getResponseMessage(),
				StatusMaster.SUCCESS.getResponseDescription());
		response.put("customResponse", customResponse);
		response.put("data", (tprResplist == null || tprResplist.size() == 0) ? "No Data Found" : tprResplist);
		serviceResponse.setServiceResponse(response);
		LOGGER.info("############  End fetchExamDetails()   ############");
		return serviceResponse;
	}
	@Override
	public ServiceResponse fetchTransporterById(int id) {
		ServiceResponse serviceResponse = new ServiceResponse();
		LinkedHashMap<Object, Object> response = new LinkedHashMap<>();
		CustomReponseStatus customResponse = null;
		List<TransporterResponseDto> tprResplist = new ArrayList<TransporterResponseDto>();
		List<Object[]> datalist = transporterRepoJpa.fetchTransporterById(id);
		for (Object[] obj : datalist) {
			TransporterResponseDto eo = new TransporterResponseDto();
			eo.setId(obj[0] + "");
			eo.setName(obj[1] + "");
			eo.setCreated_on(obj[2] + "");
			eo.setStatus(obj[3] + "");
			tprResplist.add(eo);
		}

		customResponse = new CustomReponseStatus(StatusMaster.SUCCESS.getResponseId(),
				StatusMaster.SUCCESS.getResponseCode(), StatusMaster.SUCCESS.getResponseMessage(),
				StatusMaster.SUCCESS.getResponseDescription());
		response.put("customResponse", customResponse);
		response.put("data", (tprResplist == null || tprResplist.size() == 0) ? "No Data Found" : tprResplist);
		serviceResponse.setServiceResponse(response);
		LOGGER.info("############  End fetchExamDetails()   ############");
		return serviceResponse;
	}
}
