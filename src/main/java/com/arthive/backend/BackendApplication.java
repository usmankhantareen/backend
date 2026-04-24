package com.arthive.backend;

import com.arthive.backend.model.ContactMessage;
import com.arthive.backend.model.ContactStatus;
import com.arthive.backend.repository.ContactMessageRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class BackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }

    // seed a couple of contact messages on first run so the admin endpoints
    // have something to return during local testing
    @Bean
    CommandLineRunner seedData(ContactMessageRepository contactMessageRepository) {
        return args -> {
            if (contactMessageRepository.count() == 0) {
                contactMessageRepository.save(new ContactMessage(
                        null,
                        "Sara Ahmed",
                        "sara@email.com",
                        "Portfolio question",
                        "Can I feature my digital art on ArtHive?",
                        ContactStatus.NEW,
                        LocalDateTime.now().minusDays(2)
                ));

                contactMessageRepository.save(new ContactMessage(
                        null,
                        "Ali Raza",
                        "ali@email.com",
                        "Selling artwork",
                        "How do I upload and sell my first artwork?",
                        ContactStatus.READ,
                        LocalDateTime.now().minusDays(1)
                ));
            }
        };
    }
}