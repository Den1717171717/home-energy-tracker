package com.iotplatform.user_service.aspect;


import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Aspect
@Component
@Slf4j
public class ExecutionTimeAspect {



    @Pointcut("execution(* com.iotplatform.user_service.controller.*.*(..))")
    public void controllerMethods() {
    }

    @SneakyThrows
    @Around("controllerMethods()")
    public Object measureExecutionTime(ProceedingJoinPoint point)
    {
        long startTime = System.currentTimeMillis();

        try{
            return point.proceed();

        }
        finally {
            long end = System.nanoTime();
            long elapsedTime = end - startTime;
            long elapsedMs = TimeUnit.NANOSECONDS.toMillis(elapsedTime);
            String signature = point.getSignature().toShortString();
            log.info("Execution time for {}: {} ms", signature, elapsedMs);


        }
    }


}
