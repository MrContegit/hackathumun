package com.conte.hackothumun.repository;

import com.conte.hackothumun.entity.UserApp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAppRepo extends JpaRepository<UserApp, Long> {
    UserApp findByUsername(String name);
}
