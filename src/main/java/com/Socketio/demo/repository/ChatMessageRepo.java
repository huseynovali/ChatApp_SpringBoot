package com.Socketio.demo.repository;

import com.Socketio.demo.model.ChatMessage;
import com.Socketio.demo.model.ChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ChatMessageRepo extends JpaRepository<ChatMessage, Long>{

       Optional<List<ChatMessage>> findByRoomId(Long id);


}
