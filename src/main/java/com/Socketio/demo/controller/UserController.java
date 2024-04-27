package com.Socketio.demo.controller;


import com.Socketio.demo.dto.response.UserResponse;
import com.Socketio.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/use/user/")

public class UserController {


    private final UserService userService;

    @GetMapping("nickname/{nickname}")
    public UserResponse getUserByNickname(@PathVariable("nickname") String nickname) {
        System.out.println(nickname);
        return userService.getUserByNickName(nickname);
    }


}
