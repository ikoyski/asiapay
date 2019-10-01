package com.ikoyski.asiapay.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

import java.sql.Timestamp;

@Slf4j
@Controller
public class AsiapayController {
    
    @GetMapping("/hello")
    public String hello(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
        
        LOGGER.debug("Name:  {}", name);
        
        model.addAttribute("name", name);
        
        return "hello"; // the view on /src/main/webapp/WEB-INF/jsp/hello.jsp
    }
    
    @GetMapping("/")
    public String index(Model model) {
        
        return "index"; 
    }
    
    @GetMapping("/client-post-through-browser")
    public String clientPostThroughBrowser(Model model) {
        
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        
        model.addAttribute("orderRef", timestamp.getTime());
        return "client-post-through-browser"; 
    }
    
}