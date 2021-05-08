package com.pfm.Spring_Backend.aop;

import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

@Aspect
@Component
public class ParameterAop {

    @Pointcut("execution(* com.pfm.Spring_Backend.controller..*.*(..))")
    private void cut() {
    }

    @Before("cut()")
    private void before(JoinPoint joinPoint) {

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        System.out.println(method);

        Object[] args = joinPoint.getArgs();

        for (Object obj : args) {
            System.out.println("type : " + obj.getClass().getSimpleName());
            System.out.println("value : " + obj);
        }
    }

    @AfterReturning(value = "cut()", returning = "returnObj")
    private void AfterReturn(JoinPoint jointPoint, Object returnObj) {
        System.out.println("return obj");
        System.out.println(returnObj);
    }

}
