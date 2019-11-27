package com.ikoyski.asiapay.controller; 

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.extern.slf4j.Slf4j;

import java.sql.Timestamp;
import java.util.*;

import com.ikoyski.asiapay.service.SecurehashService;

@Slf4j
@Controller
public class AsiapayController {
    
    private final SecurehashService securehashService;
    
    public AsiapayController(SecurehashService securehashService) {
        super();
        this.securehashService = securehashService;
    }
    
    @GetMapping("/")
	public String index() {
		return "index"; // the view on /src/main/webapp/WEB-INF/jsp/index.jsp
	}
    
    @GetMapping("/spn")
    public String spn(Model model, HttpServletRequest request) {        
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());        
        model.addAttribute("orderRef", timestamp.getTime());
        
        return "spn"; 
    }
     
    @PostMapping("/spnProcess")
    public String spnProcess(Model model, HttpServletRequest request){
        Map<String, String> params = new HashMap<String, String>();

        Enumeration<String> in = request.getParameterNames();
        while(in.hasMoreElements()) {
        	String paramName = in.nextElement().toString();
        	params.put(paramName, request.getParameter(paramName));
        
        }
        
        //params.put("successUrl", request.getLocalName() + "/result.jsp?flag=Successful"); 
        //params.put("failUrl", request.getLocalName() + "/result.jsp?flag=Unsuccessful"); 
        //params.put("cancelUrl", request.getLocalName() + "/result.jsp?flag=Canceled"); 
        
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
    
    @GetMapping("/about")
    public String about(Model model) {        
        return "about"; 
    }
    
}