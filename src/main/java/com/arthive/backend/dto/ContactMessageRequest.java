package com.arthive.backend.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ContactMessageRequest(
        @NotBlank(message = "Name is required")
        String name,

        @NotBlank(message = "Email is required")
        @Email(message = "Email must be valid")
        String email,

        @NotBlank(message = "Subject is required")
        String subject,
        @NotBlank(message = "Message is required")
        @Size(min = 10, message = "Message must be at least 10 characters")
        String message
) {
}