package com.smsservices.smsapp.controller;

import com.smsservices.smsapp.payload.SmsRequest;
import com.smsservices.smsapp.service.TwilioSmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SmsController {

    private final TwilioSmsService twilioSmsService;

    @Autowired
    public SmsController(TwilioSmsService twilioSmsService) {
        this.twilioSmsService = twilioSmsService;
    }

    @PostMapping("/send-sms")
    public void sendSms(@RequestBody SmsRequest smsRequest) {
        twilioSmsService.sendSms(smsRequest.getToPhoneNumber(), smsRequest.getMessage());
    }
}
