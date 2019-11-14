package com.ikoyski.asiapay.controller; 

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

import java.sql.Timestamp;

@Slf4j
@Controller
public class AsiapayController {
    
    @RequestMapping("/")
	public String index(Map<String, Object> model) {
		return "index"; // the view on /src/main/webapp/WEB-INF/jsp/index.jsp
	}
    
    @GetMapping("/spn")
    public String spn(Model model) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());        
        model.addAttribute("orderRef", timestamp.getTime());
        
        return "spn"; 
    }
     
    @PostMapping("/spnProcess")
    public String spnProcess(Model model){
        return "redirect"; 
    }
    
    @GetMapping("/about")
    public String about(Model model) {        
        return "about"; 
    }
    
}