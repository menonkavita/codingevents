package org.launchcode.codingevents.models;

import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.util.Objects;

public class Event {
    private int id;
    private static int nextId=1;

    @NotBlank(message = "Please enter a valid name")
    @Size(min=3, max=50, message="Name must be between 3 and 50 characters.")
    private String name;

    @Size(max=500, message="Description too long!")
    private String description;

    @Positive(message="Enter a number greater than 0")
    @Max(9)
    private int numberOfAttendees = 0;

    @NotBlank(message = "Please enter a valid email")
    @Email(message="Invalid email. Try again.")
    private String contactEmail;

    @NotBlank(message="Location cannot be left blank")
    private String location;

//    @AssertTrue(message="Event needs registration. Mark true.")
//    private String needsRegistration;

//    @Future(message="Date has to be a future date.")
//    private LocalDate eventDate;

    private EventType type;

    public Event(String name, String description, int numberOfAttendees, String contactEmail, String location, EventType t) {
        this.name = name;
        this.description = description;
        this.numberOfAttendees=numberOfAttendees;
        this.contactEmail= contactEmail;
        this.location=location;
        this.type=t;
//        this.needsRegistration=needsRegistration;
//        this.id = nextId;
//        nextId++;
    }

    public Event() {
        this.id = nextId;
        nextId++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public int getNumberOfAttendees() {
        return numberOfAttendees;
    }

    public void setNumberOfAttendees(int numberOfAttendees) {
        this.numberOfAttendees = numberOfAttendees;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }

    //    public String getNeedsRegistration() {
//        return needsRegistration;
//    }
//
//    public void setNeedsRegistration() {
//        this.needsRegistration = needsRegistration;
//    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event events = (Event) o;
        return id == events.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
