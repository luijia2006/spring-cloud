package com.example.ribbonconsumer.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {
    private static final Logger logger = LoggerFactory.getLogger(HelloService.class);
    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "helloFallback")
    public String helloService(){
        long startTime=System.currentTimeMillis();
        String body = restTemplate.getForEntity("http://HELLO-SERVICE/hello", String.class).getBody();
        long endTime=System.currentTimeMillis();
        logger.info("spend time:"+(endTime-startTime));
        return body;
    }

    public String helloFallback(){
        return "error";
    }
}
