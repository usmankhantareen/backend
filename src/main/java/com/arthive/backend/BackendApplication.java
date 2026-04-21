package com.arthive.backend;

import com.arthive.backend.model.*;
import com.arthive.backend.repository.ArtistRepository;
import com.arthive.backend.repository.ArtworkRepository;
import com.arthive.backend.repository.ContactMessageRepository;
import com.arthive.backend.repository.TeamMemberRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@SpringBootApplication
public class BackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }

    @Bean
    CommandLineRunner seedData(
            ArtistRepository artistRepository,
            ArtworkRepository artworkRepository,
            TeamMemberRepository teamMemberRepository,
            ContactMessageRepository contactMessageRepository
    ) {
        return args -> {
            if (artistRepository.count() == 0) {
                Artist artist1 = new Artist(null, "Amina Noor", "amina@arthive.com", "Painter", "Lahore", true, LocalDateTime.now().minusDays(10));
                Artist artist2 = new Artist(null, "Bilal Raza", "bilal@arthive.com", "Photographer", "Islamabad", true, LocalDateTime.now().minusDays(8));

                artistRepository.save(artist1);
                artistRepository.save(artist2);

                artworkRepository.save(new Artwork(null, "City Echoes", "Urban acrylic piece", "Painting",
                        new BigDecimal("250.00"), "https://example.com/art1.jpg", true, LocalDateTime.now().minusDays(7), artist1));

                artworkRepository.save(new Artwork(null, "Night Market", "Street life photography", "Photography",
                        new BigDecimal("180.00"), "https://example.com/art2.jpg", true, LocalDateTime.now().minusDays(6), artist2));

                artworkRepository.save(new Artwork(null, "Silent Walls", "Mixed media artwork", "Mixed Media",
                        new BigDecimal("300.00"), "https://example.com/art3.jpg", true, LocalDateTime.now().minusDays(5), artist1));

                artworkRepository.save(new Artwork(null, "Old Streets", "Documentary photograph", "Photography",
                        new BigDecimal("210.00"), "https://example.com/art4.jpg", true, LocalDateTime.now().minusDays(4), artist2));
            }

            if (teamMemberRepository.count() == 0) {
                teamMemberRepository.save(new TeamMember(null, "Usman Khan", "Frontend Developer",
                        "Built the Home, About Us and Contact pages.", "https://example.com/usman.jpg", "https://linkedin.com/in/usman"));

                teamMemberRepository.save(new TeamMember(null, "Dimitri", "Project Contributor",
                        "Worked on startup planning and page feedback.", "https://example.com/dimitri.jpg", "https://linkedin.com/in/dimitri"));

                teamMemberRepository.save(new TeamMember(null, "Hassan", "Project Contributor",
                        "Worked on additional pages and styling support.", "https://example.com/hassan.jpg", "https://linkedin.com/in/hassan"));
            }
            if (contactMessageRepository.count() == 0) {
                contactMessageRepository.save(new ContactMessage(null, "Sara Ahmed", "sara@email.com",
                        "Portfolio question", "Can I feature my digital art on ArtHive?",
                        ContactStatus.NEW, LocalDateTime.now().minusDays(2)));

                contactMessageRepository.save(new ContactMessage(null, "Ali Raza", "ali@email.com",
                        "Selling artwork", "How do I upload and sell my first artwork?",
                        ContactStatus.READ, LocalDateTime.now().minusDays(1)));
            }
        };
    }
}