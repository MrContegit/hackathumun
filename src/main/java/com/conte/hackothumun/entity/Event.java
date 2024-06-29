//13c0c801-f600-4e16-a756-88aae6e50065

package com.conte.hackothumun.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eventId;
    private String title;
    private String description;
    private Date date;
    private String location;
    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    private List<FileApp> filePath;
    @ManyToOne
    @JoinColumn(name = "organizer_id", nullable = false)
    private Organisateur organizerId;
    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    private List<Participant> participants;

}
