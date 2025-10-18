package com.ironhack.week9.repository;

import com.ironhack.week9.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}