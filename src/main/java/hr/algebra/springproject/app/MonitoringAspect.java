package hr.algebra.springproject.app;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class MonitoringAspect {

    Logger logger = Logger.getLogger(getClass().getName());

    @AfterThrowing(pointcut = "execution(* hr.algebra.springproject.controller.CarController.*(..))", throwing = "exception")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable exception) {
        logger.info("Exception thrown in method " + joinPoint.getSignature() + ": " + exception.getMessage());
    }

    @AfterReturning("execution(* hr.algebra.springproject.controller.CarController.createCar(..))")
    public void logCarCreation(JoinPoint joinPoint) {
        logger.info("A new car has been created.");
    }

    @AfterReturning("execution(* hr.algebra.springproject.controller.CarController.updateCar(..))")
    public void logCarUpdate(JoinPoint joinPoint) {
        logger.info("A car has been updated.");
    }

    @AfterReturning("execution(* hr.algebra.springproject.controller.CarController.deleteCarById(..)) || execution(* hr.algebra.springproject.controller.CarController.deleteCar(..))")
    public void logCarDelete(JoinPoint joinPoint) {
        logger.info("A car has been deleted.");
    }
}