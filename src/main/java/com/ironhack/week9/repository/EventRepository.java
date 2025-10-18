package com.ironhack.week9.repository;

import com.ironhack.week9.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {}
