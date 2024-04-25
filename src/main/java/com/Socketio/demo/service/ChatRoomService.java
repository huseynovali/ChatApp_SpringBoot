package com.Socketio.demo.service;


import com.Socketio.demo.model.ChatRoom;
import com.Socketio.demo.repository.ChatRoomRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatRoomService {

    private final ChatRoomRepo chatRoomRepo;


    public List<ChatRoom> getChatRoomByUserId(Long id) {
        return chatRoomRepo.findBySenderId(id).orElseThrow(() -> new RuntimeException("ChatRoom not found"));
    }

    public void deleteChatRoom(Long id) {
        chatRoomRepo.deleteById(id);
    }


}
