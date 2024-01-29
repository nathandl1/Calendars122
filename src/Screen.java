import java.util.*;

public class Screen {
    User currentUser;
    Calendar currentCalendar;
    Set<User> users = new HashSet<User>(); //new
    Set<Calendar> calendars = new HashSet<Calendar>();
    Screen(User firstUser){
        currentUser=firstUser;
        currentCalendar = new Calendar("Gregorian", firstUser);
        currentUser.ownedCalendars.add(currentCalendar);
        users.add(firstUser);
    }

    void createUser(String newName){ //new
        boolean add = users.add(new User(newName));
        if (!add){
            System.out.println("User already exists!");
        }
    }
    void createCalendar(String calType){ //new
        Calendar tempCalendar = new Calendar(calType, currentUser);
        boolean add = calendars.add(tempCalendar);
        currentUser.ownedCalendars.add(tempCalendar);
    }
    void changeUser(String username){
        System.out.println("0");
    }
}
