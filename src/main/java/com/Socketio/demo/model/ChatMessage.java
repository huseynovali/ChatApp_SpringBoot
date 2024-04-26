package com.Socketio.demo.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ChatMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long SenderId;
    private String SenderName;
    private Long ReceiverId;
    private String ReceiverName;
    private String message;
    private Date time;

    @ManyToOne

    @JsonIgnore
    private ChatRoom chatRoom;
}
