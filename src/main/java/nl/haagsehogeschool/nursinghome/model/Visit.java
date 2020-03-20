package nl.haagsehogeschool.nursinghome.model;

import java.time.Duration;
import java.time.LocalDateTime;

public class Visit {
    private LocalDateTime startDateTime;
    private Duration duration;
    private Client visitedClient;
    private Visitor visitor;

    public Visit(LocalDateTime startDateTime, Duration duration, Client visitedClient, Visitor visitor) {
        this.startDateTime = startDateTime;
        this.duration = duration;
        this.visitedClient = visitedClient;
        this.visitor = visitor;
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

    public Client getVisitedClient() {
        return visitedClient;
    }

    public void setVisitedClient(Client visitedClient) {
        this.visitedClient = visitedClient;
    }

    public Visitor getVisitor() {
        return visitor;
    }

    public void setVisitor(Visitor visitor) {
        this.visitor = visitor;
    }
}
