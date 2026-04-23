package com.arthive.backend.service;

import com.arthive.backend.dto.HomeStatsResponse;
import com.arthive.backend.model.Artwork;
import com.arthive.backend.model.UserRole;
import com.arthive.backend.repository.ArtistRepository;
import com.arthive.backend.repository.ArtworkRepository;
import com.arthive.backend.repository.ContactMessageRepository;
import com.arthive.backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeService {

    private final ArtworkRepository artworkRepository;
    private final ArtistRepository artistRepository;
    private final ContactMessageRepository contactMessageRepository;
    private final UserRepository userRepository;

    public HomeService(ArtworkRepository artworkRepository,
                       ArtistRepository artistRepository,
                       ContactMessageRepository contactMessageRepository,
                       UserRepository userRepository) {
        this.artworkRepository = artworkRepository;
        this.artistRepository = artistRepository;
        this.contactMessageRepository = contactMessageRepository;
        this.userRepository = userRepository;
    }

    public List<Artwork> getFeaturedArtworks() {
        return artworkRepository.findByFeaturedTrueOrderByCreatedAtDesc();
    }

    public HomeStatsResponse getStats() {
        // Count registered users with ARTIST role + seeded artists for live updates
        long registeredArtists = userRepository.countByRole(UserRole.ARTIST);
        long seededArtists = artistRepository.count();

        return new HomeStatsResponse(
                registeredArtists + seededArtists,
                artworkRepository.count(),
                contactMessageRepository.count()
        );
    }
}
