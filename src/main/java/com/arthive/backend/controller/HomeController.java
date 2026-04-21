package com.arthive.backend.controller;

import com.arthive.backend.dto.HomeStatsResponse;
import com.arthive.backend.model.Artwork;
import com.arthive.backend.service.HomeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/home")
@CrossOrigin(origins = "*")
public class HomeController {

    private final HomeService homeService;

    public HomeController(HomeService homeService) {
        this.homeService = homeService;
    }

    @GetMapping("/featured-artworks")
    public List<Artwork> getFeaturedArtworks() {
        return homeService.getFeaturedArtworks();
    }
    @GetMapping("/stats")
    public HomeStatsResponse getStats() {
        return homeService.getStats();
    }
}