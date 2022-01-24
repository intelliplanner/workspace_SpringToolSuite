package com.ipssi.ppgcl.controllers;

import java.util.LinkedHashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ipssi.ppgcl.enums.Status;

@RestController
@RequestMapping("/api/master")
public class MasterController {

	@GetMapping(value = "/tprStatus")
	public LinkedHashMap<Integer, String> getTprStatusList() {
		LinkedHashMap<Integer, String> res = new LinkedHashMap<Integer, String>();
		res.put(Status.TprStatus.ANY.getId(), Status.TprStatus.ANY.getName());
		res.put(Status.TprStatus.IN_PLANT.getId(), Status.TprStatus.IN_PLANT.getName());
		res.put(Status.TprStatus.DISPATCHED.getId(), Status.TprStatus.DISPATCHED.getName());
		res.put(Status.TprStatus.COMPLETED.getId(), Status.TprStatus.COMPLETED.getName());
		return res;
	}

	@GetMapping(value = "/invoiceStatus")
	public LinkedHashMap<Integer, String> getInvoiceStatusList() {
		LinkedHashMap<Integer, String> res = new LinkedHashMap<Integer, String>();
		res.put(Status.InvoiceStatus.ANY.getId(), Status.InvoiceStatus.ANY.getName());
		res.put(Status.InvoiceStatus.NO_RESPONSE.getId(), Status.InvoiceStatus.NO_RESPONSE.getName());
		res.put(Status.InvoiceStatus.SUCCESS.getId(), Status.InvoiceStatus.SUCCESS.getName());
		res.put(Status.InvoiceStatus.FAILED.getId(), Status.InvoiceStatus.FAILED.getName());
		res.put(Status.InvoiceStatus.CANCEL.getId(), Status.InvoiceStatus.CANCEL.getName());
		return res;
	}

}
