package com.ikoyski.asiapay.controller; 

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.extern.slf4j.Slf4j;

import java.sql.Timestamp;
import java.util.*;
import java.time.*;

import com.ikoyski.asiapay.service.SecurehashService;
import com.ikoyski.asiapay.service.ApiclientService;

@Slf4j
@Controller
public class AsiapayController {
    
    private static final String ATTR_CURRENT_PAGE = "currentPage";
    private static final String ATTR_ORDER_REF = "orderRef";
    private static final String ATTR_GATEWAY_URL = "gatewayUrl";
    private static final String ATTR_SECURE_HASH_SECRET = "secureHashSecret";
    private static final String ATTR_MERCHANT_ID = "merchantId";
    private static final String ATTR_CURR_CODE = "currCode";
    private static final String ATTR_AMOUNT = "amount";
    private static final String ATTR_PAY_TYPE = "payType";
    private static final String ATTR_SECURE_HASH = "secureHash";
    
    private static final String ATTR_SUCCESS_URL = "successUrl";
    private static final String ATTR_FAIL_URL = "failUrl";
    private static final String ATTR_CANCEL_URL = "cancelUrl";
    
    private static final String ATTR_YEAR = "year";
    private static final String ATTR_MONTH = "month";
    private static final String ATTR_DAY = "day";
    
    private final SecurehashService securehashService;
    private final ApiclientService apiclientService;
    
    public AsiapayController(SecurehashService securehashService, 
            ApiclientService apiclientService) {
        super();
        this.securehashService = securehashService;
        this.apiclientService = apiclientService;
    }
    
    @GetMapping("/")
	public String index() {
		return "index"; // the view on /src/main/webapp/WEB-INF/jsp/index.jsp
	}
	
	@GetMapping("/about")
    public String about(Model model) {
        model.addAttribute(ATTR_CURRENT_PAGE, "About");
        
        return "about"; 
    }
    
    @GetMapping("/spn")
    public String spn(Model model, HttpServletRequest request) {        
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());    
        
        model.addAttribute(ATTR_CURRENT_PAGE, "Client Post Through Browser");
        model.addAttribute(ATTR_ORDER_REF, timestamp.getTime());
        
        return "spn"; 
    }
    
    @GetMapping("/spn-sch")
    public String spnSch(Model model, HttpServletRequest request) {        
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());        
        LocalDateTime now = LocalDateTime.now();
        
        model.addAttribute(ATTR_CURRENT_PAGE, "Client Post Through Browser w/ SchedulePay");
        model.addAttribute(ATTR_ORDER_REF, timestamp.getTime());
        model.addAttribute(ATTR_YEAR, now.getYear());
        model.addAttribute(ATTR_MONTH, now.getMonthValue());
        model.addAttribute(ATTR_DAY, now.getDayOfMonth());
        
        return "spn-sch"; 
    }
    
    @GetMapping("/spn-promo")
    public String spnPromo(Model model, HttpServletRequest request) {        
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());  
        
        model.addAttribute(ATTR_CURRENT_PAGE, "Client Post Through Browser w/ PromoPay");
        model.addAttribute(ATTR_ORDER_REF, timestamp.getTime());
        
        return "spn-promo"; 
    }
    
    @GetMapping("/dpc")
    public String dpc(Model model, HttpServletRequest request) {        
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());    
        
        model.addAttribute(ATTR_CURRENT_PAGE, "Direct Client Side");
        model.addAttribute(ATTR_ORDER_REF, timestamp.getTime());
        
        return "dpc"; 
    }
    
    @GetMapping("/dps")
    public String dps(Model model, HttpServletRequest request) {        
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());  
        
        model.addAttribute(ATTR_CURRENT_PAGE, "Direct Server Side");
        model.addAttribute(ATTR_ORDER_REF, timestamp.getTime());
        
        return "dps"; 
    }
     
    @PostMapping("/redirect")
    public String redirect(Model model, HttpServletRequest request){
        Map<String, String> params = new HashMap<>();

        Enumeration<String> in = request.getParameterNames();
        while(in.hasMoreElements()) {
        	String paramName = in.nextElement();
        	params.put(paramName, request.getParameter(paramName));        
        }
        
        String baseUrl = "http://rpi3:82/asiapay"; //TODO
        
        params.put(ATTR_SUCCESS_URL, baseUrl + "/result?flag=Successful");
        params.put(ATTR_FAIL_URL, baseUrl + "/result?flag=Unsuccessful");
        params.put(ATTR_CANCEL_URL, baseUrl + "/result?flag=Canceled");
        
        String currentPage = request.getParameter(ATTR_CURRENT_PAGE);
        String gatewayUrl = request.getParameter(ATTR_GATEWAY_URL);
        String secureHashSecret = request.getParameter(ATTR_SECURE_HASH_SECRET); 
        
        params.remove(ATTR_CURRENT_PAGE);
        params.remove(ATTR_GATEWAY_URL);
        params.remove(ATTR_SECURE_HASH_SECRET);
        
        if(!"".equals(secureHashSecret)){
            String plainText = securehashService.constructPlainText(params.get(ATTR_MERCHANT_ID), params.get(ATTR_ORDER_REF), 
            		params.get(ATTR_CURR_CODE), params.get(ATTR_AMOUNT), params.get(ATTR_PAY_TYPE), secureHashSecret);            
            params.put(ATTR_SECURE_HASH, securehashService.sha1(plainText));
        }
    
        model.addAttribute(ATTR_CURRENT_PAGE, currentPage);
        model.addAttribute(ATTR_GATEWAY_URL, gatewayUrl);
        model.addAttribute("params", params);
        
        return "redirect";
    }
    
    @PostMapping("/api-response")
    public String apiResponse(Model model, HttpServletRequest request){
        Map<String, String> params = new HashMap<>();

        Enumeration<String> in = request.getParameterNames();
        while(in.hasMoreElements()) {
        	String paramName = in.nextElement();
        	params.put(paramName, request.getParameter(paramName));        
        }

        String currentPage = request.getParameter(ATTR_CURRENT_PAGE);
        String gatewayUrl = request.getParameter(ATTR_GATEWAY_URL);
        String secureHashSecret = request.getParameter(ATTR_SECURE_HASH_SECRET)==null?"":request.getParameter(ATTR_SECURE_HASH_SECRET); 

        params.remove(ATTR_CURRENT_PAGE);
        params.remove(ATTR_GATEWAY_URL);
        params.remove(ATTR_SECURE_HASH_SECRET);
        
        if(!"".equals(secureHashSecret)){
            String plainText = securehashService.constructPlainText(params.get(ATTR_MERCHANT_ID), params.get(ATTR_ORDER_REF), 
            		params.get(ATTR_CURR_CODE), params.get(ATTR_AMOUNT), params.get(ATTR_PAY_TYPE), secureHashSecret);            
            params.put(ATTR_SECURE_HASH, securehashService.sha1(plainText));
        }
    
        String postData = "";
        Iterator<Map.Entry<String, String>> itr = params.entrySet().iterator(); 
        while(itr.hasNext()) { 
        	Map.Entry<String, String> entry = itr.next();	
        	postData = postData.concat(entry.getKey()).concat("=").concat(entry.getValue()).concat("&"); 
        }
        postData = postData.substring(0, postData.length()-1);
        
        String postResponse = apiclientService.post(postData, gatewayUrl);
        
        model.addAttribute(ATTR_CURRENT_PAGE, currentPage); 
        model.addAttribute(ATTR_GATEWAY_URL, gatewayUrl);
        model.addAttribute("postData", postData); 
        model.addAttribute("postResponse", postResponse); 
        
        return "api-response";
    }
    
}