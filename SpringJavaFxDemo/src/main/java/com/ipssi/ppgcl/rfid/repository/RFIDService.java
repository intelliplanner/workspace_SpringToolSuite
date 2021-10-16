package com.ipssi.ppgcl.rfid.repository;

public interface RFIDService {
	String saveRfidData(String str);
	String getRfidData(String str) throws Exception;
}
