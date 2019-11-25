package ru.otus.spring01.service;

import ru.otus.spring01.dao.QuestionDao;
import ru.otus.spring01.domain.Question;
import ru.otus.spring01.domain.Student;
import ru.otus.spring01.domain.StudentTest;

import java.util.List;
import java.util.Scanner;

public class StudentTestServiceImpl implements StudentTestService {

    private QuestionDao questionDao;

    public StudentTestServiceImpl(QuestionDao questionDao) {
        this.questionDao = questionDao;
    }

    public void startTest() {
        Scanner in = new Scanner(System.in);
        System.out.println("==== Начинаем тест ====");
        List<Question> questions = questionDao.getAll();
        System.out.println("Введите имя: ");
        String firstName = in.nextLine();
        System.out.println("Введите фамилию: ");
        String secondName = in.nextLine();
        Student student = new Student(firstName,secondName);
        StudentTest studentTest = new StudentTest(student, questions);
    }
}
