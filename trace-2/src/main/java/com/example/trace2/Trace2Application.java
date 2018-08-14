package com.example.trace2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@EnableDiscoveryClient
@SpringBootApplication
@Slf4j
public class Trace2Application {

	public static void main(String[] args) {
		SpringApplication.run(Trace2Application.class, args);
	}

	@RequestMapping(value = "/trace-2",method = RequestMethod.GET)
	public String trace(HttpServletRequest request){
		log.info("=====<call trace-2,TraceId={},SpanId={}>=====",
				request.getHeader("X-B3-TraceId"),request.getHeader("X-B3-SpanId"));
		return "Trace";
	}

}
