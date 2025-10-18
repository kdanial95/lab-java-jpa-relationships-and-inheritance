package com.ironhack.week8.repository;

import com.ironhack.week8.model.Engineer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EngineerRepository extends JpaRepository <Engineer, Long> {
}
