package com.example.howIsIt.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.FileInputStream;
import java.io.IOException;

@Configuration
public class FirebaseConfig {
    @Bean
    public FirebaseAuth firebaseAuth() throws IOException {
        GoogleCredentials credentials = GoogleCredentials
                .fromStream(new FileInputStream("portfolier-itstime-firebase-adminsdk-ojcc7-0872e42441.json"));
        FirebaseOptions options = FirebaseOptions.builder()
                .setCredentials(credentials)
                .build();
        if (FirebaseApp.getApps().isEmpty()) { // <== FirebaseApp이 이미 초기화되었는지 확인
            FirebaseApp.initializeApp(options);
        }
        return FirebaseAuth.getInstance();
    }
}
