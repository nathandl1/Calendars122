import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    static String getChoice(Scanner scanner){
        System.out.println("What would you like to do?");
        System.out.println("1. View owned calendars");
        System.out.println("2. Create Calendar");
        System.out.println("Enter exit to end program.");
        return scanner.nextLine();
    }

    //static void createCalendar(Scanner scanner){
    //
    //}

    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Test Run?");
        String ans = myObj.nextLine();
        if (ans.equals("n")){
            System.out.print("Enter a username:");
            String userName = myObj.nextLine();
            Screen screen = new Screen(new User(userName));
            String choice = "0";
            while (!choice.equals("exit")){
                choice = getChoice(myObj);
                switch(choice){
                    case "1":
                        System.out.println(screen.currentUser.ownedCalendars);
                        break;
                    case "2":
                        System.out.println("Enter Calendar Type: ");
                        String calType = myObj.nextLine();
                        System.out.println("Enter Calendar Name: ");
                        String newName = myObj.nextLine();
                        screen.createCalendar(calType, newName);
                        break;
                    case "exit":
                        break;
                    default:
                        System.out.println("Not an option");
                        break;
                }
            }
        }else{
            Date date = new Date(1, 29, 2024);
            Time start = new Time(11, 50);
            Time end = new Time(13, 0);
            Event event = new Event("Default", date, start, end);
            event.display();
        }
    }
}