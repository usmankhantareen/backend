package com.arthive.backend.service;

import com.arthive.backend.dto.ContactMessageRequest;
import com.arthive.backend.model.ContactMessage;
import com.arthive.backend.model.ContactStatus;
import com.arthive.backend.repository.ContactMessageRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ContactMessageService {

    private final ContactMessageRepository contactMessageRepository;

    public ContactMessageService(ContactMessageRepository contactMessageRepository) {
        this.contactMessageRepository = contactMessageRepository;
    }

    public ContactMessage create(ContactMessageRequest request) {
        ContactMessage message = new ContactMessage();
        message.setName(request.name());
        message.setEmail(request.email());
        message.setSubject(request.subject());
        message.setMessage(request.message());
        message.setStatus(ContactStatus.NEW);
        message.setCreatedAt(LocalDateTime.now());

        return contactMessageRepository.save(message);
    }

    public List<ContactMessage> getAll() {
        return contactMessageRepository.findAll();
    }

    public List<ContactMessage> getByStatus(ContactStatus status) {
        return contactMessageRepository.findByStatusOrderByCreatedAtDesc(status);
    }

    public ContactMessage updateStatus(Long id, ContactStatus status) {
        ContactMessage message = contactMessageRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Message not found"));

        message.setStatus(status);
        return contactMessageRepository.save(message);
    }

    public void delete(Long id) {
        if (!contactMessageRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Message not found");
        }
        contactMessageRepository.deleteById(id);
    }
    
}