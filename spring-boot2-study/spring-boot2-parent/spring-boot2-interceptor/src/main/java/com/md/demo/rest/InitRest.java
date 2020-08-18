package com.md.demo.rest;

import com.md.demo.service.DemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Minbo
 */
@RestController
public class InitRest {

	protected static Logger logger = LoggerFactory.getLogger(InitRest.class);

	@Autowired
	private DemoService demoService;

	@GetMapping("/hello")
	public String hello() {
		String sayHello = demoService.sayHello();
		return sayHello;
	}
	
	@GetMapping("/getUserInfo")
	public String getUserInfo(String userId) {
		return "getUserInfo from userId=" + userId;
	}
}