package com.conte.hackothumun.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("PARTICIPANT")
public class Participant  extends UserApp{
    private String eventsAttended;
    private String feedback;
    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;
}
