package com.md.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.md.demo.service.DemoService;

/**
 * 任务中心1
 * 
 * @author Minbo.He
 *
 */
@Component//泛指各种组件，就是说当我们的类不属于各种归类的时候,使用@Component来标注这个类。
public class ScheduledTasks {

	protected static Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);
	
	@Autowired
	private DemoService service;

	/*
	 * 一般用法详解
	 * 
	 * initialDelay表示一个初始延迟时间，第一次被调用前延迟的时间 
	 * fixedDelay表示一个固定延迟时间执行，上个任务完成后,延迟多久执行
	 */

	// 启动立即执行
	// 每5秒执行一次 是表示上次任务执行完毕后的5秒再执行
	@Scheduled(initialDelay = 1000, fixedDelay = 5000) //@Scheduled 配置具体任务的执行方式和时间
	public void test1() {
		logger.info("test1这里，每5秒执行一次。DemoService --->>> " + this.service.sayHello());
	}

	// 每5秒执行一次  fixedRate 已经划分好了执行时间，每5秒立即执行
	@Scheduled(initialDelay = 1000, fixedRate = 5000)
	public void test2() {
		logger.info("test2这里，每5秒执行一次");
	}

	
//	Cron表达式用法：秒 分 时 日 月 周
//	比如：
//		每5秒执行一次：*/5 * * * * *
//		每30分钟执行一次：* */30 * * * *
//		每1小时执行一次：* * */1 * * *
//		每天2点执行一次：* * 2 * * *
	
	// 固定时间才执行，即为10秒的整数倍执行，比如20秒，30秒，40秒时，会执行
	// 每10秒执行一次
	@Scheduled(cron = "*/10 * * * * *")     //根据cron表达式来执行任务
	public void test3() {
		logger.info("test3这里，每10秒执行一次");
	}
	
}