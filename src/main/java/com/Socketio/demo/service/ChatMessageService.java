package com.Socketio.demo.service;


import com.Socketio.demo.dto.request.ChatMessageRequest;
import com.Socketio.demo.dto.response.ChatMessageResponse;
import com.Socketio.demo.map.MessageMapper;
import com.Socketio.demo.model.ChatMessage;
import com.Socketio.demo.repository.ChatMessageRepo;
import com.Socketio.demo.repository.ChatRoomRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatMessageService {

    private final ChatMessageRepo chatMessageRepo;
    private MessageMapper messageMapper;


    public void saveChatMessage(ChatMessageRequest message) {
        ChatMessage chatMessage = messageMapper.messageRequestToMessage(message);
        chatMessageRepo.save(chatMessage);
    }


    public List<ChatMessageResponse> getChatMessageByRoomId(Long RoomId) {
        List<ChatMessage> message = chatMessageRepo.findByRoomId(RoomId).orElseThrow(() -> new RuntimeException("ChatMessage not found"));
        return message.stream().map(messageMapper::messageToMessageResponse).toList();

    }

    public void deleteChatMessage(Long id) {
        chatMessageRepo.deleteById(id);
    }


}
