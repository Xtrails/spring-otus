package ru.otus.spring01.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@PropertySource("application.properties")
public class LocalizationServiceImpl implements LocalizationService {

    @Value("${bundle.pattern}")
    private String bundlePattern;

    @Value("${message.names}")
    private String[] messageNames;

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

    public Map<String,String> getMessages(Locale country){
        Map<String,String> messages = new HashMap<>();
        ResourceBundle resourceBundle = getResourceBundle(country);
        for (String messageName : messageNames) {
            messages.put(messageName, resourceBundle.getString(messageName));
        }
        return messages;
    }

    private ResourceBundle getResourceBundle(Locale country){
        return ResourceBundle.getBundle(bundlePattern, country);
    }
}
