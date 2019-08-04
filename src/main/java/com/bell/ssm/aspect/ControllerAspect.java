package com.bell.ssm.aspect;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import com.bell.ssm.dto.RestResult;

@Aspect
@Component
public class ControllerAspect {
	
	private static final Logger logger = Logger.getLogger(ControllerAspect.class);
	
	@Around(value = "execution(public com.bell.ssm.dto.RestResult com.bell.ssm.controller.rest.*.*(..))")
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		long b = System.currentTimeMillis();
		try {
			Object proceed = pjp.proceed();
			long a = System.currentTimeMillis();
			logger.debug(getMethod(pjp).getName()+" use tims "+(a-b)+"ms");
			return proceed;
		} catch (Exception e) {
			return exceptionHandler(pjp, e);
		}
	}

	private Object exceptionHandler(ProceedingJoinPoint pjp, Exception e) {
		// handler Exception
		
		return RestResult.error(e);
	}

	private Method getMethod(ProceedingJoinPoint pjp) {
		MethodSignature methodSignature = getMethodSignature(pjp);
		Method method = methodSignature.getMethod();
		return method;
	}

	private MethodSignature getMethodSignature(ProceedingJoinPoint pjp) {
		MethodSignature methodSignature = (MethodSignature)pjp.getSignature();
		return methodSignature;
	}

	
}
