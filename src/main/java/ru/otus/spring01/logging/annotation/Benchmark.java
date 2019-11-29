package ru.otus.spring01.logging.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Component
@Target({ElementType.METHOD})
public @interface Benchmark {
}
