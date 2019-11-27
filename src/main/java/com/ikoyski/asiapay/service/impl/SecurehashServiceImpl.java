package com.ikoyski.asiapay.service.impl;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;
import java.nio.charset.StandardCharsets;

import org.springframework.stereotype.Component;
import com.ikoyski.asiapay.service.SecurehashService;

@Component
public class SecurehashServiceImpl implements SecurehashService {

  public String sha1(String plainText) {
		String sha1 = "";
		try {
			MessageDigest crypt = MessageDigest.getInstance("SHA-1");
			crypt.reset();
			crypt.update(plainText.getBytes(StandardCharsets.UTF_8));
			sha1 = byteToHex(crypt.digest());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return sha1;
	}
	
	public String constructPlainText(String merchantId, String orderRef, String currCode, 
	       String amount, String payType, String secureHashSecret) {
		return "".concat(merchantId).concat("|")
				.concat(orderRef).concat("|")
				.concat(currCode).concat("|")
				.concat(amount).concat("|")
				.concat(payType).concat("|")
				.concat(secureHashSecret);				
	}

	public String byteToHex(final byte[] hash) {
		Formatter formatter = new Formatter();
		for (byte b : hash) {
			formatter.format("%02x", b);
		}
		String result = formatter.toString();
		formatter.close();
		return result;
	}

}
