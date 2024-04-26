package com.Socketio.demo.controller;

import com.Socketio.demo.dto.request.AuthenticationRequestDto;
import com.Socketio.demo.dto.request.RegisterRequestDto;
import com.Socketio.demo.dto.response.AuthenticationResponseDto;
import com.Socketio.demo.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth/")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    @PostMapping("register")
    public ResponseEntity<String> register(@RequestBody RegisterRequestDto request) {
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("authenticate")
    public AuthenticationResponseDto authenticate(@RequestBody AuthenticationRequestDto request) {

        return authService.authenticate(request);
    }

}