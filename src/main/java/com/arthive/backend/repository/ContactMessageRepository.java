package com.arthive.backend.repository;

import com.arthive.backend.model.ContactMessage;
import com.arthive.backend.model.ContactStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContactMessageRepository extends JpaRepository<ContactMessage, Long> {
    List<ContactMessage> findByStatusOrderByCreatedAtDesc(ContactStatus status);
}