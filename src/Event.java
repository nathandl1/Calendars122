import java.util.Scanner;
import java.util.Set;
public class Event implements IsEditable, IsVisible{
    String name; //new
    boolean isPublic;
    Date date;
    Time startTime;
    Time endTime;
    //Set<Calendar> canView;
    //Set<Calendar> canEdit;
    private final Scanner myObj = new Scanner(System.in);

    Event(String newName, Date newDate, Time start, Time end){
        name=newName;
        date=newDate;
        startTime=start;
        endTime=end;
    }

    void togglePublic(){
        isPublic = !isPublic;
    }

    @Override
    public void edit() {
        String ans = "0";
        while (!ans.equals("exit")){
            System.out.println("What would you like to change?");
            System.out.println("1.Name 2.Date 3.startTime 4.endTime 5.Publicity");
            System.out.println("Enter exit to cancel.");
            ans = myObj.nextLine();
            switch(ans){
                case "1":
                    System.out.print("Enter new Event Name: ");
                    name = myObj.nextLine();
                    break;
                case "2":
                    System.out.println("Enter new Date: DD/MM/YYYY");
                    String tempDate = myObj.nextLine();
                    String[] arrOfStr = tempDate.split("/", 3);
                    date = new Date(Integer.parseInt(arrOfStr[0]), Integer.parseInt(arrOfStr[1]), Integer.parseInt(arrOfStr[2]));
                    break;
                case "3":
                    System.out.println("Enter new 24hr Time: HH:MM");
                    String tempTime = myObj.nextLine();
                    String[] arrTime = tempTime.split(":", 2);
                    startTime = new Time(Integer.parseInt(arrTime[0]), Integer.parseInt(arrTime[1]));
                    break;
                case "4":
                    System.out.println("Enter new 24hr Time: HH:MM");
                    String tempTime2 = myObj.nextLine();
                    String[] arrTime2 = tempTime2.split(":", 2);
                    endTime = new Time(Integer.parseInt(arrTime2[0]), Integer.parseInt(arrTime2[1]));
                    break;
                default:
                    System.out.println("Not an option");
                    break;
            }
        }
    }

    @Override
    public void display() {
        System.out.println("Event: " + name);
        System.out.print("On: ");
        date.display();
        System.out.print("Starts at: ");
        startTime.display();
        System.out.print("Ends at: ");
        endTime.display();
    }
}
