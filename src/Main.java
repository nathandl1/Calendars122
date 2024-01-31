import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static Scanner myObj = new Scanner(System.in);
    static Screen screen;
    static String getChoice(){
        System.out.println("What would you like to do?");
        System.out.println("1. View owned calendars");
        System.out.println("2. Display all Owned Calendars");
        System.out.println("3. Create Calendar");
        System.out.println("4. Select Calendar");
        System.out.println("5. Change User");
        System.out.println("6. Create Event for " + screen.currentCalendar.name + " Calendar");
        System.out.println("Enter exit to end program.");
        return myObj.nextLine();
    }

    static void createCalendar(){
        System.out.println("Enter Calendar Type: ");
        String calType = myObj.nextLine();
        System.out.println("Enter Calendar Name: ");
        String newName = myObj.nextLine();
        screen.createCalendar(calType, newName);
    }

    static void displayOwnedCal(){
        for (Calendar disCal : screen.currentUser.ownedCalendars){
            disCal.display();
        }
    }

    private static void viewOwnedCalendars() {
        for (Calendar disCal : screen.currentUser.ownedCalendars){
            System.out.println(disCal.name);
        }
    }

    //static void createCalendar(Scanner scanner){
    //
    //}

    public static void main(String[] args) {
        System.out.println("Test Run?");
        String ans = myObj.nextLine();
        if (ans.equals("n")){
            System.out.print("Enter a username:");
            String userName = myObj.nextLine();
            screen = new Screen(new User(userName));
            String choice = "0";
            while (!choice.equals("exit")){
                choice = getChoice();
                switch(choice){
                    case "1": //view owned Calendars
                        viewOwnedCalendars();
                        break;
                    case "2":
                        displayOwnedCal();
                        break;
                    case "3": //createCalendar
                        createCalendar();
                        break;
                    case "exit":
                        break;
                    default:
                        System.out.println("Not an option");
                        break;
                }
                System.out.println();
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