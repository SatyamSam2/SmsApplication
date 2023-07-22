package com.smsservices.smsapp.service;

import com.smsservices.smsapp.payload.SmsRequest;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TwilioSmsService {

    @Value("${twilio.phone.number}")
    private String twilioPhoneNumber;

    public void sendSms(SmsRequest smsRequest) {
        Message.creator(
                new PhoneNumber(smsRequest.getToPhoneNumber()),
                new PhoneNumber(twilioPhoneNumber),
                smsRequest.getMessage()
        ).create();
    }
}

