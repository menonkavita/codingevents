package org.launchcode.codingevents.controllers;

import jakarta.validation.Valid;
import org.launchcode.codingevents.data.EventData;
import org.launchcode.codingevents.models.Event;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("events")
public class EventController {

    // Available @ localhost:8080/events -- not rendering as of now
    @GetMapping
    public String displayEvents(Model model){
        model.addAttribute("events", EventData.getAll());
        return "events/index";
    }

    // localhost:8080/events/create
    @GetMapping("create")
    public String renderCreateEvents(Model model){
        model.addAttribute("title", "Create Event");
        model.addAttribute(new Event());
        return "events/create";
    }

    // localhost:8080/events/create
    @PostMapping("/create")
    public String createEvent (@ModelAttribute @Valid Event newEvent, Errors err, Model model){
        if(err.hasErrors()){
            model.addAttribute("title", "Create Event");;
//            model.addAttribute("errorMsg", "Incorrect information entered!");
            return "events/create";
        }

        EventData.add(newEvent);
        return "redirect:/events";
    }

    // localhost:8080/events/delete
    // method renders the form
    @GetMapping("delete")
    public String displayDeleteEventForm(Model model){
        model.addAttribute("title", "Delete Events");
        model.addAttribute("events", EventData.getAll());
        return "events/delete";
    }

    // localhost:8080/events/delete
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

    // localhost:8080/events/edit
    // same as delete above
    @GetMapping("edit/{eventId}")
    public String displayEditEventForm(Model model, @PathVariable int eventId){
        Event eventToEdit = EventData.getById(eventId);
        model.addAttribute("event", eventToEdit);

//        String title = "Edit Event Name (id=ID)" + eventToEdit.getName() + "(id= " + eventToEdit.getId() + ")";
//        model.addAttribute("title", "Edit Events");

        return "events/edit";
    }

//    // localhost:8080/events/edit
//    @GetMapping("edit/{eventId}")
//    public String displayEditForm(Model model, @PathVariable int eventId){
//
//        Event eventToEdit = EventData.getById(eventId);
//        model.addAttribute("event", eventToEdit); // --- events instead of event
//
//        String title = "Edit Event Name (id=ID)" + eventToEdit.getName() + "(id= " + eventToEdit.getId() + ")";
//        model.addAttribute("title", title);
//        return "/events/edit";
//    }


     //localhost:8080/events/edit
    @PostMapping("edit")
    public String processEditForm(int eventId, String name, String description, int numberOfAttendees){
        //, int numberOfAttendees
        Event eventToEdit = EventData.getById(eventId);
        eventToEdit.setName(name);
        eventToEdit.setDescription(description);
        eventToEdit.setNumberOfAttendees(numberOfAttendees);

        return "redirect:/events";
    }

    // localhost:8080/events/delete
//    @PostMapping("delete")
//    public String processEditEventsForm(@RequestParam(required=false) int[] eventIds){
//        // required:false -> allows this method to be called without any event ids,
//        // in case someone hits delete button without checkboxes.
//        // So now the eventIds need to checked if they are null
//
//        if(eventIds != null){
//            for(int id : eventIds){
//                EventData.remove(id);
//            }
//        }
//        // usually there's a path(relative path) after "redirect:", but since going to root index.html leave blank
//        // gave error screen... so added /events path.
//        return "redirect:/events";
//    }


}

