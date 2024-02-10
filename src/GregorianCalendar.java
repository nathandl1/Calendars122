public class GregorianCalendar extends Calendar{
    String type;
    GregorianCalendar(String newType, String newName) {
        super(newName);
        type=newType;
    }

    public void display(){
        System.out.println("Calendar Type: " + type);
        System.out.println("Calendar Name: "+name);
        System.out.println("Events: " +events.size());
        for (Event event : events){
            event.display();
        }
    }
}
