package com.Socketio.demo.service;


import com.Socketio.demo.dto.response.ChatRoomResponse;
import com.Socketio.demo.map.ChatRoomMapper;
import com.Socketio.demo.model.ChatRoom;
import com.Socketio.demo.repository.ChatRoomRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ChatRoomService {

    private final ChatRoomRepo chatRoomRepo;
    private final ChatRoomMapper chatRoomMapper;


    public List<ChatRoomResponse> getChatRoomByUserId(Long id) {
        List<ChatRoom> chatroom = chatRoomRepo.findBySenderId(id).orElseThrow(() -> new RuntimeException("ChatRoom not found"));
        return chatroom.stream().map(chatRoomMapper::chatRoomToChatRoomResponse).collect(Collectors.toList());

    }

    public void deleteChatRoom(Long id) {
        chatRoomRepo.deleteById(id);
    }


}
