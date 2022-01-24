package com.ipssi.ppgcl.repository;

import java.util.Date;
import java.util.List;

import javax.persistence.PersistenceContext;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ipssi.ppgcl.constant.Constants;
import com.ipssi.ppgcl.entity.Users;

@Repository
@PersistenceContext(unitName = Constants.JPA_UNIT_NAME_1)
public interface UsersRepoJpa extends JpaRepository<Users, Integer> {
	@Query(value = "SELECT * FROM Users where 1=1", nativeQuery = true)
	List<Users> fetchAdminDetails(@Param("name") String name, @Param("password") String pwd);

	@Query(value = "SELECT * FROM " + "Users u where u.username=:username", nativeQuery = true)
	List<Users> findByUserId(@Param("username") String username);

	@Query(value = "SELECT * FROM " + "Users where email=:email", nativeQuery = true)
	List<Users> findByEmail(@Param("email") String email);

	@Modifying
	@Transactional
	@Query(value = "insert into Users (username,  name,  password,  createdOn,  email, isActive) "
			+ "values (:username, :name, :password, :createdOn, :email, :isActive)", nativeQuery = true)
	void insertUser(@Param("username") String username, @Param("name") String name, @Param("password") String password,
			@Param("createdOn") Date createdOn, @Param("email") String email, @Param("isActive") boolean isActive);

}
