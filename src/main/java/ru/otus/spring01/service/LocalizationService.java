package ru.otus.spring01.service;

import java.util.Locale;
import java.util.Map;

public interface LocalizationService {
    String getLocalizationPath(Locale country);
    Map<String,String> getMessages(Locale country);
}
