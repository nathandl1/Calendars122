import java.lang.*;
import java.util.HashSet;
import java.util.Set;
public class User {
    String username;
    Set<Calendar> ownedCalendars = new HashSet<Calendar>();
    Set<Calendar> sharedCalendars = new HashSet<Calendar>();
    //Set<Event> sharedEvents;

    User(String newName){
        username = newName;
    }

    void addShared(Calendar newCal){
        boolean add = sharedCalendars.add(newCal);
        if (add) {
            System.out.println("User already part of Calendar");
        }
    }
}
