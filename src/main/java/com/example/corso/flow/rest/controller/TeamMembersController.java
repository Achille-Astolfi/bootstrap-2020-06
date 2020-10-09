package com.example.corso.flow.rest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.corso.flow.rest.resources.TeamMemberListResource;

@RestController
@RequestMapping("/team-members")
public class TeamMembersController {
	@GetMapping
	public ResponseEntity<TeamMemberListResource> getResources() {
		return ResponseEntity.ok(new TeamMemberListResource());
	}
}
