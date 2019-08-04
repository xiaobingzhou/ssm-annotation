package com.bell.ssm.confg;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * @EnableWebMvc
 * 	启用springmvc的配置
 * @PropertySource
 * 	导入外部配置文件
 * @MapperScan
 * 	mybatis的扫包路径，mapper接口
 * 
 * @author bell.zhouxiaobing
 *
 */
@Configuration
@MapperScan(basePackages = "com.bell.ssm.mapper")
@PropertySource(value="classpath:jdbc.properties", encoding="UTF-8")
@EnableTransactionManagement
@EnableAspectJAutoProxy
public class MybatisConfig {
	
	@Value("${jdbc.url}")
	private String url;
	@Value("${jdbc.username}")
	private String username;
	@Value("${jdbc.password}")
	private String password;
	
	@Bean
	public DataSource dataSource() {
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		return dataSource;
	}
	
	@Bean
	public DataSourceTransactionManager dataSourceTransactionManager() {
		DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
		dataSourceTransactionManager.setDataSource(dataSource());
		return dataSourceTransactionManager;
	}
	
	@Bean
	public SqlSessionFactoryBean sqlSessionFactoryBean() {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(dataSource());
		bean.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
		return bean;
	}
	
}
