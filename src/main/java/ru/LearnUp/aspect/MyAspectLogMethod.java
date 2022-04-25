package ru.LearnUp.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.jetbrains.annotations.NotNull;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;

import java.util.Arrays;
//import java.util.logging.Logger;

@Component
@Aspect

public class MyAspectLogMethod {
    private static final Logger log = LoggerFactory.getLogger(MyAspectLogMethod.class);
    private JoinPoint joinPoint;

    @Pointcut("execution(* ru.LearnUp.event.*.*(*))")
    public void collIn(){

    }

    @Before("@annotation(ru.LearnUp.anotation.LogMethod)")
    public void BeforeAnotation(@NotNull JoinPoint joinPoint){
        this.joinPoint = joinPoint;
        log.info("имя метода:{}", joinPoint.getSignature().getName());
        log.info("параметры метода: {}", Arrays.stream(joinPoint.getArgs()).toArray());
        log.info("возвращаемое значение: {}", joinPoint.getTarget());

    }
}
