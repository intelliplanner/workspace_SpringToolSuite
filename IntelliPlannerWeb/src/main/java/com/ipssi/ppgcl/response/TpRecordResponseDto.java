package com.ipssi.ppgcl.response;

import java.io.Serializable;

import lombok.Data;

@Data
public class TpRecordResponseDto implements Serializable {

	private static final long serialVersionUID = 647734944159286073L;

	private String tpr_id;

	private String vehicle_id;

	private String tpr_status;
	private String tprStatusValue;

	private String vehicle_name;
	private String load_tare;
	private String load_gross;
	private String earliest_load_gate_in_in;
	private String latest_load_gate_in_out;
	private String earliest_load_wb_in_in;
	private String latest_load_wb_in_out;
	private String earliest_load_yard_in_in;
	private String latest_load_yard_in_out;

	private String load_yard_in_name;

	private String earliest_load_wb_out_in;

	private String latest_load_wb_out_out;

	private String earliest_load_gate_out_in;

	private String latest_load_gate_out_out;

	private String load_gate_out_name;

	private String combo_start;

	private String combo_end;
	private String consignee_name;
	private String reporting_status;

	private String transporter_code;

	private String product_code;

	private String do_number;

	private String ex_invoice;

	private String message;

	private String ref_tpr_id_if_cancelled;

	private String cancellation_reason;

	private String port_node_id;

	private String netWt;

	public String getTpr_id() {
		return tpr_id;
	}

	public void setTpr_id(String tpr_id) {
		this.tpr_id = tpr_id;
	}

	public String getVehicle_id() {
		return vehicle_id;
	}

	public void setVehicle_id(String vehicle_id) {
		this.vehicle_id = vehicle_id;
	}

	public String getTpr_status() {
		return tpr_status;
	}

	public void setTpr_status(String tpr_status) {
		this.tpr_status = tpr_status;
	}

	public String getTprStatusValue() {
		return tprStatusValue;
	}

	public void setTprStatusValue(String tprStatusValue) {
		this.tprStatusValue = tprStatusValue;
	}

	public String getVehicle_name() {
		return vehicle_name;
	}

	public void setVehicle_name(String vehicle_name) {
		this.vehicle_name = vehicle_name;
	}

	public String getLoad_tare() {
		return load_tare;
	}

	public void setLoad_tare(String load_tare) {
		this.load_tare = load_tare;
	}

	public String getLoad_gross() {
		return load_gross;
	}

	public void setLoad_gross(String load_gross) {
		this.load_gross = load_gross;
	}

	public String getEarliest_load_gate_in_in() {
		return earliest_load_gate_in_in;
	}

	public void setEarliest_load_gate_in_in(String earliest_load_gate_in_in) {
		this.earliest_load_gate_in_in = earliest_load_gate_in_in;
	}

	public String getLatest_load_gate_in_out() {
		return latest_load_gate_in_out;
	}

	public void setLatest_load_gate_in_out(String latest_load_gate_in_out) {
		this.latest_load_gate_in_out = latest_load_gate_in_out;
	}

	public String getEarliest_load_wb_in_in() {
		return earliest_load_wb_in_in;
	}

	public void setEarliest_load_wb_in_in(String earliest_load_wb_in_in) {
		this.earliest_load_wb_in_in = earliest_load_wb_in_in;
	}

	public String getLatest_load_wb_in_out() {
		return latest_load_wb_in_out;
	}

	public void setLatest_load_wb_in_out(String latest_load_wb_in_out) {
		this.latest_load_wb_in_out = latest_load_wb_in_out;
	}

	public String getEarliest_load_yard_in_in() {
		return earliest_load_yard_in_in;
	}

	public void setEarliest_load_yard_in_in(String earliest_load_yard_in_in) {
		this.earliest_load_yard_in_in = earliest_load_yard_in_in;
	}

	public String getLatest_load_yard_in_out() {
		return latest_load_yard_in_out;
	}

	public void setLatest_load_yard_in_out(String latest_load_yard_in_out) {
		this.latest_load_yard_in_out = latest_load_yard_in_out;
	}

	public String getLoad_yard_in_name() {
		return load_yard_in_name;
	}

	public void setLoad_yard_in_name(String load_yard_in_name) {
		this.load_yard_in_name = load_yard_in_name;
	}

	public String getEarliest_load_wb_out_in() {
		return earliest_load_wb_out_in;
	}

	public void setEarliest_load_wb_out_in(String earliest_load_wb_out_in) {
		this.earliest_load_wb_out_in = earliest_load_wb_out_in;
	}

	public String getLatest_load_wb_out_out() {
		return latest_load_wb_out_out;
	}

	public void setLatest_load_wb_out_out(String latest_load_wb_out_out) {
		this.latest_load_wb_out_out = latest_load_wb_out_out;
	}

	public String getEarliest_load_gate_out_in() {
		return earliest_load_gate_out_in;
	}

	public void setEarliest_load_gate_out_in(String earliest_load_gate_out_in) {
		this.earliest_load_gate_out_in = earliest_load_gate_out_in;
	}

	public String getLatest_load_gate_out_out() {
		return latest_load_gate_out_out;
	}

	public void setLatest_load_gate_out_out(String latest_load_gate_out_out) {
		this.latest_load_gate_out_out = latest_load_gate_out_out;
	}

	public String getLoad_gate_out_name() {
		return load_gate_out_name;
	}

	public void setLoad_gate_out_name(String load_gate_out_name) {
		this.load_gate_out_name = load_gate_out_name;
	}

	public String getCombo_start() {
		return combo_start;
	}

	public void setCombo_start(String combo_start) {
		this.combo_start = combo_start;
	}

	public String getCombo_end() {
		return combo_end;
	}

	public void setCombo_end(String combo_end) {
		this.combo_end = combo_end;
	}

	public String getConsignee_name() {
		return consignee_name;
	}

	public void setConsignee_name(String consignee_name) {
		this.consignee_name = consignee_name;
	}

	public String getReporting_status() {
		return reporting_status;
	}

	public void setReporting_status(String reporting_status) {
		this.reporting_status = reporting_status;
	}

	public String getTransporter_code() {
		return transporter_code;
	}

	public void setTransporter_code(String transporter_code) {
		this.transporter_code = transporter_code;
	}

	public String getProduct_code() {
		return product_code;
	}

	public void setProduct_code(String product_code) {
		this.product_code = product_code;
	}

	public String getDo_number() {
		return do_number;
	}

	public void setDo_number(String do_number) {
		this.do_number = do_number;
	}

	public String getEx_invoice() {
		return ex_invoice;
	}

	public void setEx_invoice(String ex_invoice) {
		this.ex_invoice = ex_invoice;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getRef_tpr_id_if_cancelled() {
		return ref_tpr_id_if_cancelled;
	}

	public void setRef_tpr_id_if_cancelled(String ref_tpr_id_if_cancelled) {
		this.ref_tpr_id_if_cancelled = ref_tpr_id_if_cancelled;
	}

	public String getCancellation_reason() {
		return cancellation_reason;
	}

	public void setCancellation_reason(String cancellation_reason) {
		this.cancellation_reason = cancellation_reason;
	}

	public String getPort_node_id() {
		return port_node_id;
	}

	public void setPort_node_id(String port_node_id) {
		this.port_node_id = port_node_id;
	}

	public String getNetWt() {
		return netWt;
	}

	public void setNetWt(String netWt) {
		this.netWt = netWt;
	}
}
