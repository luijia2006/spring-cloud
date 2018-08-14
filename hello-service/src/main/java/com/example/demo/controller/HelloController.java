package com.example.demo.controller;

import com.example.demo.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
public class HelloController {

	private static final Logger logger = LoggerFactory.getLogger(HelloController.class);
	@Autowired
	private DiscoveryClient client;

	@RequestMapping("/hello")
	public String hello() throws Exception {
		logger.info("========call trace-2========");
		ServiceInstance instance = client.getLocalServiceInstance();
		//让处理线程睡眠几秒
		/*int sleepTime=new Random().nextInt(3000);
		logger.info("sleepTime:"+sleepTime);
		Thread.sleep(sleepTime);*/
		logger.info("/hello,host:"+instance.getHost()+",server_id:"+instance.getServiceId());
		return "hello world";
	}

	@RequestMapping("/hello1")
	public String hello1(@RequestParam String name) {
		return "hello "+name;
	}

	@RequestMapping("/hello2")
	public User hello2(@RequestHeader String name,@RequestHeader Integer age) throws Exception {
		return new User(name,age);
	}


	@RequestMapping("/hello3")
	public String hello3(@RequestBody User user) throws Exception {
		return "hello "+user.getName()+","+user.getAge();
	}
}
