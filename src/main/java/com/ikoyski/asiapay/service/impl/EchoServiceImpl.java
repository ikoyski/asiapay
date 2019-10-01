package com.ikoyski.asiapay.service.impl;

import org.springframework.stereotype.Component;

import com.ikoyski.asiapay.service.EchoService;

@Component
public class EchoServiceImpl implements EchoService {

  @Override
  public String echo(String message) {
    return message;
  }

}
