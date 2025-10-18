package com.ironhack.week9.repository;

import com.ironhack.week9.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {}
