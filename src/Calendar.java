import java.util.HashSet;
import java.util.Set;

public class Calendar implements IsEditable, IsVisible{
    String name;
    String calendarType;
    boolean isPublic;
    //Theme themeName;
    Set<Event> events = new HashSet<>();
    Time currentTime; //doesn't seem relevant, may remove
    Set<User> canView = new HashSet<>();
    Set<User> canEdit = new HashSet<>();
    Date currentDate;
    //view
    Calendar(String newCalType, String newName, User firstUser){
        name=newName;
        calendarType=newCalType;
        canEdit.add(firstUser);
        canView.add(firstUser);
        isPublic=true;
    }
    public void display() {
        System.out.print(calendarType);
    }
    void togglePublic(){
        isPublic = !isPublic;
    }

    public void edit() {
        System.out.println("edit");
    }
}
