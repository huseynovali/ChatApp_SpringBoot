package com.Socketio.demo.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ChatRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long SenderId;
    private Long ReceiverId;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "chatRoom")
    private List<ChatMessage> message;

}
