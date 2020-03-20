package nl.haagsehogeschool.nursinghome.model;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Schedule {
    private List<MonthSchedule> scheduledPerMonth;

    public Schedule() {
        scheduledPerMonth = new ArrayList<>();

        for (int monthIndex = 0; monthIndex < 12; monthIndex++) {
            scheduledPerMonth.add(new MonthSchedule());
        }
    }

    public MonthSchedule getMonthSchedule(Month month) {
        return scheduledPerMonth.get(month.getValue() - 1);
    }

    public List<Employee> getDaySchedule(LocalDate localDate) {
        MonthSchedule monthSchedule = getMonthSchedule(localDate.getMonth());

        return monthSchedule.getScheduledForDay(localDate.getDayOfMonth());
    }

    boolean isEmployeeScheduledForDate(Employee employee, LocalDate localDate) {
        return getDaySchedule(localDate).contains(employee);
    }

    int scheduledDayCount(Employee employee) {
        int dayCount = 0;

        for (Month month : Month.values()) {
            MonthSchedule monthSchedule = getMonthSchedule(month);
            dayCount += monthSchedule.scheduledDayCount(employee);
        }

        return dayCount;
    }
}
