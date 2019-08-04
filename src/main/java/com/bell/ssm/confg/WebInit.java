package com.bell.ssm.confg;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebInit implements WebApplicationInitializer{

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		System.out.println("[WebInit] onStartup...");
		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		ctx.register(WebMvcConfig.class);
		ctx.setServletContext(servletContext);
		
		Dynamic addServlet = servletContext.addServlet("dispatcherServlet", new DispatcherServlet(ctx));
		addServlet.setLoadOnStartup(1);
		addServlet.addMapping("/");
		System.out.println("[WebInit] onStartup...ok");
	}

}
