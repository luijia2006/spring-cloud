package com.example.feignconsumer.controller;

import com.example.feignconsumer.dto.User;
import com.example.feignconsumer.service.HelloService;
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
	private HelloService helloService;

	@RequestMapping(value = "/feign-consumer",method = RequestMethod.GET)
	public String helloConsumer() {
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
}
