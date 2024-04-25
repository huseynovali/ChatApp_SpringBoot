package com.Socketio.demo.dto.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChatMessageRequest {
    private Long SenderId;
    private String SenderName;
    private Long ReceiverId;
    private String ReceiverName;
    private String message;
    private Long chatRoomId;
}
