package net.seyfe.waamainlab.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerAspect {

//    @Pointcut("execution(* net.seyfe.waalab04.controller.UserController.getUsers())")
//    public void logMe(){
//
//    }
//    @Pointcut("@annotation(net.seyfe.waalab04.aspect.annotation.LogMe)")
//    public void logMeAnnotation(){
//
//    }
//
//    @Before("logMe() || logMeAnnotation()")
//    public void logBefore(JoinPoint joinPoint){
//        System.out.println("Logging before the method: " + joinPoint.getSignature().getName());
//    }
//
//    @AfterReturning("logMe()")
//    public void logAfterReturning(JoinPoint joinPoint){
//        System.out.println("Logging after returning from the method: " + joinPoint.getSignature().getName());
//    }
//
//    @After("logMe() || logMeAnnotation()")
//    public void logAfter(JoinPoint joinPoint){
//        System.out.println("Logging after the method: " + joinPoint.getSignature().getName());
//    }

//    @Around("logMe()")
//    public void logAround(JoinPoint joinPoint){
//        System.out.println("Logging seyfe the method: " + joinPoint.getSignature().getName());
//    }

//    @Around("logMe()")
//    public void logAroundProceeding(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
//        System.out.println("Logging around before the method: " + proceedingJoinPoint.getSignature().getName());
//        proceedingJoinPoint.proceed();
//        System.out.println("Logging around after the method: " + proceedingJoinPoint.getSignature().getName());
//    }
}
