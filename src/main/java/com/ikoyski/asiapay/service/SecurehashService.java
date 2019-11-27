package com.ikoyski.asiapay.service;

public interface SecurehashService {

  public String sha1(String plainText);
  
  public String constructPlainText(String merchantId, String orderRef, String currCode, 
        String amount, String payType, String secureHashSecret);
    
  public String byteToHex(final byte[] hash);

}