package id.co.diansetiyadi.smsservice.service;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SMSService {
    
    public void sendSMS(String message) {
      
        log.info("Send SMS : {}", message);
    }
}
