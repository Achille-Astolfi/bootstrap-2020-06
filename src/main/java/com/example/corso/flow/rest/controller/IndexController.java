package com.example.corso.flow.rest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.corso.flow.rest.resources.IndexResource;

@RestController
@RequestMapping("/")
public class IndexController {
	@GetMapping
	public ResponseEntity<IndexResource> getResources() {
		return ResponseEntity.ok(new IndexResource());
	}
}
