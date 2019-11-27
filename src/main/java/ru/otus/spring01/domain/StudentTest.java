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
