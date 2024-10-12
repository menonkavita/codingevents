package org.launchcode.codingevents.controllers;

import org.launchcode.codingevents.models.Events;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("events")
public class EventController {

    private static List<Events> eventsObj = new ArrayList<>();

    // Available @ localhost:8080/events -- not rendering as of now
    @GetMapping
    public String displayEvents(Model model){
//        List<String> eventsList = new ArrayList<>();
//        eventsList.add("Dancing");
//        eventsList.add("Singing");
//        eventsList.add("Cooking");
//        model.addAttribute("events", eventsList);

//        eventsObj.add(new Events("Menteaship"));
//        eventsObj.add(new Events("Code With Pride"));
//        eventsObj.add(new Events("Javascripty"));

        model.addAttribute("events", eventsObj);
        return "events/index";
    }

    // localhost:8080/events/create
    @GetMapping("create")
    public String renderCreateEvents(){
        return "events/create";
    }

    // localhost:8080/events/create
    @PostMapping("/create")
    public String createEvent (@RequestParam String eventName, @RequestParam String eventDesc){
        eventsObj.add(new Events(eventName, eventDesc));
        return "redirect:/events";
    }
}

