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
 * @author CoderQian
 * @date 2018-09-28 下午2:29
 * @concat <a href="mailto:qianlq0824@gmail.com">qianlq0824@gmail.com</a>
 * <p>
 * 日志切面
 */

@Component
@Aspect
public class ServiceLogAOP {

    private static Logger logger = LogManager.getLogger(ServiceLogAOP.class);

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
        logger.info("className: {}, methodName: {}", targetClassName, methodName);
        if (args != null && args.length > 0) {
            for (int i = 0; i < args.length; i++) {
                logger.info("{}: {}: {}", parameters[i].getName(), parameters[i].getType().getName(), args[i]);
            }
        }
        return joinPoint.proceed();
    }
}
