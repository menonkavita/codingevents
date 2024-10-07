package or.launchcode.codingevents.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("events")
public class EventController {

    // Available @ localhost:8080/events
    public String displayEvents(Model model){
        List<String> eventsList = new ArrayList<>();
        eventsList.add("Dancing");
        eventsList.add("Singing");
        eventsList.add("Cooking");

        model.addAttribute("events", eventsList);
        return "events/index";
    }

    // localhost:8080/events/create
    @GetMapping("create")
    public String createEvents(){
        return "events/create";
    }
}

