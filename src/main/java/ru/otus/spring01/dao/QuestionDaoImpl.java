package ru.otus.spring01.dao;

import com.opencsv.CSVReader;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import ru.otus.spring01.domain.Question;
import ru.otus.spring01.service.LocalizationService;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

@Service
public class QuestionDaoImpl implements QuestionDao {

    private final LocalizationService localizationService;

    public QuestionDaoImpl(LocalizationService localizationService) {
        this.localizationService = localizationService;
    }

    public List<Question> getAll(Locale country) {
        String path = localizationService.getLocalizationPath(country);
        List<Question> questions = new ArrayList<>();
        File file = new File(
                getClass().getClassLoader().getResource(path).getFile()
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
