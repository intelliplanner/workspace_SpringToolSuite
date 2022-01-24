package com.ipssi.ppgcl.repository;

import java.util.List;

import javax.persistence.PersistenceContext;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ipssi.ppgcl.constant.Constants;
import com.ipssi.ppgcl.entity.TransporterEO;

@Repository
@PersistenceContext(unitName = Constants.JPA_UNIT_NAME_1)
public interface TransporterRepoJpa extends JpaRepository<TransporterEO, String> {
	@Query(value = "SELECT tpr.id,tpr.name,tpr.created_on,tpr.status FROM transporter_details tpr WHERE 1=1", nativeQuery = true)
	List<Object[]> fetchTransporterList();

	@Query(value = "SELECT tpr.id,tpr.name,tpr.created_on,tpr.status FROM transporter_details tpr WHERE tpr.id=:id", nativeQuery = true)
	List<Object[]> fetchTransporterById(@Param("id") int id);
}
