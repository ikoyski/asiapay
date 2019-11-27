package com.ikoyski.asiapay.service.impl;

import java.io.*;
import java.net.*;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;

import java.nio.charset.StandardCharsets;

import org.springframework.stereotype.Component;
import com.ikoyski.asiapay.service.ApiclientService;

@Component
public class ApiclientServiceImpl implements ApiclientService {

  public String post(String params, String endpoint) {
		String strResult = ""; 
		
		try {
			
			URL url = new URL(endpoint);
			
			HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
			
			SSLContext sc = SSLContext.getInstance("TLSv1.2");
			sc.init(null, null, null);			
			con.setSSLSocketFactory(sc.getSocketFactory());
			con.setRequestMethod("POST");
			con.setDoOutput(true);
			con.getOutputStream().write(params.getBytes(StandardCharsets.UTF_8));
			con.getOutputStream().flush();
			
			InputStream inStream = null;
			if (con.getResponseCode() >= 400) {
				inStream = con.getErrorStream(); 
			}else {
				inStream = con.getInputStream(); 
			}
			 
			while (true) {                                 
				int c = inStream.read();                                 
				if (c == -1)                                         
					break;                                 
				strResult = strResult + String.valueOf((char)c);                         
			}
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (KeyManagementException e) {
			e.printStackTrace();
		} 
		
		return strResult;
	}

}
