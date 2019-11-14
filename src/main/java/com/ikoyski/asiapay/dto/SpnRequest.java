package com.ikoyski.asiapay.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SpnRequest {
    
    private String merchantId;
    private String amount;
    private String currCode;
    private String payType;
    private String lang;
    private String payMethod;
    private String successUrl;
    private String failUrl;
    private String cancelUrl;
    private String orderRef;
    
    private String secureHashSecret;
    
}
