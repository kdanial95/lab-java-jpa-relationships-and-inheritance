package com.ironhack.week9.repository;

import com.ironhack.week9.enums.GuestStatus;
import com.ironhack.week9.model.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GuestRepository extends JpaRepository<Guest, Long> {
    List<Guest> findByStatus(GuestStatus status);
}
