package com.arthive.backend.controller;

import com.arthive.backend.dto.ContactMessageRequest;
import com.arthive.backend.dto.ContactStatusUpdateRequest;
import com.arthive.backend.model.ContactMessage;
import com.arthive.backend.model.ContactStatus;
import com.arthive.backend.service.ContactMessageService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contact-messages")
public class ContactMessageController {
    private final ContactMessageService contactMessageService;

    public ContactMessageController(ContactMessageService contactMessageService) {
        this.contactMessageService = contactMessageService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ContactMessage create(@Valid @RequestBody ContactMessageRequest request) {
        return contactMessageService.create(request);
    }

    @GetMapping
    public List<ContactMessage> getAll() {
        return contactMessageService.getAll();
    }

    @GetMapping("/status/{status}")
    public List<ContactMessage> getByStatus(@PathVariable ContactStatus status) {
        return contactMessageService.getByStatus(status);
    }

    @PatchMapping("/{id}/status")
    public ContactMessage updateStatus(@PathVariable Long id,
                                       @Valid @RequestBody ContactStatusUpdateRequest request) {
        return contactMessageService.updateStatus(id, request.status());
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        contactMessageService.delete(id);
    }
}