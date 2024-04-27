package com.Socketio.demo.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ChatRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long SenderId;
    private Long RecipientId;
    private String RecipientName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "chatRoom")
    private List<ChatMessage> message;

}
