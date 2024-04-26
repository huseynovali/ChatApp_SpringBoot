package com.Socketio.demo.service;

import com.Socketio.demo.dto.response.UserResponse;
import com.Socketio.demo.map.UserMapper;
import com.Socketio.demo.model.Status;
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


    public UserResponse getUserByNickName(String nickname) {
        User user = userRepo.findByNickName(nickname).orElseThrow(() -> new RuntimeException("User not found"));
        return userMapper.userToUserResponse(user);
    }


   public void connectUser(Long id) {
        User userToConnect = userRepo.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        userToConnect.setStatus(Status.ONLINE);
        userRepo.save(userToConnect);
    }

    public void disconnectUser(Long id) {
        User userToDisconnect = userRepo.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        userToDisconnect.setStatus(Status.OFFLINE);
        userRepo.save(userToDisconnect);

    }



}
