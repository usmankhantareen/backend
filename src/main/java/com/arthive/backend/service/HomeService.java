package com.arthive.backend.service;

import com.arthive.backend.dto.HomeStatsResponse;
import com.arthive.backend.model.Artwork;
import com.arthive.backend.repository.ArtistRepository;
import com.arthive.backend.repository.ArtworkRepository;
import com.arthive.backend.repository.ContactMessageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeService {

    private final ArtworkRepository artworkRepository;
    private final ArtistRepository artistRepository;
    private final ContactMessageRepository contactMessageRepository;

    public HomeService(ArtworkRepository artworkRepository,
                       ArtistRepository artistRepository,
                       ContactMessageRepository contactMessageRepository) {
        this.artworkRepository = artworkRepository;
        this.artistRepository = artistRepository;
        this.contactMessageRepository = contactMessageRepository;
    }
    public List<Artwork> getFeaturedArtworks() {
        return artworkRepository.findByFeaturedTrueOrderByCreatedAtDesc();
    }

    public HomeStatsResponse getStats() {
        return new HomeStatsResponse(
                artistRepository.count(),
                artworkRepository.count(),
                contactMessageRepository.count()
        );
    }
}