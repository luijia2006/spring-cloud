package com.example.demo.controller;

import com.example.helloserviceapi.dto.RefactorUser;
import com.example.helloserviceapi.service.HelloService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RefactorHelloController implements HelloService {

	@Override
	public String hello4(@RequestParam("name") String name) {
		return "hello"+name;
	}

	@Override
	public RefactorUser hello5(@RequestHeader("name") String name, @RequestHeader("age") Integer age) {
		return new RefactorUser(name,age);
	}

	@Override
	public String hello6(@RequestBody RefactorUser refactorUser) {
		return "hello"+refactorUser.getName()+","+refactorUser.getAge();
	}
}
