package com.conte.hackothumun.repository;
import com.conte.hackothumun.entity.Event;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepo extends JpaRepository<Event, Long> {
    Page<Event> findByTitleContaining(String title, Pageable pageable);
    Event findByTitle(String title);
}
