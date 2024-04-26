package com.Socketio.demo.repository;


import com.Socketio.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {


    Optional<User> findByNickName(String nickName);


    Optional<User> findByEmail(String email);
}
