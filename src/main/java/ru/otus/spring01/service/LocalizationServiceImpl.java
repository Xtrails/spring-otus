package ru.otus.spring01.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class LocalizationServiceImpl implements LocalizationService {

    @Autowired
    private MessageSource messageSource;

    @Override
    public String getLocalizationPath(Locale country) {
        if (country != null) {
            return messageSource.getMessage(
                    "file.path",
                    new String[]{},
                    country
            );
        }
        return null;
    }
}
