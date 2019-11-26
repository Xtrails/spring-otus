package ru.otus.spring01.service;

import java.util.Locale;

public interface LocalizationService {
    String getLocalizationPath(Locale country);
}
