package com.example.BTH1_2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.BTH1_2.request.UserRequest;
import com.example.BTH1_2.service.LoginService;

@RestController
public class LoginController {

	@Autowired
	private LoginService loginService;

	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody UserRequest user) {
		String token = loginService.login(user.getUsername(), user.getPassword());

		if (token == null) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Sai username hoặc password.");
		}

		return ResponseEntity.ok(token);
	}

	@GetMapping("/auth")
	public String helloWorld() {
		return "Hello World";
	}

	@GetMapping("/auth/baithuchanh")
	public boolean auth() {
		return true;
	}
}
