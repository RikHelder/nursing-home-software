package nl.haagsehogeschool.nursinghome.model;

import java.time.LocalDate;
import java.time.Month;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MonthScheduleTest {
    private Employee employeePeter;
    private MonthSchedule scheduleMarch;

    @BeforeEach
    void setup() {
        employeePeter = new Employee("Peter", "de Jong", "dhr",
                LocalDate.of(1999, Month.DECEMBER, 12),
                "cleanbot3000", 10);

        Schedule schedule = new Schedule();

        scheduleMarch = schedule.getMonthSchedule(Month.MARCH);

        scheduleMarch.getScheduledForDay(20).add(employeePeter);
        scheduleMarch.getScheduledForDay(21).add(employeePeter);
        scheduleMarch.getScheduledForDay(22).add(employeePeter);

        MonthSchedule scheduleApril = schedule.getMonthSchedule(Month.APRIL);

        scheduleApril.getScheduledForDay(1).add(employeePeter);
    }

    @Test
    void testScheduledDayCount() {
        Assertions.assertEquals(3, scheduleMarch.scheduledDayCount(employeePeter));
    }
}
