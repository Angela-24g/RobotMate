package com.project.robotmate.home.service;

import com.project.robotmate.domain.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TestService {

    private final MemberRepository memberRepository;

    public void test() {
        memberRepository.findAll();
    }
}
