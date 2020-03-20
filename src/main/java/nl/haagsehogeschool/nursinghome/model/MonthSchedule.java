package nl.haagsehogeschool.nursinghome.model;

import java.util.ArrayList;
import java.util.List;

public class MonthSchedule {
    private List<List<Employee>> scheduledPerDay;

    MonthSchedule() {
        scheduledPerDay = new ArrayList<>();

        for (int dayIndex = 0; dayIndex < 31; dayIndex++) {
            scheduledPerDay.add(new ArrayList<>());
        }
    }

    public List<Employee> getScheduledForDay(int dayOfMonth) {
        return scheduledPerDay.get(dayOfMonth - 1);
    }

    int scheduledDayCount(Employee employee) {
        int dayCount = 0;

        for (List<Employee> employeesOnDay : scheduledPerDay) {
            if (employeesOnDay.contains(employee)) {
                dayCount++;
            }
        }

        return dayCount;
    }
}
