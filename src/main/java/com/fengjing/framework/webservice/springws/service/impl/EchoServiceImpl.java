package com.fengjing.framework.webservice.springws.service.impl;

import org.springframework.stereotype.Service;

import com.fengjing.framework.webservice.springws.service.EchoService;

@Service
public class EchoServiceImpl implements EchoService {

    public String echo(String s) {
        return s;
    }
}
