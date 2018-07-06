package com.example.helloserviceapi.service;

import com.example.helloserviceapi.dto.RefactorUser;
import org.springframework.web.bind.annotation.*;

@RequestMapping("refactor")
public interface HelloService {

	@RequestMapping(value = "/hello4",method = RequestMethod.GET)
	String hello4(@RequestParam("name") String name) ;

	@RequestMapping(value = "/hello5",method = RequestMethod.GET)
	RefactorUser hello5(@RequestHeader("name") String name, @RequestHeader("age") Integer age);

	@RequestMapping(value = "/hello6",method = RequestMethod.POST)
	String hello6(@RequestBody RefactorUser refactorUser);
}
