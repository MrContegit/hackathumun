package com.conte.hackothumun.repository;

import com.conte.hackothumun.entity.Participant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipentRepo extends JpaRepository<Participant,Long> {
}
