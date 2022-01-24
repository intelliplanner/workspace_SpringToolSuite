package com.ipssi.ppgcl.utility;

import java.security.MessageDigest;

import org.springframework.stereotype.Component;

@Component
public class Hashing256 {
	/**
	 * @author Virendra Gupta
	 * @purpose Convert string to SHA256 encrypt.
	 * @param secret
	 * @return String
	 */
	public String sha256(String secret) {
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] hash = digest.digest(secret.getBytes("UTF-8"));
			StringBuffer hexString = new StringBuffer();
			for (int i = 0; i < hash.length; i++) {
				String hex = Integer.toHexString(0xff & hash[i]);
				if (hex.length() == 1)
					hexString.append('0');
				hexString.append(hex);
			}
			return hexString.toString();
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}
}
