package com.smsservices.smsapp.controller;

import com.smsservices.smsapp.payload.SmsRequest;
import com.smsservices.smsapp.service.TwilioSmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SmsController {

    private final TwilioSmsService twilioSmsService;

    @Autowired
    public SmsController(TwilioSmsService twilioSmsService) {
        this.twilioSmsService = twilioSmsService;
    }

    @PostMapping("/send-sms")
    public ResponseEntity<String> sendSms(@RequestBody SmsRequest smsRequest) {
        try {
            twilioSmsService.sendSms(smsRequest);
            return new ResponseEntity<>("SMS sent successfully.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to send SMS: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
