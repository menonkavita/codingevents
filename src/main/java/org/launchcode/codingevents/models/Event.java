package org.launchcode.codingevents.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Objects;

public class Event {
    private int id;
    private static int nextId=1;

    @NotBlank(message = "Please enter a valid name")
    @Size(min=3, max=50, message="Name must be between 3 and 50 characters.")
    private String name;

    @Size(max=500, message="Description too long!")
    private String description;

    private int numberOfAttendees = 0;

    @NotBlank(message = "Please enter a valid email")
    @Email(message="Invalid email. Try again.")
    private String contactEmail;


    public Event(String name, String description, int numberOfAttendees, String contactEmail) {
        this.name = name;
        this.description = description;
        this.numberOfAttendees=numberOfAttendees;
        this.contactEmail= contactEmail;
        this.id = nextId;
        nextId++;
    }

    public Event() {    }

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
