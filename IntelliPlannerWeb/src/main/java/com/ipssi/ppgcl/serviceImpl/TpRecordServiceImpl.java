package com.ipssi.ppgcl.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipssi.ppgcl.common.Misc;
import com.ipssi.ppgcl.constant.StatusMaster;
import com.ipssi.ppgcl.entity.TPRecordEO;
import com.ipssi.ppgcl.enums.Status;
import com.ipssi.ppgcl.repository.TprRepoJpa;
import com.ipssi.ppgcl.response.CustomReponseStatus;
import com.ipssi.ppgcl.response.ServiceResponse;
import com.ipssi.ppgcl.response.TpRecordResponseDto;
import com.ipssi.ppgcl.services.TpRecordService;

@Service
public class TpRecordServiceImpl implements TpRecordService {
	private static final Logger LOGGER = LoggerFactory.getLogger(TpRecordServiceImpl.class);

	@Autowired
	private TprRepoJpa tprRepoJpa;

	@Override
	public ServiceResponse fetchTprByTprId(int tprID) {
		ServiceResponse serviceResponse = new ServiceResponse();
		LinkedHashMap<Object, Object> response = new LinkedHashMap<>();
		CustomReponseStatus customResponse = null;
		List<TpRecordResponseDto> tprResplist = new ArrayList<TpRecordResponseDto>();
		List<Object[]> datalist = tprRepoJpa.fetchTprByTprId(tprID);

		for (Object[] obj : datalist) {
			TpRecordResponseDto eo = new TpRecordResponseDto();
			eo.setTpr_id(obj[0] + "");
			eo.setVehicle_id(obj[1] + "");
			String statusTpr = Status.TprStatus.getById(Integer.parseInt(obj[2]+ "")).getName();
			eo.setTprStatusValue(statusTpr);
			eo.setTpr_status(obj[2]+ "");
			eo.setReporting_status(obj[3] + "");
			eo.setEx_invoice(obj[4] + "");
			eo.setConsignee_name(obj[5] + "");
			eo.setDo_number(obj[6] + "");
			eo.setProduct_code(obj[7] + "");
			eo.setLoad_tare(obj[8] + "");
			eo.setLoad_gross(obj[9] + "");
			eo.setEarliest_load_gate_in_in(obj[10] + "");
			eo.setLatest_load_gate_in_out(obj[11] + "");
			eo.setEarliest_load_wb_in_in(obj[12] + "");
			eo.setLatest_load_wb_in_out(obj[13] + "");
			eo.setEarliest_load_wb_out_in(obj[14] + "");
			eo.setLatest_load_wb_out_out(obj[15] + "");
			eo.setEarliest_load_gate_out_in(obj[16] + "");
			eo.setLatest_load_gate_out_out(obj[17] + "");
			eo.setTransporter_code(obj[18] + "");
			eo.setVehicle_name(obj[19] + "");
			String netWt = calculateNetWeight(obj[8] + "", obj[9] + "");
			eo.setNetWt(netWt);
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
	public ServiceResponse fetchTpRecordDetailsByStatus(int tprStatus) {
		ServiceResponse serviceResponse = new ServiceResponse();
		LinkedHashMap<Object, Object> response = new LinkedHashMap<>();
		CustomReponseStatus customResponse = null;
		List<TpRecordResponseDto> tprResplist = new ArrayList<TpRecordResponseDto>();
		List<Object[]> datalist = tprRepoJpa.fetchResultListByStatus(tprStatus);
		for (Object[] obj : datalist) {
			TpRecordResponseDto eo = new TpRecordResponseDto();
			eo.setTpr_id(obj[0] + "");
			eo.setVehicle_id(obj[1] + "");
			String statusTpr = Status.TprStatus.getById(Integer.parseInt(obj[2]+ "")).getName();
			eo.setTprStatusValue(statusTpr);
			eo.setTpr_status(obj[2]+ "");
			eo.setReporting_status(obj[3] + "");
			eo.setEx_invoice(obj[4] + "");
			eo.setConsignee_name(obj[5] + "");
			eo.setDo_number(obj[6] + "");
			eo.setProduct_code(obj[7] + "");
			eo.setLoad_tare(obj[8] + "");
			eo.setLoad_gross(obj[9] + "");
			eo.setEarliest_load_gate_in_in(obj[10] + "");
			eo.setLatest_load_gate_in_out(obj[11] + "");
			eo.setEarliest_load_wb_in_in(obj[12] + "");
			eo.setLatest_load_wb_in_out(obj[13] + "");
			eo.setEarliest_load_wb_out_in(obj[14] + "");
			eo.setLatest_load_wb_out_out(obj[15] + "");
			eo.setEarliest_load_gate_out_in(obj[16] + "");
			eo.setLatest_load_gate_out_out(obj[17] + "");
			eo.setTransporter_code(obj[18] + "");
			eo.setVehicle_name(obj[19] + "");
			String netWt = calculateNetWeight(obj[8] + "", obj[9] + "");
			eo.setNetWt(netWt);

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
	public ServiceResponse fetchTpRecordDetails() {
		ServiceResponse serviceResponse = new ServiceResponse();
		LinkedHashMap<Object, Object> response = new LinkedHashMap<>();
		CustomReponseStatus customResponse = null;
		List<TpRecordResponseDto> tprResplist = new ArrayList<TpRecordResponseDto>();
		List<Object[]> datalist = tprRepoJpa.fetchResultList();

		for (Object[] obj : datalist) {
			TpRecordResponseDto eo = new TpRecordResponseDto();
			eo.setTpr_id(obj[0] + "");
			eo.setVehicle_id(obj[1] + "");
			String tprStatus = Status.TprStatus.getById(Integer.parseInt(obj[2]+ "")).getName();
			eo.setTprStatusValue(tprStatus);
			eo.setTpr_status(obj[2]+ "");
			eo.setReporting_status(obj[3] + "");
			eo.setEx_invoice(obj[4] + "");
			eo.setConsignee_name(obj[5] + "");
			eo.setDo_number(obj[6] + "");
			eo.setProduct_code(obj[7] + "");
			eo.setLoad_tare(obj[8] + "");
			eo.setLoad_gross(obj[9] + "");
			eo.setEarliest_load_gate_in_in(obj[10] + "");
			eo.setLatest_load_gate_in_out(obj[11] + "");
			eo.setEarliest_load_wb_in_in(obj[12] + "");
			eo.setLatest_load_wb_in_out(obj[13] + "");
			eo.setEarliest_load_wb_out_in(obj[14] + "");
			eo.setLatest_load_wb_out_out(obj[15] + "");
			eo.setEarliest_load_gate_out_in(obj[16] + "");
			eo.setLatest_load_gate_out_out(obj[17] + "");
			eo.setTransporter_code(obj[18] + "");
			eo.setVehicle_name(obj[19] + "");
			String netWt = calculateNetWeight(obj[8] + "", obj[9] + "");
			eo.setNetWt(netWt);
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
	public ServiceResponse updateTpRecord(TPRecordEO tpRecord) {
		ServiceResponse response = new ServiceResponse();
		LinkedHashMap<Object, Object> serviceResponse = new LinkedHashMap<Object, Object>();
		boolean status = false;// tprRepoJpa.updateTpRecord(tpRecord);
		serviceResponse.put("status", status);
		response.setServiceResponse(serviceResponse);
		return response;
	}

	private String calculateNetWeight(String tare, String gross) {
		Double _tare = (tare == null || tare.equalsIgnoreCase("null") || tare.length() == 0) ? Misc.getUndefDouble()
				: Double.parseDouble(tare);
		Double _gross = (gross == null || gross.equalsIgnoreCase("null") || gross.length() == 0) ? Misc.getUndefDouble()
				: Double.parseDouble(gross);
		String netWt = "";
		if (_tare != Misc.getUndefDouble() && _gross != Misc.getUndefDouble()) {
			double Wb_Net_Wt = _gross - _tare;
			netWt = Misc.getPrintableDouble(Wb_Net_Wt);
		}
		return netWt;
	}

	@Override
	public LinkedHashMap<Object, Object> getCounts() {
		ServiceResponse response = new ServiceResponse();
		LinkedHashMap<Object, Object> serviceResponse = new LinkedHashMap<Object, Object>();
		// tprRepoJpa.updateTpRecord(tpRecord);
		String fromDate = "2018-01-10 00:00:00"; //Misc.dateFormat.format(new Date()) + " 00:00:00";
		String toDate = Misc.dateFormat.format(new Date()) + " 23:59:59";
//		String query = "select count(tpr_id) from tp_record where tpr_status in (0,1) and tpr_create_date between '"+ fromDate + "' and '" + toDate +"'";
		int tripCompleted = tprRepoJpa.getTripCompleted(fromDate, toDate);
		int tripRunning = tprRepoJpa.getTripRunning(fromDate, toDate);
		serviceResponse.put("TripCompleted", tripCompleted);
		serviceResponse.put("TripRunning", tripRunning);
		response.setServiceResponse(serviceResponse);
		return serviceResponse;
	}

}
