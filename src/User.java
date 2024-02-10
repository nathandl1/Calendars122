import java.lang.*;
import java.util.*;

public class User {
    private static final Map<String, User> userRecord = new HashMap<String, User>();
    private final String username;
    Set<Calendar> ownedCalendars = new HashSet<Calendar>();
    private User(String newName){
        username = newName;
    }
    void addCalendar(Calendar cal){
        if(!ownedCalendars.add(cal)){
            System.out.println("User already owns calendar by this name");
        }
    }
    void listOwnedCalendars(){
        for (Calendar disCal : ownedCalendars){
            System.out.print(disCal.name + " ");
        }
    }
    String getUsername(){
        return this.username;
    }
    public static User getInstance(String newName){
        if (!userRecord.containsKey(newName)){
            userRecord.put(newName, new User(newName));
        }
        return userRecord.get(newName);
    }
    public static void delInstance(String newName){
        userRecord.remove(newName);
    }
}
