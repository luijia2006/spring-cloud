package com.example.rabbitmqhello.service;

import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Sender {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(Sender.class);

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send() {
        String content = "hello" + new Date();
        logger.info("sender : "+ content);
        this.rabbitTemplate.convertAndSend("hello",content);
    }
}
