package com.Socketio.demo.controller;

import com.Socketio.demo.dto.response.ChatRoomResponse;
import com.Socketio.demo.model.ChatRoom;
import com.Socketio.demo.service.ChatRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/use/")
public class ChatRoomController {

    private final ChatRoomService chatRoomService;

    @GetMapping("chatroom/{roomId}")
    public ChatRoom getRoomByRoomId(@PathVariable("roomId") Long roomId) {
        return chatRoomService.getChatByRoomId(roomId);
    }

    @GetMapping("chatroom/sender/{senderid}")
    public List<ChatRoomResponse> getRoomByUserId(@PathVariable("senderid") Long senderId) {

        return chatRoomService.getChatRoomByUserId(senderId);
    }
}
