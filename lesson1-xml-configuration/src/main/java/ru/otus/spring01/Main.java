package ru.otus.spring01;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.spring01.dao.QuestionDao;
import ru.otus.spring01.domain.Question;
import ru.otus.spring01.service.StudentTestService;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
//        PersonService s = context.getBean(PersonService.class);
        StudentTestService studentTestService = context.getBean(StudentTestService.class);
        studentTestService.startTest();
    }
}
