package com.bell.ssm.confg;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * @Configuration
 * 	标注这个类型是一个配置类
 * @ComponentScan
 * 	配置spring的扫包，将添加了注解的类加入IOC容器中
 * 
 * extends WebMvcConfigurationSupport 继承这个WebMvcConfigurationSupport类是为了个springmvc添加配置
 * 
 * @author bell.zhouxiaobing
 *
 */
@Configuration
@ComponentScan(basePackages = {"com.bell.ssm"})
@EnableWebMvc
public class WebMvcConfig extends WebMvcConfigurationSupport{
	
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
		internalResourceViewResolver.setPrefix("/WEB-INF/pages/");
		internalResourceViewResolver.setSuffix(".jsp");
		return internalResourceViewResolver;
	}
	
	
}
