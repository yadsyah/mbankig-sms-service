package id.co.diansetiyadi.smsservice.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

import id.co.diansetiyadi.smsservice.service.SMSService;
import id.co.diansetiyadi.smsservice.util.SMSConstant;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class SMSConsumer {


    private final SMSService service;
    private final Gson gson;
    @Autowired
    public SMSConsumer(SMSService service, Gson gson) {
        this.service = service;
        this.gson = gson;
    }

    @KafkaListener(topics = SMSConstant.TOPIC_NOTIFICATION_SMS, groupId = "notification")
    public void consumeMessagesSMS(String message) {

        log.info("Consume Kafka : {}", gson.toJson(message));
        service.sendSMS(message);
    }

    

    
}
