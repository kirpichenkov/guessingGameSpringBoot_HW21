package ru.LearnUp.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

//import java.util.logging.Logger;

@Aspect
@Component
public class MyAspectWorkTime {
    private long startMethod;
    private long endMethod;
    private static final Logger log = (Logger) LoggerFactory.getLogger(MyAspectWorkTime.class);
    private JoinPoint joinPoint;
    @Pointcut(value="@annotation(ru.LearnUp.anotation.WorkTime)")
    public void collIn(){

    }
    @Before("collIn()")
    public void BeforeAnnotation(@NotNull JoinPoint joinPoint) {
        this.joinPoint = joinPoint;
        startMethod = System.currentTimeMillis();
    }
    @After("collIn()")
    public void AfterAnnotation(JoinPoint joinPoint){
        this.joinPoint = joinPoint;
        endMethod = System.currentTimeMillis();
        String nameMethod = joinPoint.getSignature().getName();
        log.info("Время работы: {} {}", nameMethod, endMethod - startMethod);
    }
}

