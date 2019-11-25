package ru.otus.spring01;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.spring01.dao.QuestionDao;
import ru.otus.spring01.domain.Question;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
//        PersonService s = context.getBean(PersonService.class);
        QuestionDao questionDao = context.getBean(QuestionDao.class);
        List<Question> questions = questionDao.getAll();
    }
}
