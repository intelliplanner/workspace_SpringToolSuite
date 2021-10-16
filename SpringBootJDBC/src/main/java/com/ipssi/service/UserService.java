package com.ipssi.service;

import org.springframework.security.core.userdetails.UserDetails;

import com.ipssi.dto.UserMaster;

public interface UserService {


//	ServiceResponse changePassword(UserBean user);
//
	UserDetails findByUserName(String username);

	int save(UserMaster user);

//	int loginTrail(String user, String ipaddress);

//	UserBean getUserDetail(String username,String password);
//
//	ServiceResponse saveUserDetail(UserBean user);
//
//	ServiceResponse fetchAssignPermissionDetails();
//
//	ServiceResponse fetchUserDetails(String username, String level, String district, String block, String cluster,
//			String school, String status, String role, String fromdate, String todate, String creatorname,
//			String modifiername, int pageno, int noofrecords, int userId);
//
//	ServiceResponse fetchUserWiseAuthorisationDetails(String username, String level, String district, String block,
//			String cluster, String school, String status, String role, int pageNo, int noofrecords, int userId);
//
//	ServiceResponse fetchAssignPermissionDetailsByUserId(String userId);
//
//	ServiceResponse fetchAssignPermissionDetailsByRoleId(String roleId);
//
//	ServiceResponse fetchUserRegionMappingByUserId(String userId);
//
//	UserBean findUserById(int userId);
//
//	ServiceResponse validateMobile(String mobile);
//
//	ServiceResponse validateEmail(String email);
//
//	int logoutTrail(String user);
//	
//	ServiceResponse forgetPassword(UserBean user);
//	
//	ServiceResponse verifyTokenByUsername(UserBean user);
//	
//	ServiceResponse resetPassword(UserBean user);
//	
//	ServiceResponse resetDefaultPassword(String user);
//	
//	boolean isTokenExpired(String tokenValue);

}
