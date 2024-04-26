package com.Socketio.demo.repository;

import com.Socketio.demo.model.ChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ChatRoomRepo extends JpaRepository<ChatRoom, Long> {

    @Query("SELECT c FROM ChatRoom c WHERE c.SenderId = :id")
    Optional<List<ChatRoom>> findBySenderId(Long id);
}
