package com.example.apigateway;

import com.example.apigateway.filter.AccessFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.SearchStrategy;
import org.springframework.boot.autoconfigure.web.DefaultErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@EnableZuulProxy
@SpringBootApplication
public class ApiGatewayApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(ApiGatewayApplication.class).web(true).run(args);
//		SpringApplication.run(ApiGatewayApplication.class, args);
	}
	@Bean
	public AccessFilter accessFilter() {
		return new AccessFilter();
	}

}
