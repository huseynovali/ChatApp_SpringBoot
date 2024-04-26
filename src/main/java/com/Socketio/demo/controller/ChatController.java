package com.Socketio.demo.controller;

import com.Socketio.demo.dto.request.ChatMessageRequest;
import com.Socketio.demo.dto.response.ChatMessageResponse;
import com.Socketio.demo.model.ChatMessage;
import com.Socketio.demo.model.ChatNotification;
import com.Socketio.demo.service.ChatMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ChatController {


    private  SimpMessagingTemplate messagingTemplate;
    private final ChatMessageService chatMessageService;

    @MessageMapping("/chat")
    public void processMessage(@Payload ChatMessageRequest chatMessage) {


        ChatMessage savedMsg = chatMessageService.saveChatMessage(chatMessage);


        messagingTemplate.convertAndSendToUser(
                chatMessage.getRecipientId().toString(), "/queue/messages",
                new ChatNotification(
                        savedMsg.getId(),
                        savedMsg.getSenderId(),
                        savedMsg.getRecipientId(),
                        savedMsg.getMessage()
                )
        );
    }

    @GetMapping("/messages/{senderId}/{recipientId}")
    public ResponseEntity<List<ChatMessageResponse>> findChatMessages(@PathVariable Long RoomId) {
        return ResponseEntity.ok(chatMessageService.getChatMessageByRoomId(RoomId));
    }
}