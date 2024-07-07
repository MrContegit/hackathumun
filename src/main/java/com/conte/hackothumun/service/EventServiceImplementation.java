package com.conte.hackothumun.service;

import com.conte.hackothumun.entity.Event;
import com.conte.hackothumun.entity.Role;
import com.conte.hackothumun.entity.UserApp;
import com.conte.hackothumun.repository.EventRepo;
import com.conte.hackothumun.repository.RoleRepo;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
@AllArgsConstructor
public class EventServiceImplementation implements ServiceCRUD<Event> {
    private EventRepo eventRepo;

    public Page<Event> findAllEvents(int page, int size, String kw) {
        return eventRepo.findByTitleContaining(kw, PageRequest.of(page, size));
    }
    @Override
    public Event select(String name) {
        return null;
    }

    @Override
    public Event insert(Event value) {
        Event event = eventRepo.findByTitle(value.getTitle());
        if(event != null) throw new RuntimeException("This event already exists");
//        value.setOrganizerId(null);
        return eventRepo.save(value);
    }

    @Override
    public Event update(Event value) {

        return eventRepo.save(value);
    }

    @Override
    public void delete(Long value) {
        Event event = eventRepo.findById(value).orElse(null);
        if(event == null) throw new RuntimeException("This event don't exists");
        eventRepo.deleteById(value);
    }

    public boolean eventExists(String title) {
        return eventRepo.findByTitle(title) != null;
    }
}
