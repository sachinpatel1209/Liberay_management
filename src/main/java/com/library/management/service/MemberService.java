package com.library.management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.management.entity.Member;
import com.library.management.repository.MemberRepository;

@Service
public class MemberService {
	
	@Autowired
	public MemberRepository memberRepository;

	public MemberService(MemberRepository memberRepository) {
		super();
		this.memberRepository = memberRepository;
	}
	
	public List<Member> getAll() {
		return memberRepository.findAll();
	}
	
	public Optional<Member> getById(Long id) {
		return memberRepository.findById(id);
	}
	
	public Member save(Member member) {
		return memberRepository.save(member);
	}
	
	public void deleteById(Long id) {
		 memberRepository.deleteById(id);
	}
}


