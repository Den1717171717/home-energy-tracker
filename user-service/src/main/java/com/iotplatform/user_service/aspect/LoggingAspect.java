package com.iotplatform.user_service.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

    @Pointcut("execution(* com.iotplatform.user_service.service.*.*(..))")
    public void serviceMethods() {
    }

    @Before("serviceMethods()")
    public void logBefore(JoinPoint point) {
        log.info("Executing {}" , point.getSignature().toShortString());
    }

    @AfterReturning(pointcut = "serviceMethods()" , returning = "result")
    public void logAfter(JoinPoint point, Object result) {
        log.info("Service method returned: {}", result);
    }



}
