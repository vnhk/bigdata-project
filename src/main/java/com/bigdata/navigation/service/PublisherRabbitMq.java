package com.bigdata.navigation.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublisherRabbitMq {
    private RabbitTemplate rabbitTemplate;

    @Autowired
    public PublisherRabbitMq(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendData(Object object) {
        rabbitTemplate.convertAndSend("generated-data", object);
    }
}
