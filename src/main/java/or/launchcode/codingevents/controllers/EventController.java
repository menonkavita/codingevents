package or.launchcode.codingevents.controllers;

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

    private static HashMap<String, String> eventsListHash = new HashMap<>();

    // Available @ localhost:8080/events -- not rendering as of now
    @GetMapping
    public String displayEvents(Model model){
//        List<String> eventsList = new ArrayList<>();
//        eventsList.add("Dancing");
//        eventsList.add("Singing");
//        eventsList.add("Cooking");
//        model.addAttribute("events", eventsList);

        eventsListHash.put("Menteaship", "A fun meetup for connecting with mentors");
        eventsListHash.put("Code With Pride", "A fun meetup sponsored by LaunchCode");
        eventsListHash.put("Javascripty", "An imaginary meetup for Javascript developers");

        model.addAttribute("events", eventsListHash);
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
        eventsListHash.put(eventName, eventDesc);
        return "redirect:/events";
    }
}

