package com.ipssi.ppgcl.services;

import java.util.LinkedHashMap;

import com.ipssi.ppgcl.entity.TPRecordEO;
import com.ipssi.ppgcl.response.ServiceResponse;

public interface TpRecordService {

	ServiceResponse fetchTprByTprId(int tprID);

	ServiceResponse fetchTpRecordDetailsByStatus(int activeStatus);
	
	ServiceResponse updateTpRecord(TPRecordEO tpRecord) ;

	ServiceResponse fetchTpRecordDetails();

	LinkedHashMap<Object, Object> getCounts();
}
