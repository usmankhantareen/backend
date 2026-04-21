package com.arthive.backend.dto;

import com.arthive.backend.model.ContactStatus;
import jakarta.validation.constraints.NotNull;

public record ContactStatusUpdateRequest(
        @NotNull(message = "Status is required")
        ContactStatus status
) {
}