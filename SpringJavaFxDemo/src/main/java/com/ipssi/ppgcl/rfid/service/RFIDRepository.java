package com.ipssi.ppgcl.rfid.service;

public interface RFIDRepository {
	String saveRfidData(String str);
	String getRfidData(String str) throws Exception;
}
