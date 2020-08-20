package com.md.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 程序主入口
 * 
 * @author Minbo.He
 *
 */
@SpringBootApplication
@EnableScheduling//开启定时任务，扫描所有启动项
@EnableAsync//开启异步支持
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
}
