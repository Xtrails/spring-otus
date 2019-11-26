package ru.otus.spring01.domain;

import java.util.List;

public class Question {

    public Question(String text, List<String> answerOptions) {
        this.text = text;
        this.answerOptions = answerOptions;
    }

    private String text;
    private List<String> answerOptions;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<String> getAnswerOptions() {
        return answerOptions;
    }

    public void setAnswerOptions(List<String> answerOptions) {
        this.answerOptions = answerOptions;
    }
}
