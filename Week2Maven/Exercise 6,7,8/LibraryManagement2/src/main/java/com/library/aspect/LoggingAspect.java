package com.library.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    // Advice that runs before the execution of any method in BookService
    @Before("execution(* com.library.BookService.*(..))")
    public void logBefore() {
        System.out.println("LoggingAspect: Before method execution");
    }

    // Advice that runs after the execution of any method in BookService
    @After("execution(* com.library.BookService.*(..))")
    public void logAfter() {
        System.out.println("LoggingAspect: After method execution");
    }
}
