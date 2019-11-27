package com.ikoyski.asiapay.service.impl;

import java.io.*;
import java.net.*;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;

import org.springframework.stereotype.Component;
import com.ikoyski.asiapay.service.ApiclientService;;

@Component
public class ApiclientServiceImpl implements ApiclientService {

  public String post(String params, String endpoint) {
		String strResult = ""; 
		
		URL url;
		try {
			
			url = new URL(endpoint);
			
			HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
			
			SSLContext sc;
			try {
				sc = SSLContext.getInstance("TLSv1.2");
				sc.init(null, null, null);
				con.setSSLSocketFactory(sc.getSocketFactory());
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}catch (KeyManagementException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
			con.setRequestMethod("POST");
			con.setDoOutput(true);
			con.getOutputStream().write(params.getBytes("UTF-8"));
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
			
			//con.getInputStream().close();
			//con.getOutputStream().close();
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return strResult;
	}

}
