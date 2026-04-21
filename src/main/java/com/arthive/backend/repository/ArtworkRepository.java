package com.arthive.backend.repository;

import com.arthive.backend.model.Artwork;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
public interface ArtworkRepository extends JpaRepository<Artwork, Long> {
    List<Artwork> findByFeaturedTrueOrderByCreatedAtDesc();
}