package com.ipssi.ppgcl.repository;

import java.util.List;

import javax.persistence.PersistenceContext;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ipssi.ppgcl.constant.Constants;

@Repository
@PersistenceContext(unitName = Constants.JPA_UNIT_NAME_1)
public interface MasterRepoJpa{
	@Query(value = "SELECT distinct session FROM MD_Result", nativeQuery = true)
	List<Integer> fetchSessionList();
	
	@Query(value = "SELECT id,class,session,title, resultType FROM MD_Result WHERE session=:session", nativeQuery = true)
	List<Integer> fetchResultList(@Param("session") String session);

}
