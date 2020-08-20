package com.md.demo;

import java.util.concurrent.Executors;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

/**
 * 并行多线程任务功能（方式一）
 * 
 * @author Minbo.He
 */
@Configuration//有些配置类需要随项目启动就加载，@Configuration用于定义配置类，可替换xml配置文件  @Configuation等价于<Beans></Beans> https://www.cnblogs.com/duanxz/p/7493276.html
public class ScheduleConfig implements SchedulingConfigurer { //@Schedule 注解有一个缺点，其定时的时间不能动态的改变，而基于 SchedulingConfigurer 接口的方式可以做到。 如果想要实现可以动态修改的定时策略，建议使用开源组件 Quartz。

	@Override
	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {//ScheduledTaskRegistrar 这个类里方法很多
		// 开启一个固定10个大小的线程池，也使用Executors下其他的线程池
		taskRegistrar.setScheduler(Executors.newScheduledThreadPool(10));
	}
}