package ru.otus.spring01;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import ru.otus.spring01.dao.QuestionDao;
import ru.otus.spring01.domain.Question;
import ru.otus.spring01.service.StudentTestService;

import java.util.List;
import java.util.Locale;

@ComponentScan(basePackages = "ru.otus.spring01")
@Configuration
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(Main.class);
        context.refresh();
        StudentTestService studentTestService = context.getBean(StudentTestService.class);
        studentTestService.startTest(Locale.ENGLISH);
    }
}
