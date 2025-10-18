package com.ironhack.week9.repository;

import com.ironhack.week9.model.Speaker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpeakerRepository extends JpaRepository<Speaker, Long> {}
