package com.example.feignconsumer.service;

import com.example.feignconsumer.dto.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("hello-service")
public interface HelloService {

	@RequestMapping("/hello")
	public String hello();

	@RequestMapping("/hello1")
	public String hello1(@RequestParam("name") String name) ;

	@RequestMapping("/hello2")
	public User hello2(@RequestHeader("name") String name, @RequestHeader("age") Integer age);


	@RequestMapping("/hello3")
	public String hello3(@RequestBody User user);
}
