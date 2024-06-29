package com.conte.hackothumun.controller;

import com.conte.hackothumun.entity.Event;
import com.conte.hackothumun.entity.FileApp;
import com.conte.hackothumun.service.EventServiceImplementation;
import com.conte.hackothumun.service.FileStorageService;
import lombok.AllArgsConstructor;
import jakarta.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@AllArgsConstructor
public class EventController {
    private EventServiceImplementation eventServiceImplementation;
    private FileStorageService fileStorageService;

    @GetMapping("/index")
    public String index(
            Model model,
            @RequestParam(name="page",defaultValue = "0") int page,
            @RequestParam(name="size",defaultValue = "2") int size,
            @RequestParam(name="keyword",defaultValue="") String kw
            ) {
        Page<Event> eventList = eventServiceImplementation.findAllEvents(page,size,kw);
        System.out.println(eventList.getTotalElements());
        model.addAttribute("listEvents",eventList.getContent());
        model.addAttribute("pages",new int[eventList.getTotalPages()]);
        model.addAttribute("currentpage",page);
        model.addAttribute("keyword",kw);
        return "index";
    }

    @GetMapping("/formEvents")
    public String insertEvents(Model model){
        model.addAttribute("event", new Event());
        return "formEvents";
    }

    @PostMapping("/createEvent")
    public String createEvent(@Valid Event ev, MultipartFile[] files, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "formEvents";
        }
        try {
            if(eventServiceImplementation.eventExists(ev.getTitle())){
                model.addAttribute("errorMessage","cette evenement existe deja");
                return "formEvents";
            }
            Event event = eventServiceImplementation.insert(ev);
            List<FileApp> fileAppList = new ArrayList<>();

            for(MultipartFile file : files){
                FileApp fileApp = fileStorageService.storeFile(file,event);
                fileAppList.add(fileApp);
            }

            event.setFilePath(fileAppList);
            eventServiceImplementation.update(event);
            return "redirect:/index";
        } catch (RuntimeException e) {
            e.printStackTrace();
            model.addAttribute("errorMessage", "Une erreur s'est produite lors de la création de l'événement");
            return "formEvents";
        }

    }
}
