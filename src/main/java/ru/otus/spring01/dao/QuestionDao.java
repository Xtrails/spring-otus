package ru.otus.spring01.dao;

import ru.otus.spring01.domain.Question;

import java.util.List;
import java.util.Locale;

public interface QuestionDao {
    List<Question> getAll(Locale country);
}
