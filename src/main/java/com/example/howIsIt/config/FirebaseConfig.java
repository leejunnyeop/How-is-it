package com.example.howIsIt.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.FileInputStream;
import java.io.IOException;

import static com.mysql.cj.conf.PropertyKey.logger;

@Configuration
public class FirebaseConfig {
    @Bean
    public FirebaseAuth firebaseAuth() throws IOException {
        logger.toString();
        try {
            String firebaseKeyPath = "/run/secrets/service_account_key3";
            GoogleCredentials credentials = GoogleCredentials
                    .fromStream(new FileInputStream(firebaseKeyPath));
            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(credentials)
                    .build();
            if (FirebaseApp.getApps().isEmpty()) {
                FirebaseApp.initializeApp(options);
            }
            return FirebaseAuth.getInstance();

        } catch (IOException e) {
            throw e;
        }
    }
}
