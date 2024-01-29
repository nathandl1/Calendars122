import java.util.Set;
public class Event {
    String name; //new
    boolean isPublic;
    Date date;
    Time startTime;
    Time endTime;
    Set<Calendar> canView;
    Set<Calendar> canEdit;

    Event(String newName, Date newDate, Time start, Time end, Calendar calendar){
        name=newName;
        date=newDate;
        startTime=start;
        endTime=end;
    }

    void togglePublic(){
        isPublic = !isPublic;
    }
}
