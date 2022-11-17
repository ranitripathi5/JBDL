package org.GeeksForGeeks.kafkaExample.ApacheKafkaProducerController.java;

import org.GeeksForGeeks.kafkaExample.services.java.KafkaSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/api-for-kafka")
public class ApacheKafkaProducerController {

    @Autowired
    KafkaSender kafkaSender;

    @GetMapping(value="/producer")
    public String producer(@RequestParam("message")String message){
        // will msg to kafka topic
        kafkaSender.send(message);
        return "Message sent to the kafka topic hello-world successfully:";
    }
}
