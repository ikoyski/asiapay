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
        return "about"; 
    }
    
    @GetMapping("/spn")
    public String spn(Model model, HttpServletRequest request) {        
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());    
        
        model.addAttribute("currentPage", "Client Post Through Browser");
        model.addAttribute("orderRef", timestamp.getTime());
        
        return "spn"; 
    }
    
    @GetMapping("/spn-sch")
    public String spnSch(Model model, HttpServletRequest request) {        
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());        
        LocalDateTime now = LocalDateTime.now();
        
        model.addAttribute("currentPage", "Client Post Through Browser w/ SchedulePay");
        model.addAttribute("orderRef", timestamp.getTime());
        model.addAttribute("year", now.getYear());
        model.addAttribute("month", now.getMonthValue());
        model.addAttribute("day", now.getDayOfMonth());
        
        return "spn-sch"; 
    }
    
    @GetMapping("/spn-promo")
    public String spnPromo(Model model, HttpServletRequest request) {        
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());  
        
        model.addAttribute("currentPage", "Client Post Through Browser w/ PromoPay");
        model.addAttribute("orderRef", timestamp.getTime());
        
        return "spn-promo"; 
    }
    
    @GetMapping("/dpc")
    public String dpc(Model model, HttpServletRequest request) {        
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());    
        
        model.addAttribute("currentPage", "Direct Client Side");
        model.addAttribute("orderRef", timestamp.getTime());
        
        return "dpc"; 
    }
    
    @GetMapping("/dps")
    public String dps(Model model, HttpServletRequest request) {        
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());  
        
        model.addAttribute("currentPage", "Direct Server Side");
        model.addAttribute("orderRef", timestamp.getTime());
        
        return "dps"; 
    }
     
    @PostMapping("/redirect")
    public String redirect(Model model, HttpServletRequest request){
        Map<String, String> params = new HashMap<String, String>();

        Enumeration<String> in = request.getParameterNames();
        while(in.hasMoreElements()) {
        	String paramName = in.nextElement().toString();
        	params.put(paramName, request.getParameter(paramName));        
        }
        
        String baseUrl = "http://localhost"; //TODO
        
        params.put("successUrl", baseUrl + "/result?flag=Successful");
        params.put("failUrl", baseUrl + "/result?flag=Unsuccessful");
        params.put("cancelUrl", baseUrl + "/result?flag=Canceled");
        
        String gatewayUrl = request.getParameter("gatewayUrl");
        String secureHashSecret = request.getParameter("secureHashSecret"); 
        
        params.remove("gatewayUrl");
        params.remove("secureHashSecret");
        
        String plainText = securehashService.constructPlainText(params.get("merchantId"), params.get("orderRef"), 
        		params.get("currCode"), params.get("amount"), params.get("payType"), secureHashSecret);
        
        params.put("secureHash", securehashService.sha1(plainText));
        
        model.addAttribute("gatewayUrl", gatewayUrl); 
        model.addAttribute("params", params);
        
        return "redirect";
    }
    
    @PostMapping("/api-response")
    public String apiResponse(Model model, HttpServletRequest request){
        Map<String, String> params = new HashMap<String, String>();

        Enumeration<String> in = request.getParameterNames();
        while(in.hasMoreElements()) {
        	String paramName = in.nextElement().toString();
        	params.put(paramName, request.getParameter(paramName));        
        }

        String currentPage = request.getParameter("currentPage");
        String gatewayUrl = request.getParameter("gatewayUrl");
        String secureHashSecret = request.getParameter("secureHashSecret"); 

        params.remove("currentPage");
        params.remove("gatewayUrl");
        params.remove("secureHashSecret");
        
        String plainText = securehashService.constructPlainText(params.get("merchantId"), params.get("orderRef"), 
        		params.get("currCode"), params.get("amount"), params.get("payType"), secureHashSecret);
        
        params.put("secureHash", securehashService.sha1(plainText));
        
        String postData = "";
        Iterator<Map.Entry<String, String>> itr = params.entrySet().iterator(); 
        while(itr.hasNext()) { 
        	Map.Entry<String, String> entry = itr.next();	
        	postData = postData.concat(entry.getKey()).concat("=").concat(entry.getValue()).concat("&"); 
        }
        postData = postData.substring(0, postData.length()-1);
        
        String postResponse = apiclientService.post(postData, gatewayUrl);
        
        model.addAttribute("currentPage", currentPage); 
        model.addAttribute("postData", postData); 
        model.addAttribute("postResponse", postResponse);
        
        return "api-response";
    }
    
}