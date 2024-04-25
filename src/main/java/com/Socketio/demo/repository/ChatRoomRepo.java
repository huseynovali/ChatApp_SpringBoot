package com.Socketio.demo.repository;

import com.Socketio.demo.model.ChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ChatRoomRepo extends JpaRepository<ChatRoom, Long> {
    Optional<List<ChatRoom>> findBySenderId(Long id);
}
