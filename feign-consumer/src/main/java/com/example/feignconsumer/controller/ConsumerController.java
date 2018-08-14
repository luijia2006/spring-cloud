package com.example.feignconsumer.controller;

import com.example.feignconsumer.dto.User;
import com.example.feignconsumer.service.RefactorHelloService;
import com.example.helloserviceapi.dto.RefactorUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

	private static final Logger logger = LoggerFactory.getLogger(ConsumerController.class);
	@Autowired
	private com.example.feignconsumer.service.HelloService helloService;

	@Autowired
	private RefactorHelloService refactorHelloService;

	@RequestMapping(value = "/feign-consumer",method = RequestMethod.GET)
	public String helloConsumer() {
		logger.info("========call trace-1========");
		return helloService.hello();
	}

	@RequestMapping(value = "/feign-consumer2",method = RequestMethod.GET)
	public String helloConsumer2() {
		StringBuffer sb=new StringBuffer();
		sb.append(helloService.hello()).append("\n");
		sb.append(helloService.hello1("liujian")).append("\n");
		sb.append(helloService.hello2("liujian",30)).append("\n");
		sb.append(helloService.hello3(new User("liujian",30))).append("\n");
		return sb.toString();
	}
	@RequestMapping(value = "/feign-consumer3",method = RequestMethod.GET)
	public String helloConsumer3() {
		StringBuffer sb=new StringBuffer();
		sb.append(refactorHelloService.hello4("liujian")).append("\n");
		sb.append(refactorHelloService.hello5("liujian",30)).append("\n");
		sb.append(refactorHelloService.hello6(new RefactorUser("liujian",30))).append("\n");
		return sb.toString();
	}
}
