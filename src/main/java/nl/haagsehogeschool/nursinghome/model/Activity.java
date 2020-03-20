package nl.haagsehogeschool.nursinghome.model;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Activity {
    private String title;
    private String description;
    private LocalDateTime startDateTime;
    private Duration duration;
    private String location;
    private List<Employee> mentors;
    private List<Person> participants;

    public Activity(String title, String description, LocalDateTime startDateTime, Duration duration, String location,
                    List<Employee> mentors, List<Person> participants) {

        this.title = title;
        this.description = description;
        this.startDateTime = startDateTime;
        this.duration = duration;
        this.location = location;
        this.mentors = new ArrayList<>(mentors);
        this.participants = new ArrayList<>(participants);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(LocalDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Employee> getMentors() {
        return mentors;
    }

    public void setMentors(List<Employee> mentors) {
        this.mentors = mentors;
    }

    public List<Person> getParticipants() {
        return participants;
    }

    public void setParticipants(List<Person> participants) {
        this.participants = participants;
    }
}
