package com.ikoyski.asiapay.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.ikoyski.asiapay.dto.EchoRequest;
import com.ikoyski.asiapay.dto.EchoResponse;
import com.ikoyski.asiapay.service.EchoService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/v1")
public class EchoController {

  private final EchoService echoService;

  public EchoController(EchoService echoService) {
    super();
    this.echoService = echoService;
  }

  @PostMapping("/echo")
  public ResponseEntity<EchoResponse> echo(@Valid @RequestBody EchoRequest echoRequest, 
      WebRequest requestAttributes) {

    LOGGER.debug("Echo request received {}", echoRequest);
    
    EchoResponse echoResponse = new EchoResponse();
    echoResponse.setMessage(echoService.echo(echoRequest.getMessage()));   

    LOGGER.debug("Echo response returned {}", echoResponse);

    return new ResponseEntity<>(echoResponse, HttpStatus.OK);
    
  }

}
