package com.lazulite.ddcallback.web.rest;

import com.lazulite.ddcallback.service.DdCallbackKafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/dd-callback-kafka")
public class DdCallbackKafkaResource {

    private final Logger log = LoggerFactory.getLogger(DdCallbackKafkaResource.class);

    private DdCallbackKafkaProducer kafkaProducer;

    public DdCallbackKafkaResource(DdCallbackKafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/publish")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
        log.debug("REST request to send to Kafka topic the message : {}", message);
        this.kafkaProducer.send(message);
    }
}
