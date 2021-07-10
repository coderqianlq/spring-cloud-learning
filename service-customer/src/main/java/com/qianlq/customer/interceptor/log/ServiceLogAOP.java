package com.qianlq.customer.interceptor.log;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * 日志切面
 */
@Component
@Aspect
public class ServiceLogAOP {

    private final Logger LOGGER = LogManager.getLogger(ServiceLogAOP.class);

    @Pointcut("execution(public * com.qianlq.customer.service.impl.*.*(..))")
    public void logTarget() {
    }

    @Around("logTarget()")
    public Object serviceThreadLocalHandle(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        String methodName = method.getName();
        Parameter[] parameters = method.getParameters();
        String targetClassName = joinPoint.getTarget().getClass().getName();
        Object[] args = joinPoint.getArgs();
        LOGGER.info("className: {}, methodName: {}", targetClassName, methodName);
        if (args != null && args.length > 0) {
            for (int i = 0; i < args.length; i++) {
                LOGGER.info("{}: {}: {}", parameters[i].getName(), parameters[i].getType().getName(), args[i]);
            }
        }
        return joinPoint.proceed();
    }
}
