package ru.otus.spring01.service;

import org.springframework.stereotype.Service;
import ru.otus.spring01.dao.QuestionDao;
import ru.otus.spring01.domain.Question;
import ru.otus.spring01.domain.Student;
import ru.otus.spring01.domain.StudentTest;

import java.util.*;

@Service
public class StudentTestServiceImpl implements StudentTestService {

    private final QuestionDao questionDao;
    private final LocalizationService localizationService;

    private Map<String, String> messages = new HashMap<>();

    public StudentTestServiceImpl(QuestionDao questionDao, LocalizationService localizationService) {
        this.questionDao = questionDao;
        this.localizationService = localizationService;
    }

    public void startTest(Locale country) {
        if (country != null) {
            messages = localizationService.getMessages(country);
            if (messages != null && !messages.isEmpty()) {
                Scanner in = new Scanner(System.in);
                System.out.println("==== " + messages.get("msg.startTest") + " ====");
                List<Question> questions = questionDao.getAll(country);
                System.out.println(messages.get("msg.firstName") + ": ");
                String firstName = in.nextLine();
                System.out.println(messages.get("msg.secondName") + ": ");
                String secondName = in.nextLine();
                Student student = new Student(firstName, secondName);
                StudentTest studentTest = new StudentTest(student, questions);
                compliteAnswers(studentTest);
                studentTest.printAnswers();
            }
        }
    }

    private void compliteAnswers(StudentTest studentTest) {
        for (Question question : studentTest.getQuestions()) {
            int answer = 0;
            System.out.println(question.getText());
            System.out.println(messages.get("msg.chooseAnswer") + ":");
            for (int i = 0; i < question.getAnswerOptions().size(); i++) {
                System.out.println("  " + i + ": " + question.getAnswerOptions().get(i));
            }
            Scanner in = new Scanner(System.in);
            answer = in.nextInt();
            String answerStr = question.getAnswerOptions().get(answer);
            if (answerStr != null && !answerStr.isEmpty()) {
                studentTest.getAnswers().put(question, answerStr);
            }
        }
    }
}
