package nl.haagsehogeschool.nursinghome.model;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ScheduleTest {
    private List<Activity> activities = new ArrayList<>();
    private Schedule schedule = new Schedule();
    private Employee employeePeter;

    @BeforeEach
    void setup() {
        Client client = new Client("Rik", "Helder", "dhr",
                LocalDate.of(2002, Month.APRIL, 12), null, null, null, true);

        Visitor visitor = new Visitor("Jantje", "Pietersen", "dhr", LocalDate.of(1987, Month.AUGUST, 30), "abc");

        employeePeter = new Employee("Peter", "de Jong", "dhr",
                LocalDate.of(1999, Month.DECEMBER, 12),
                "cleanbot3000", 10);

        LocalDateTime activityDateTime = LocalDateTime.of(2020, Month.MARCH, 20, 16, 0);
        Activity activity = new Activity("Ping pong", "Playing ping pong", activityDateTime,
                Duration.ofMinutes(36), "canteen", List.of(employeePeter), List.of(client, visitor));

        activities.add(activity);

        MonthSchedule scheduleMarch = schedule.getMonthSchedule(Month.MARCH);

        scheduleMarch.getScheduledForDay(20).add(employeePeter);
        scheduleMarch.getScheduledForDay(21).add(employeePeter);
        scheduleMarch.getScheduledForDay(22).add(employeePeter);

        MonthSchedule scheduleApril = schedule.getMonthSchedule(Month.APRIL);

        scheduleApril.getScheduledForDay(12).add(employeePeter);
        scheduleApril.getScheduledForDay(14).add(employeePeter);
        scheduleApril.getScheduledForDay(16).add(employeePeter);
    }

    @Test
    void testIsEmployeeScheduledForDateViaActivities() {
        for (Activity activity : activities) {
            LocalDate activityDate = activity.getStartDateTime().toLocalDate();

            for (Employee mentor : activity.getMentors()) {
                Assertions.assertTrue(schedule.isEmployeeScheduledForDate(mentor, activityDate),
                        "Warning: mentor " + mentor.getName()
                                + " is not scheduled on the day of activity "
                                + activity.getTitle() + ".");
            }
        }
    }

    @Test
    void testScheduledDayCount() {
        Assertions.assertEquals(6, schedule.scheduledDayCount(employeePeter));
    }
}
