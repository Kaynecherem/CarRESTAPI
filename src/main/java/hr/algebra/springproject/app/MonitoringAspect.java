package hr.algebra.springproject.app;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MonitoringAspect {

    @AfterThrowing(pointcut = "execution(* hr.algebra.springproject.controller.CarController.*(..))", throwing = "exception")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable exception) {
        System.out.println("Exception thrown in method " + joinPoint.getSignature() + ": " + exception.getMessage());
    }

    @AfterReturning("execution(* hr.algebra.springproject.controller.CarController.createCar(..))")
    public void logCarCreation(JoinPoint joinPoint) {
        System.out.println("A new car has been created.");
    }

    @AfterReturning("execution(* hr.algebra.springproject.controller.CarController.updateCar(..))")
    public void logCarUpdate(JoinPoint joinPoint) {
        System.out.println("A car has been updated.");
    }

    @AfterReturning("execution(* hr.algebra.springproject.controller.CarController.deleteCarById(..)) || execution(* hr.algebra.springproject.controller.CarController.deleteCar(..))")
    public void logCarDelete(JoinPoint joinPoint) {
        System.out.println("A car has been deleted.");
    }
}