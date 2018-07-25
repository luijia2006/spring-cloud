package com.example.apigatewaydynamicfilter;

import com.example.apigatewaydynamicfilter.conf.FilterConfiguration;
import com.netflix.zuul.FilterFileManager;
import com.netflix.zuul.FilterLoader;
import com.netflix.zuul.groovy.GroovyCompiler;
import com.netflix.zuul.groovy.GroovyFileFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import java.net.URL;

@EnableZuulProxy
@EnableConfigurationProperties(FilterConfiguration.class)
@SpringBootApplication
public class ApiGatewayDynamicFilterApplication {
	private static final Logger logger = LoggerFactory.getLogger(ApiGatewayDynamicFilterApplication.class);

	public static void main(String[] args) {
		new SpringApplicationBuilder(ApiGatewayDynamicFilterApplication.class).web(true).run(args);
//		SpringApplication.run(ApiGatewayDynamicFilterApplication.class, args);
	}

	@Bean
	public FilterLoader filterLoader(FilterConfiguration filterConfiguration) {
		FilterLoader filterLoader = FilterLoader.getInstance();
		filterLoader.setCompiler(new GroovyCompiler());
		FilterFileManager.setFilenameFilter(new GroovyFileFilter());
		try {
			logger.info("root=============="+filterConfiguration.getRoot());
			FilterFileManager.init(
                    filterConfiguration.getInterval(),
                    filterConfiguration.getRoot()+"/pre",
                    filterConfiguration.getRoot()+"/post");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return filterLoader;
	}
}
