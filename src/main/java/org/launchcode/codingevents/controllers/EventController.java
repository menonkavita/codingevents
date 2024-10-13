package org.launchcode.codingevents.controllers;

import org.launchcode.codingevents.data.EventData;
import org.launchcode.codingevents.models.Event;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("events")
public class EventController {

//    private static List<Event> eventsObj = new ArrayList<>();

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

        model.addAttribute("events", EventData.getAll());
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
        EventData.add(new Event(eventName, eventDesc));
        return "redirect:/events";
    }

    // method renders the form
    @GetMapping("delete")
    public String displayDeleteEventForm(Model model){
        model.addAttribute("title", "Delete Events");
        model.addAttribute("events", EventData.getAll());
        return "events/delete";
    }

    @PostMapping("delete")
    public String processDeleteEventsForm(@RequestParam(required=false) int[] eventIds){
        // required:false -> allows this method to be called without any event ids,
        // in case someone hits delete button without checkboxes.
        // So now the eventIds need to checked if they are null

        if(eventIds != null){
            for(int id : eventIds){
                EventData.remove(id);
            }
        }
        // usually there's a path(relative path) after "redirect:", but since going to root index.html leave blank
        // gave error screen... so added /events path.
        return "redirect:/events";
    }
}

