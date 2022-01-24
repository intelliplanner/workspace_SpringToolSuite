package com.ipssi.ppgcl.services;

import com.ipssi.ppgcl.response.ServiceResponse;

public interface TransporterService {

	ServiceResponse fetchTransporterList();

	ServiceResponse fetchTransporterById(int id);

}
