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
        System.out.println("4. Change Calendar");
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
            System.out.println("----------------");
        }
    }

    private static void viewOwnedCalendars() {
        for (Calendar disCal : screen.currentUser.ownedCalendars){
            System.out.println(disCal.name);
        }
    }

    private static void changeCalendar() {
        boolean flag = false;
        System.out.println("Enter the name of the calendar: ");
        String ans = myObj.nextLine();
        for (Calendar tempCal : screen.currentUser.ownedCalendars){
            if (tempCal.name.equals(ans)){
                flag = true;
                screen.currentCalendar = tempCal;
                System.out.println("Current Calendar changed to: " + screen.currentCalendar.name);
                break;
            }
        }
        if (!flag){
            System.out.println("Cannot find " + ans + " in User's Calendars");
        }
    }

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
                    case "1": // view calendars owned by current User
                        viewOwnedCalendars();
                        break;
                    case "2": // runs .display on all owned calendars
                        displayOwnedCal();
                        break;
                    case "3": // creates a calendar
                        createCalendar();
                        break;
                    case "4": // select calendar
                        changeCalendar();
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