package ru.otus.spring01.dao;

import com.opencsv.CSVReader;
import ru.otus.spring01.domain.Question;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuestionDaoImpl implements QuestionDao {

    public List<Question> getAll() {
        List<Question> questions = new ArrayList<>();
        File file = new File(
                getClass().getClassLoader().getResource("questions.csv").getFile()
        );
        try (CSVReader csvReader = new CSVReader(new FileReader(file));) {
            String[] values = null;
            while ((values = csvReader.readNext()) != null) {
                questions.add(valuesToQuestion(values));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return questions;
    }

    private Question valuesToQuestion(String[] values) {
        if (values.length == 3) {
            List<String> answers = new ArrayList<>();
            answers.add(values[1]);
            answers.add(values[2]);
            return new Question(values[0], answers);
        }
        return null;
    }
}
