package combined;

//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;


/**
 * === === === === === === === === === === === === === === === === === === === === === === === === === === === ===
 */
public class Main {
    public static void main(String[] args) {
    }
}


/**
 * === === === === === === === === === === === === === === === === === === === === === === === === === === === ===
 */
class Activity {
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


/**
 * === === === === === === === === === === === === === === === === === === === === === === === === === === === ===
 */
class Client extends Person {
    private String medication;
    private String illnesses;
    private String handicaps;
    private boolean allowedToLeave;

    public Client(String firstName, String surName, String gender, LocalDate birthDate, String medication, String illnesses, String handicaps, boolean allowedToLeave) {
        super(firstName, surName, gender, birthDate);

        this.medication = medication;
        this.illnesses = illnesses;
        this.handicaps = handicaps;
        this.allowedToLeave = allowedToLeave;
    }

    @Override
    public String getName() {
        return getGender() + " " + getSurName();
    }

    public String getMedication() {
        return medication;
    }

    public String getIllnesses() {
        return illnesses;
    }

    public String getHandicaps() {
        return handicaps;
    }

    public boolean getAllowedToLeave() {
        return allowedToLeave;
    }

    @Override
    public String toString() {
        return getName();
    }
}


/**
 * === === === === === === === === === === === === === === === === === === === === === === === === === === === ===
 */
class ClientRegistration {
    static final int MAXIMUM_CAPACITY = 15;

    private List<Client> activeClients = new ArrayList<>();
    private List<Client> waitingClients = new ArrayList<>();

    public void addWaitingClient(Client client) {
        waitingClients.add(client);
    }

    public boolean removeWaitingClient(Client client) {
        return waitingClients.remove(client);
    }

    public boolean moveWaitingClientToActive(Client client) {
        if (waitingClients.contains(client) && activeClients.size() < MAXIMUM_CAPACITY) {
            waitingClients.remove(client);
            activeClients.add(client);

            return true;
        } else {
            return false;
        }
    }

    public boolean removeActiveClient(Client client) {
        return activeClients.remove(client);
    }
}


/**
 * === === === === === === === === === === === === === === === === === === === === === === === === === === === ===
 */
class Employee extends Person {
    private String role;
    private double salary;

    public Employee(String firstName, String surName, String gender, LocalDate birthDate, String role, double salary) {
        super(firstName, surName, gender, birthDate);
        this.role = role;
        this.salary = salary;
    }

    @Override
    public String getName() {
        return super.getFirstName();
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getRole() {
        return role;
    }

    @Override
    public String toString() {
        return getName();
    }
}


/**
 * === === === === === === === === === === === === === === === === === === === === === === === === === === === ===
 */
class MonthSchedule {
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


/**
 * === === === === === === === === === === === === === === === === === === === === === === === === === === === ===
 */
abstract class Person {
    private String firstName;
    private String surName;
    private String gender;
    private LocalDate birthDate;

    Person(String firstName, String surName, String gender, LocalDate birthDate) {
        this.firstName = firstName;
        this.surName = surName;
        this.gender = gender;
        this.birthDate = birthDate;
    }

    public abstract String getName();

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public long getAge() {
        return ChronoUnit.YEARS.between(birthDate, LocalDate.now());
    }
}


/**
 * === === === === === === === === === === === === === === === === === === === === === === === === === === === ===
 */
class Schedule {
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


/**
 * === === === === === === === === === === === === === === === === === === === === === === === === === === === ===
 */
class Visit {
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


/**
 * === === === === === === === === === === === === === === === === === === === === === === === === === === === ===
 */
class Visitor extends Person {
    private String code;

    public Visitor(String firstName, String surName, String gender, LocalDate birthDate, String code) {
        super(firstName, surName, gender, birthDate);

        this.code = code;
    }

    @Override
    public String getName() {
        return "(Visitor) " + getFirstName() + " " + getSurName();
    }

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return getName();
    }
}


//// === === === === === === === === === === === === === === === === === === === === === === === === === === === ===
//// Unit tests.
//// === === === === === === === === === === === === === === === === === === === === === === === === === === === ===
//
//
///**
// * === === === === === === === === === === === === === === === === === === === === === === === === === === === ===
// */
//class ClientRegistrationTest {
//    private ClientRegistration clientRegistration;
//    private Client testClient;
//
//    @BeforeEach
//    void setup() {
//        clientRegistration = new ClientRegistration();
//        testClient = createFakeClient("Fabel");
//    }
//
//    @Test
//    void testMoveWaitingClientToActiveUnknownClient() {
//        Assertions.assertFalse(clientRegistration.moveWaitingClientToActive(testClient));
//    }
//
//    @Test
//    void testMoveWaitingClientToActiveFullHouse() {
//        for (int clientIndex = 0; clientIndex < ClientRegistration.MAXIMUM_CAPACITY; clientIndex++) {
//            Client activeClient = createFakeClient("Client " + (clientIndex + 1));
//            clientRegistration.addWaitingClient(activeClient);
//            Assertions.assertTrue(clientRegistration.moveWaitingClientToActive(activeClient));
//        }
//
//        clientRegistration.addWaitingClient(testClient);
//        Assertions.assertFalse(clientRegistration.moveWaitingClientToActive(testClient));
//    }
//
//    private Client createFakeClient(String firstName) {
//        return new Client(firstName, "Poterboter", "dhr", null,
//                null, null, null, true);
//    }
//}
//
///**
// * === === === === === === === === === === === === === === === === === === === === === === === === === === === ===
// */
//class MonthScheduleTest {
//    private Employee employeePeter;
//    private MonthSchedule scheduleMarch;
//
//    @BeforeEach
//    void setup() {
//        employeePeter = new Employee("Peter", "de Jong", "dhr",
//                LocalDate.of(1999, Month.DECEMBER, 12),
//                "cleanbot3000", 10);
//
//        Schedule schedule = new Schedule();
//
//        scheduleMarch = schedule.getMonthSchedule(Month.MARCH);
//
//        scheduleMarch.getScheduledForDay(20).add(employeePeter);
//        scheduleMarch.getScheduledForDay(21).add(employeePeter);
//        scheduleMarch.getScheduledForDay(22).add(employeePeter);
//
//        MonthSchedule scheduleApril = schedule.getMonthSchedule(Month.APRIL);
//
//        scheduleApril.getScheduledForDay(1).add(employeePeter);
//    }
//
//    @Test
//    void testScheduledDayCount() {
//        Assertions.assertEquals(3, scheduleMarch.scheduledDayCount(employeePeter));
//    }
//}
//
///**
// * === === === === === === === === === === === === === === === === === === === === === === === === === === === ===
// */
//class ScheduleTest {
//    private List<Activity> activities = new ArrayList<>();
//    private Schedule schedule = new Schedule();
//    private Employee employeePeter;
//
//    @BeforeEach
//    void setup() {
//        Client client = new Client("Rik", "Helder", "dhr",
//                LocalDate.of(2002, Month.APRIL, 12), null, null, null, true);
//
//        Visitor visitor = new Visitor("Jantje", "Pietersen", "dhr", LocalDate.of(1987, Month.AUGUST, 30), "abc");
//
//        employeePeter = new Employee("Peter", "de Jong", "dhr",
//                LocalDate.of(1999, Month.DECEMBER, 12),
//                "cleanbot3000", 10);
//
//        LocalDateTime activityDateTime = LocalDateTime.of(2020, Month.MARCH, 20, 16, 0);
//        Activity activity = new Activity("Ping pong", "Playing ping pong", activityDateTime,
//                Duration.ofMinutes(36), "canteen", List.of(employeePeter), List.of(client, visitor));
//
//        activities.add(activity);
//
//        MonthSchedule scheduleMarch = schedule.getMonthSchedule(Month.MARCH);
//
//        scheduleMarch.getScheduledForDay(20).add(employeePeter);
//        scheduleMarch.getScheduledForDay(21).add(employeePeter);
//        scheduleMarch.getScheduledForDay(22).add(employeePeter);
//
//        MonthSchedule scheduleApril = schedule.getMonthSchedule(Month.APRIL);
//
//        scheduleApril.getScheduledForDay(12).add(employeePeter);
//        scheduleApril.getScheduledForDay(14).add(employeePeter);
//        scheduleApril.getScheduledForDay(16).add(employeePeter);
//    }
//
//    @Test
//    void testIsEmployeeScheduledForDateViaActivities() {
//        for (Activity activity : activities) {
//            LocalDate activityDate = activity.getStartDateTime().toLocalDate();
//
//            for (Employee mentor : activity.getMentors()) {
//                Assertions.assertTrue(schedule.isEmployeeScheduledForDate(mentor, activityDate),
//                        "Warning: mentor " + mentor.getName()
//                                + " is not scheduled on the day of activity "
//                                + activity.getTitle() + ".");
//            }
//        }
//    }
//
//    @Test
//    void testScheduledDayCount() {
//        Assertions.assertEquals(6, schedule.scheduledDayCount(employeePeter));
//    }
//}
