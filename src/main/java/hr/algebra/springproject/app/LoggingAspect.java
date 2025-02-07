package hr.algebra.springproject.app;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspect {

    Logger logger = Logger.getLogger(getClass().getName());

    @Around("execution(* hr.algebra.springproject.controller.CarController.*(..))")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long executionTime = System.currentTimeMillis() - startTime;
        System.out.println("AOP method 1 called");
        logger.info(joinPoint.getSignature() + " executed in " + executionTime + "ms");
        return proceed;
    }

    @Before("execution(* hr.algebra.springproject.controller.CarController.*(..)) && args(..,args)")
    public void logMethodArguments(JoinPoint joinPoint, Object args) {
        System.out.println("AOP method 2 called");
        logger.info("Method " + joinPoint.getSignature() + " called with arguments: " + Arrays.toString(joinPoint.getArgs()));
    }
}
