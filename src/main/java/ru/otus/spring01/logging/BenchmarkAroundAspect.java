package ru.otus.spring01.logging;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;

@Aspect
@Component
public class BenchmarkAroundAspect {
    @Around("@annotation(ru.otus.spring01.logging.annotation.Benchmark)")
    public Object benchmark(ProceedingJoinPoint joinPoint) {
        Instant start = Instant.now();
        Object result = null;
        try {
            result = joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        Instant end = Instant.now();
        System.out.println("Время выполнения метода " + joinPoint.getSignature() + ": " + Duration.between(start, end));
        return result;
    }
}
