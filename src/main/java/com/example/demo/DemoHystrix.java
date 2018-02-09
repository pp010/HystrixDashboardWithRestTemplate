package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Component
public class DemoHystrix {
	
	@Autowired
	RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "fallback")
	public String checkzuul() {
		return restTemplate.getForObject("http://localhost:8080/checkzuul", String.class);
	}
	
	@HystrixCommand(fallbackMethod = "fallback")
	public String checkerror() {
		return restTemplate.getForObject("http://localhost:8080/checkerror", String.class);
	}
	
	public String fallback() {
		return "fallback";
	}

}
