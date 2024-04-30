package com.Socketio.demo.dto.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChatMessageResponse {
    private Long id;
    private Long SenderId;
    private String SenderName;
    private Long RecipientId;
    private String RecipientName;
    private String message;
    private String time;
    private Long chatRoomId;
}
