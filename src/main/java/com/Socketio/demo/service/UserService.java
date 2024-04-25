package com.Socketio.demo.service;

import com.Socketio.demo.dto.response.UserResponse;
import com.Socketio.demo.map.UserMapper;
import com.Socketio.demo.model.User;
import com.Socketio.demo.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepo userRepo;
    private final UserMapper userMapper;


    public UserResponse getUserById(Long id) {
        User user = userRepo.findByPrivateId(id).orElseThrow(() -> new RuntimeException("User not found"));
        return userMapper.userToUserResponse(user);
    }


    public void changeStatus(Long id, String status) {
//        userRepo.findById(id).ifPresent(user -> {
//            user.setStatus(status);
//            userRepo.save(user);
//        });
    }


}
