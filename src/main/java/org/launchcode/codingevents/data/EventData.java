package org.launchcode.codingevents.data;

import org.launchcode.codingevents.models.Event;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class EventData {

    // putting all events
    private static final Map<Integer, Event> eventsObj = new HashMap<>();

    // get all events
    public static Collection<Event> getAll(){
        return eventsObj.values();
    }

    // get single event - for deleting record
    public static Event getById(int id){
        return eventsObj.get(id);
    }

    // add an event
    public static void add(Event e){
        eventsObj.put(e.getId(), e);
    }

    // edit an event
    public static void edit(Event e){
        eventsObj.replace(e.getId(), e);
    }

    // remove an event
    public static void remove(int id){
        eventsObj.remove(id);
    }
}
