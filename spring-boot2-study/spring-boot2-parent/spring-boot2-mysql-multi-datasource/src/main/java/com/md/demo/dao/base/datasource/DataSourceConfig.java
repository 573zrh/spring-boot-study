package com.md.demo.dao.base.datasource;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration//@Configuration把一个类作为一个IoC容器，它的某个方法头上如果注册了@Bean，就会作为这个Spring容器中的Bean。
public class DataSourceConfig {

	@Primary//自动装配时当出现多个Bean候选者时，被注解为@Primary的Bean将作为首选者，否则将抛出异常
	@Qualifier("master")//@Qualifier注解的用处：当一个接口有多个实现的时候，为了指名具体调用哪个类的实现。
	@Bean(name = "master")//Spring的@Bean注解用于告诉方法，产生一个Bean对象，然后这个Bean对象交给Spring管理。产生这个Bean对象的方法Spring只会调用一次，随后这个Spring将会将这个Bean对象放在自己的IOC容器中
	@ConfigurationProperties(prefix = "spring.datasource.master") // application.yml中对应属性的前缀
	//注解有一个prefix属性，通过指定的前缀，绑定配置文件中的配置，该注解可以放在类上，也可以放在方法上
	//此方法相当于bean初始化的程序
	public DataSource masterDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Qualifier("slave")
	@Bean(name = "slave")
	@ConfigurationProperties(prefix = "spring.datasource.slave") // application.yml中对应属性的前缀
	public DataSource slaveDataSource() {
		return DataSourceBuilder.create().build();
	}
}