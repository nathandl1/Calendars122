import java.util.HashSet;
import java.util.Set;

public class Calendar {
    String calendarType;
    boolean isPublic;
    //Theme themeName;
    Set<Event> events = new HashSet<Event>();
    Time currentTime; //doesn't seem relevant, may remove
    Set<User> canView = new HashSet<User>();
    Set<User> canEdit = new HashSet<User>();
    Date currentDate;
    //view
    Calendar(String newCalType, User firstUser){
        calendarType=newCalType;
        canEdit.add(firstUser);
        canView.add(firstUser);
        isPublic=true;
    }
    void print() {
        System.out.print(calendarType);
    }
    void togglePublic(){
        isPublic = !isPublic;
    }

    void edit() {
        System.out.println("edit");
    }
}
