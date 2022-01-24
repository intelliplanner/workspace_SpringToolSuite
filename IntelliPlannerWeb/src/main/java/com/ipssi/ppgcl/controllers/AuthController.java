package com.ipssi.ppgcl.controllers;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ipssi.ppgcl.entity.Users;
import com.ipssi.ppgcl.jwt.security.JwtUtils;
import com.ipssi.ppgcl.requestDto.AppAdministratorRequestDto;
import com.ipssi.ppgcl.requestDto.LoginRequest;
import com.ipssi.ppgcl.response.JwtResponse;
import com.ipssi.ppgcl.response.MessageResponse;
import com.ipssi.ppgcl.services.JwtUserDetailService;
import com.ipssi.ppgcl.services.UserService;
import com.ipssi.ppgcl.utility.EncryptionDecryptionUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
//@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@Api( tags = "Auth")
@RequestMapping("/api/auth")
public class AuthController {
	
	@Value("${ipssi.port-node-id}")
	String portNodeId;
	
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	private JwtUserDetailService userDetailsService;

	@Autowired
	JwtUtils jwtUtils;

	@Autowired
	UserService userService;

	@GetMapping("/welcome")
	public String welcome() {
		return "Hello";
	}

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "This method is used to get token")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody LoginRequest authenticationRequest)
			throws Exception {

		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

		final String token = jwtUtils.generateToken(userDetails);

		return ResponseEntity.ok(new JwtResponse(token));
	}

	private void authenticate(String username, String password) throws Exception {
		try {
			String pwd = EncryptionDecryptionUtil.getDecryptedString(password);
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, pwd));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public MessageResponse registerUser(@Valid @RequestBody AppAdministratorRequestDto signUpRequest) {
//		UserDetails userDetails = userDetailsService.loadUserByUsername(signUpRequest.getUsername());
		boolean isUserExist = userService.existsByUsername(signUpRequest.getUserId());
		if (isUserExist) {
			return new MessageResponse("Already Exists", HttpStatus.FOUND.value(), "Error: Username is already taken!");
		}

		isUserExist = userService.existsByEmail(signUpRequest.getEmailId());
		if (isUserExist) {
			return new MessageResponse("Email Already Exists", HttpStatus.FOUND.value(),
					"Error: EmailId is already registered!");
		}
		String encrypt = EncryptionDecryptionUtil.getEncryptedString(signUpRequest.getPassword());
		String decrypt = EncryptionDecryptionUtil.getDecryptedString(encrypt);
		System.out.println("Decode: " + decrypt);
		signUpRequest.setPassword(encrypt);
//		AppAdministratorDto user = new AppAdministratorDto(signUpRequest.getUserId(), signUpRequest.getName(), signUpRequest.getEmailId(),
//				signUpRequest.getPassword(), signUpRequest.getDefaultRoleId(), signUpRequest.getMobileNo());
		Users user=new Users(signUpRequest.getUserId(), signUpRequest.getName(), signUpRequest.getPassword(), true, signUpRequest.getEmailId(), portNodeId, new Date());
		boolean isSuccess = userService.saveUserDetails(user);
		if (!isSuccess)
			return new MessageResponse("Failed", HttpStatus.NOT_MODIFIED.value(), "User registeration Failed");

		return new MessageResponse("Success", HttpStatus.OK.value(), "User registered successfully!");
	}
}
