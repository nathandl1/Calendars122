import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Calendar implements IsEditable, IsVisible{
    String name;
    boolean isPublic;
    Set<Event> events = new HashSet<>();
    private final Scanner myObj = new Scanner(System.in);
    Calendar(String newName){
        name=newName;
    }
    public void display() {
        System.out.println("Calendar Name: "+name);
        System.out.println("Events: " +events.size());
        for (Event event : events){
            event.display();
        }
    }
    public void addEvent(Event event){
        events.add(event);
    }
    public void edit() {
        String ans = "0";
        while (!ans.equals("exit")){
            System.out.println("What would you like to change?");
            System.out.println("1.Name 2.Publicity");
            System.out.println("Enter exit to cancel.");
            ans = myObj.nextLine();
            switch(ans){
                case "1":
                    System.out.print("Enter new Calendar Name: ");
                    name = myObj.nextLine();
                    break;
                case "2":
                    isPublic = !isPublic;
                    System.out.print(name + " is now ");
                    if (isPublic){
                        System.out.println("public");
                    }else{
                        System.out.println("private");
                    }
                    break;
                case "exit":
                default:
                    break;
            }
        }
    }
}
