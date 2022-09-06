package com.gestopago.springboot.service.impl;

import java.net.InetAddress;

import org.springframework.stereotype.Service;

import com.gestopago.springboot.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService {
      
    @Override
    public String getServerAddress() throws Exception {
        final String serverAddress = InetAddress.getLocalHost().getHostAddress();
        return serverAddress;
    }
}
