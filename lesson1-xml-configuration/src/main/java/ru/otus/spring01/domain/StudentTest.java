package ru.otus.spring01.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class StudentTest {

    private Student student;
    private List<Question> questions;
    private Map<Question, String> answers = new HashMap<>();

    public StudentTest(Student student, List<Question> questions) {
        this.student = student;
        this.questions = questions;
    }

    public void compliteAnswers() {
        for (Question question : questions) {
            int answer = 0;
            System.out.println(question.getText());
            System.out.println("Выберее вариант ответа:");
            for (int i = 0; i < question.getAnswerOptions().size(); i++) {
                System.out.println("  " + i + ": " + question.getAnswerOptions().get(i));
            }
            Scanner in = new Scanner(System.in);
            answer = in.nextInt();
            String answerStr = question.getAnswerOptions().get(answer);
            if(answerStr!=null && !answerStr.isEmpty()){
                answers.put(question,answerStr);
            }
        }
    }

    public void printAnswers(){
        for (Map.Entry<Question, String> entry : answers.entrySet()) {
            System.out.println(entry.getKey().getText() + " - " + entry.getValue());
        }
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Map<Question, String> getAnswers() {
        return answers;
    }

    public void setAnswers(Map<Question, String> answers) {
        this.answers = answers;
    }

    @Override
    public String toString() {
        return "StudentTest{" +
                "student=" + student +
                ", answers=" + answers +
                '}';
    }
}
