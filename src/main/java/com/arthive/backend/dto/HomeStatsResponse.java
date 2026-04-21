package com.arthive.backend.dto;

public record HomeStatsResponse(
        long artistCount,
        long artworkCount,
        long contactMessageCount
) {
}