package com.ipssi.ppgcl.rfid.repository;

import org.springframework.beans.factory.annotation.Autowired;

import com.ipssi.ppgcl.rfid.service.RFIDRepository;

public class RFIDServiceImpl implements RFIDService {

	@Autowired
	RFIDRepository rfidRepository;

	@Override
	public String saveRfidData(String str) {
		// TODO Auto-generated method stub
		return rfidRepository.saveRfidData(str);
	}

	@Override
	public String getRfidData(String str) throws Exception {
		// TODO Auto-generated method stub
		return rfidRepository.getRfidData(str);
	}
	

}
