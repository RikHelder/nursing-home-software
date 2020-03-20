package nl.haagsehogeschool.nursinghome.main;

import nl.haagsehogeschool.nursinghome.model.Activity;
import nl.haagsehogeschool.nursinghome.model.Client;
import nl.haagsehogeschool.nursinghome.model.ClientRegistration;
import nl.haagsehogeschool.nursinghome.model.Employee;
import nl.haagsehogeschool.nursinghome.model.MonthSchedule;
import nl.haagsehogeschool.nursinghome.model.Schedule;
import nl.haagsehogeschool.nursinghome.model.Visitor;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private ClientRegistration clientRegistration = new ClientRegistration();
    private Schedule schedule = new Schedule();
    private List<Activity> activities = new ArrayList<>();
//    private List<Visit> visits = new ArrayList<>();

    public static void main(String[] args) {
        new Main().demonstrateNHS();
    }

    @SuppressWarnings("unused")
    private void demonstrateNHS() {
        Client client = new Client("Rik", "Helder", "dhr",
                LocalDate.of(2002, Month.APRIL, 12),
                null, null, null, true);

        clientRegistration.addWaitingClient(client);
        if (!clientRegistration.moveWaitingClientToActive(client)) {
            System.out.println("Moving waiting client to active failed.");
        }

        System.out.println("Client name: " + client.getName());


        // todo: test other methods.

        // todo: print overviews and stuff.

        Visitor visitor = new Visitor("Jantje", "Pietersen", "dhr",
                LocalDate.of(1987, Month.AUGUST, 30), "abc");

        Employee employeePeter = new Employee("Peter", "de Jong", "dhr",
                LocalDate.of(1999, Month.DECEMBER, 12),
                "cleanbot3000", 10);

        Activity activity = new Activity("Ping pong", "",
                LocalDateTime.of(2020, Month.MARCH, 20, 16, 0),
                Duration.ofMinutes(36), "canteen",
                List.of(new Employee("Peter", "de Jong", "dhr",
                        LocalDate.of(1999, Month.DECEMBER, 12), "cleanbot3000", 10)),
                List.of(client, visitor));

        System.out.println(activity.getParticipants());
        System.out.println(activity.getMentors());
        System.out.println(activity.getDuration().toMinutes());
        System.out.println(activity.getTitle());

        activities.add(activity);

        MonthSchedule scheduleMarch = schedule.getMonthSchedule(Month.MARCH);

        scheduleMarch.getScheduledForDay(20).add(employeePeter);

        checkScheduleForActivities(activities, schedule);
    }

    private void checkScheduleForActivities(List<Activity> activities, Schedule schedule) {
        for (Activity activity : activities) {
            List<Employee> daySchedule = schedule.getDaySchedule(activity.getStartDateTime().toLocalDate());

            for (Employee mentor : activity.getMentors()) {
                if (!daySchedule.contains(mentor)) {
                    System.out.println("Warning: mentor " + mentor.getName()
                            + " is not scheduled on the day of activity "
                            + activity.getTitle() + ".");
                }
            }
        }
    }
}
