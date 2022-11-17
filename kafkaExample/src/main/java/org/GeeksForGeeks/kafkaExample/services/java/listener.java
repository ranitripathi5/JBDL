package org.GeeksForGeeks.kafkaExample.services.java;

import org.apache.kafka.clients.consumer.ConsumerRecord;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class listener {

    private String topicName="hello-world-topic";

    @KafkaListener(topics="hello-world-topic",groupId = "group_id")
    public void consume(ConsumerRecord<String,String>payload){
       System.out.println("Topic Name :"+topicName);
        System.out.println("Key :"+payload.key());
       System.out.println("Headers :"+payload.headers());
       System.out.println("Partition :"+payload.partition());
        System.out.println("Data :"+payload.value());
    }

}
