package com.project.robotmate.domain.repository;

import com.project.robotmate.domain.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
