package com.ipssi.ppgcl.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ipssi.ppgcl.common.Misc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Setter
//@Getter
@Entity
@Table(name = "tp_record")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TPRecordEO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "tpr_id")
	Integer tpr_id;

	@Column(name = "vehicle_id")
	Integer vehicle_id;

	@Column(name = "tpr_status")
	Integer tpr_status;

	@Column(name = "load_gross_time")
	private Date load_gross_time;
	@Column(name = "load_tare_time")
	private Date load_tare_time;

	@Column(name = "material_code_id")
	private Integer material_code_id = Misc.getUndefInt();

	@Column(name = "mpl_ref_doc")
	private Integer mplRefDoc = Misc.getUndefInt();

	@Column(name = "consignee_ref_doc")
	private String consignee_ref_doc;
	@Column(name = "material_description")
	private String material_description;
	@Column(name = "consignee_address")
	private String consignee_address;
	@Column(name = "consignee_notes")
	private String consignee_notes;
	@Column(name = "vehicle_name")
	private String vehicle_name;
	@Column(name = "consignor_name")
	private String consignor_name;
	@Column(name = "consignor_ref_doc")
	private String consignor_ref_doc;
	@Column(name = "consignor_address")
	private String consignor_address;
	@Column(name = "consignor_notes")
	private String consignor_notes;
	@Column(name = "transporter_id")
	private Integer transporter_id = Misc.getUndefInt();
	@Column(name = "consignor_id")
	private Integer consignor_id = Misc.getUndefInt();
	@Column(name = "do_id")
	private Integer do_id = Misc.getUndefInt();
	@Column(name = "material_grade_id")
	private Integer material_grade_id = Misc.getUndefInt();
	@Column(name = "tpr_create_date")
	private Date tpr_create_date;

	@Column(name = "lr_no")
	private String lr_no;
	@Column(name = "dispatch_permit_no")
	private String dispatch_permit_no;
	@Column(name = "load_tare")
	private Double load_tare = Misc.getUndefDouble();
	@Column(name = "load_gross")
	private Double load_gross = Misc.getUndefDouble();
	@Column(name = "unload_tare")
	private Double unload_tare = Misc.getUndefDouble();
	@Column(name = "unload_gross")
	private Double unload_gross = Misc.getUndefDouble();
	@Column(name = "earliest_load_gate_in_in")
	private Date earliest_load_gate_in_in;
	@Column(name = "latest_load_gate_in_out")
	private Date latest_load_gate_in_out;
	@Column(name = "load_gate_in_name")
	private String load_gate_in_name;
	@Column(name = "earliest_load_wb_in_in")
	private Date earliest_load_wb_in_in;
	@Column(name = "latest_load_wb_in_out")
	private Date latest_load_wb_in_out;
	@Column(name = "load_wb_in_name")
	private String loadWbInName;
	@Column(name = "earliest_load_yard_in_in")
	private Date earliest_load_yard_in_in;
	@Column(name = "latest_load_yard_in_out")
	private Date latest_load_yard_in_out;

	@Column(name = "load_yard_in_name")
	private String load_yard_in_name;

	@Column(name = "earliest_load_yard_out_in")
	private Date earliest_load_yard_out_in;

	@Column(name = "latest_load_yard_out_out")
	private Date latest_load_yard_out_out;

	@Column(name = "earliest_load_wb_out_in")
	private Date earliest_load_wb_out_in;

	@Column(name = "latest_load_wb_out_out")
	private Date latest_load_wb_out_out;

	@Column(name = "load_wb_out_name")
	private String load_wb_out_name;

	@Column(name = "earliest_load_gate_out_in")
	private Date earliest_load_gate_out_in;

	@Column(name = "latest_load_gate_out_out")
	private Date latest_load_gate_out_out;

	@Column(name = "load_gate_out_name")
	private String load_gate_out_name;

	@Column(name = "earliest_unload_gate_in_in")
	private Date earliest_unload_gate_in_in;

	@Column(name = "latest_unload_gate_in_out")
	private Date latest_unload_gate_in_out;

	@Column(name = "unload_gate_in_name")
	private String unload_gate_in_name;

	@Column(name = "earliest_unload_wb_in_in")
	private Date earliest_unload_wb_in_in;

	@Column(name = "latest_unload_wb_in_out")
	private Date latest_unload_wb_in_out;

	@Column(name = "unload_wb_in_name")
	private String unload_wb_in_name;

	@Column(name = "earliest_unload_yard_in_in")
	private Date earliest_unload_yard_in_in;
	@Column(name = "latest_unload_yard_in_out")
	private Date latest_unload_yard_in_out;
	@Column(name = "unload_yard_in_name")
	private String unload_yard_in_name;

	@Column(name = "earliest_unload_yard_out_in")
	private Date earliest_unload_yard_out_in;

	@Column(name = "latest_unload_yard_out_out")
	private Date latest_unload_yard_out_out;

	@Column(name = "earliest_unload_wb_out_in")
	private Date earliest_unload_wb_out_in;

	@Column(name = "latest_unload_wb_out_out")
	private Date latest_unload_wb_out_out;

	@Column(name = "unload_wb_out_name")
	private String unload_wb_out_name;
	@Column(name = "earliest_unload_gate_out_in")
	private Date earliest_unload_gate_out_in;

	@Column(name = "latest_unload_gate_out_out")
	private Date latest_unload_gate_out_out;

	@Column(name = "unload_gate_out_name")
	private String unload_gate_out_name;
//	@Column(name="bed_assigned")
//	private String bedAssigned;

	@Column(name = "status_reason")
	private String status_reason;

	@Column(name = "prev_tp_step")
	private Integer prev_tp_step = Misc.getUndefInt();

	@Column(name = "next_tp_step")
	private Integer next_tp_step = Misc.getUndefInt();

	@Column(name = "confirm_time")
	private Date confirm_time;

	@Column(name = "combo_start")
	private Date combo_start;

	@Column(name = "combo_end")
	private Date combo_end;
	@Column(name = "next_trip_id")
	private Integer next_trip_id = Misc.getUndefInt();

	@Column(name = "lr_date")
	private Date lr_date;

	@Column(name = "consignee_id")
	private Integer consignee_id = Misc.getUndefInt();

	@Column(name = "consignee_name")
	private String consignee_name;

	@Column(name = "mark_for_qc")
	private Integer mark_for_qc = Misc.getUndefInt();

	@Column(name = "permit_no")
	private String permit_no;

	@Column(name = "pre_step_type")
	private Integer pre_step_type = Misc.getUndefInt();

	@Column(name = "pre_step_date")
	private Date pre_step_date;

	@Column(name = "blocked_step_type")
	private Integer blocked_step_type;

	@Column(name = "blocked_step_date")
	private Date blocked_step_date;

	@Column(name = "next_step_type")
	private Integer nextStepType = Misc.getUndefInt();

	@Column(name = "is_latest")
	private Integer is_latest = Misc.getUndefInt();

	@Column(name = "driver_src")
	private Integer driver_src = Misc.getUndefInt();

	@Column(name = "vehicle_src")
	private Integer vehicle_src = Misc.getUndefInt();

	@Column(name = "mark_for_gps")
	private Integer mark_for_gps = Misc.getUndefInt();

	@Column(name = "mark_for_qc_reason")
	private String mark_for_qc_reason;

	@Column(name = "supplier_id")
	private Integer supplier_id = Misc.getUndefInt();

	@Column(name = "is_new_vehicle")
	private Integer is_new_vehicle = Misc.getUndefInt();

	@Column(name = "src_device_log_id")
	private Integer src_device_log_id = Misc.getUndefInt();

	@Column(name = "rf_also_on_card")
	private Integer rf_also_on_card = Misc.getUndefInt();

	@Column(name = "material_cat")
	private Integer material_cat = Misc.getUndefInt();

	@Column(name = "stone_lift_area_id")
	private Integer stone_lift_area_id = Misc.getUndefInt();

	@Column(name = "stone_of_transporter_id")
	private Integer stone_of_transporter_id = Misc.getUndefInt();

	@Column(name = "earliest_reg_in")
	private Date earliest_reg_in;

	@Column(name = "latest_reg_out")
	private Date latest_reg_out;

	@Column(name = "challan_data_edit_at_reg")
	private Integer challan_data_edit_at_reg = Misc.getUndefInt();

	@Column(name = "challan_data_edit_at_wb")
	private Integer challan_data_edit_at_wb = Misc.getUndefInt();

	@Column(name = "challan_data_edit_at_preaudit")
	private Integer challan_data_edit_at_preaudit = Misc.getUndefInt();

	@Column(name = "challan_data_edit_at_audit")
	private Integer challan_data_edit_at_audit = Misc.getUndefInt();

	@Column(name = "material_notes_first")
	private String material_notes_first;

	@Column(name = "material_notes_second")
	private String material_notes_second;

	@Column(name = "mpl_reference_doc")
	private String mpl_reference_doc;

	@Column(name = "rf_card_data_merge_time")
	private Date rf_card_data_merge_time;

	@Column(name = "other_material_description")
	private String other_material_description;

	@Column(name = "status")
	private Integer status = Misc.getUndefInt();// Status.ACTIVE;

	@Column(name = "reporting_status")
	private Integer reporting_status = Misc.getUndefInt();

	@Column(name = "unload_yard_out_name")
	private String unload_yard_out_name;

	@Column(name = "load_yard_out_name")
	private String load_yard_out_name;

	@Column(name = "load_flyash_tare_name")
	private String load_flyash_tare_name;

	@Column(name = "load_flyash_gross_name")
	private String load_flyash_gross_name;

	@Column(name = "rfid_info_id")
	private Integer rfid_info_id = Misc.getUndefInt();

	@Column(name = "tpr_type")
	private Integer tpr_type = Misc.getUndefInt();

	@Column(name = "washery_id")
	private Integer washeryId = Misc.getUndefInt();

	@Column(name = "mines_code")
	private String mines_code;

	@Column(name = "transporter_code")
	private String transporter_code;

	@Column(name = "destination_code")
	private String destinationCode;

	@Column(name = "washery_code")
	private String washeryCode;

	@Column(name = "grade_code")
	private String grade_code;

	@Column(name = "product_code")
	private String product_code;

	@Column(name = "rf_mines_code")
	private String rf_mines_code;

	@Column(name = "rf_transporter_code")
	private String rf_transporter_code;

	@Column(name = "rf_destination_code")
	private String rf_destination_code;

	@Column(name = "rf_washery_code")
	private String rf_washery_code;

	@Column(name = "rf_grade_code")
	private String rf_grade_code;

	@Column(name = "rf_product_code")
	private String rf_product_code;

	@Column(name = "do_number")
	private String do_number;

	@Column(name = "remote_tpr_id")
	private Integer remote_tpr_id = Misc.getUndefInt();

//	@Column(name="allowed_by")
//	private String allowedBy = null ;

//	@Column(name="allowed_reason")
//	private String allowedReason;

	@Column(name = "record_src")
	private Integer record_src = Misc.getUndefInt();

	@Column(name = "server_code")
	private String server_code;

	@Column(name = "updated_on")
	private Date updated_on = null;

	@Column(name = "ex_invoice")
	private String ex_invoice;

	@Column(name = "message")
	private String message;

	@Column(name = "ref_tpr_id_if_cancelled")
	private Integer ref_tpr_id_if_cancelled = Misc.getUndefInt();

	@Column(name = "cancellation_reason")
	private Integer cancellation_reason = Misc.getUndefInt();

	@Column(name = "port_node_id")
	private Integer port_node_id = Misc.getUndefInt();
}