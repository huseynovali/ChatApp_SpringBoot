package com.Socketio.demo.service;

import com.Socketio.demo.dto.request.AuthenticationRequestDto;
import com.Socketio.demo.dto.request.RegisterRequestDto;
import com.Socketio.demo.dto.response.AuthenticationResponseDto;
import com.Socketio.demo.model.Role;
import com.Socketio.demo.model.User;
import com.Socketio.demo.repository.UserRepo;
import com.Socketio.demo.service.jwt.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationMeneger;
    private final JwtService jwtService;




    public String register(RegisterRequestDto request) {
        User user = userRepo.findByEmail(request.getEmail()).orElse(null);
        if (user != null) {
            throw new RuntimeException("User already exists");
        }

        user = User.builder()
                .email(request.getEmail())
                .name(request.getName())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();
        userRepo.save(user);

        return "User registered successfully";

    }


    public AuthenticationResponseDto authenticate(AuthenticationRequestDto request) {
        authenticationMeneger.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

        User user = userRepo.findByEmail(request.getEmail()).orElseThrow(() -> new RuntimeException("Email and password not match"));
        Map<String, Object> claims = new HashMap<>();
        claims.put("authorities", user.getAuthorities().stream().map(Object::toString).toArray());
        claims.put("userId", user.getId());
        String token = jwtService.generateToken((HashMap<String, Object>) claims, user);

        return AuthenticationResponseDto.builder()
                .token(token)
                .build();
    }


}