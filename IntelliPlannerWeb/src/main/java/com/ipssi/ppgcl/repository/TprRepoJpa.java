package com.ipssi.ppgcl.repository;

import java.util.List;

import javax.persistence.PersistenceContext;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ipssi.ppgcl.constant.Constants;
import com.ipssi.ppgcl.entity.TPRecordEO;

@Repository
@PersistenceContext(unitName = Constants.JPA_UNIT_NAME_1)
public interface TprRepoJpa extends JpaRepository<TPRecordEO, String> {
	@Query(value = "SELECT tpr.tpr_id,tpr.vehicle_id,tpr.tpr_status,tpr.reporting_status,"
			+ "tpr.ex_invoice,tpr.consignee_name,tpr.do_number, tpr.product_code,tpr.load_tare, tpr.load_gross,"
			+ "tpr.earliest_load_gate_in_in, tpr.latest_load_gate_in_out,"
			+ "tpr.earliest_load_wb_in_in,tpr.latest_load_wb_in_out,"
			+ "tpr.earliest_load_wb_out_in, tpr.latest_load_wb_out_out,"
			+ "tpr.earliest_load_gate_out_in, tpr.latest_load_gate_out_out,tpr.transporter_code,tpr.vehicle_name "
			+ " FROM tp_record tpr WHERE tpr.tpr_status=:tpr_status", nativeQuery = true)
	List<Object[]> fetchResultListByStatus(@Param("tpr_status") int tpr_status);

	@Query(value = "SELECT tpr.tpr_id,tpr.vehicle_id,tpr.tpr_status,tpr.reporting_status,"
			+ "tpr.ex_invoice,tpr.consignee_name,tpr.do_number, tpr.product_code,tpr.load_tare, tpr.load_gross,"
			+ "tpr.earliest_load_gate_in_in, tpr.latest_load_gate_in_out,"
			+ "tpr.earliest_load_wb_in_in,tpr.latest_load_wb_in_out,"
			+ "tpr.earliest_load_wb_out_in, tpr.latest_load_wb_out_out,"
			+ "tpr.earliest_load_gate_out_in, tpr.latest_load_gate_out_out ,tpr.transporter_code, tpr.vehicle_name"
			+ " FROM tp_record tpr WHERE 1=1", nativeQuery = true)
	List<Object[]> fetchResultList();

	@Query(value = "SELECT tpr.tpr_id,tpr.vehicle_id,tpr.tpr_status,tpr.reporting_status,"
			+ "tpr.ex_invoice,tpr.consignee_name,tpr.do_number, tpr.product_code,tpr.load_tare, tpr.load_gross,"
			+ "tpr.earliest_load_gate_in_in, tpr.latest_load_gate_in_out,"
			+ "tpr.earliest_load_wb_in_in,tpr.latest_load_wb_in_out,"
			+ "tpr.earliest_load_wb_out_in, tpr.latest_load_wb_out_out,"
			+ "tpr.earliest_load_gate_out_in, tpr.latest_load_gate_out_out, tpr.transporter_code, tpr.vehicle_name "
			+ " FROM tp_record tpr WHERE tpr_id=:tpr_id", nativeQuery = true)
	List<Object[]> fetchTprByTprId(int tpr_id);

	
	@Query(value = "select count(tpr_id) from tp_record where tpr_status in (2) and tpr_create_date between :fromDate  and :toDate " 
			, nativeQuery = true)
	int getTripCompleted(String fromDate, String toDate);

	@Query(value = "select count(tpr_id) from tp_record where tpr_status in (0,1) and tpr_create_date between :fromDate  and :toDate " 
			, nativeQuery = true)
	int getTripRunning(String fromDate, String toDate);
}
