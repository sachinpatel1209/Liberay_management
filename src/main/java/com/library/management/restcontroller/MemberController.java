package com.library.management.restcontroller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.library.management.entity.Member;

import com.library.management.service.MemberService;

import jakarta.validation.Valid;

public class MemberController {

	@Autowired
	public MemberService memberService;
	
	
	public MemberController(MemberService memberService) {
		super();
		this.memberService = memberService;
	}


	@GetMapping("/members")
	public List<Member> getAllMember() {
		return memberService.getAll();
	}
	
	@GetMapping("/members/{id}")
	public Optional<Member> getMemberById(@PathVariable long id) {
		return memberService.getById(id);
	}
	
	@PostMapping("/members")
	public ResponseEntity<Member> createMember(@Valid @RequestBody Member member) {
		
		 Member savedMember = memberService.save(member);
		
		 URI location = ServletUriComponentsBuilder
				 		.fromCurrentRequest().path("/{id}")
				 		.buildAndExpand(savedMember.getId())
				 		.toUri();
		 
		return ResponseEntity.created(location).build();
	}
	

	@DeleteMapping("/members/remove/{id}")
	public void deleteMember(@PathVariable long id) {
		memberService.deleteById(id);
	}
	
}
