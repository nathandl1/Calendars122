import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static Scanner myObj = new Scanner(System.in);
    static Screen screen;
    static String getChoice(){
        System.out.println("What would you like to do " + screen.currentUser.username +"?");
        System.out.print("1. View All Owned Calendars");
        System.out.println("\t2. View Specific Calendar");
        System.out.print("3. Manage Calendars");
        System.out.println("\t\t\t4. Manage Events for Calendar: " + screen.currentCalendar.name);
        System.out.println("5. Change Current User");
        System.out.println("Enter exit to end program.");
        return myObj.nextLine();
    }
    private static void viewOwnedCalendars() { //option 1
        for (Calendar disCal : screen.currentUser.ownedCalendars){
            System.out.print(disCal.name + " ");
        }
    }
    private static void viewSpecificCalendar(){ //option 2
        System.out.print("Enter Calendar name: ");
        String calName = myObj.nextLine();
        for (Calendar calPtr : screen.calendars){
            if (calPtr.name.equals(calName)){
                if(calPtr.isPublic || screen.currentUser.ownedCalendars.contains(calPtr)){
                    calPtr.display();
                }
            }
        }
        System.out.println();
    }
    private static void manageCalendars(){
        String ans = "";
        while (!ans.equals("exit")){
            System.out.print("Active Calendar: " + screen.currentCalendar);
            System.out.print("1. Create New Calendar");
            System.out.println("\t\t2. Delete Calendar");
            System.out.print("3. Edit Current Calendar");
            System.out.println("\t\t4. Change Calendar");
            System.out.print("Choose an option: ");
            ans = myObj.nextLine();
            switch(ans){
                case "1": //createCalendar
                    createCalendar();
                    break;
                case "2": //deleteCalendar
                    deleteCalendar();
                    break;
                case "3": //editCalendar;
                    editCalendar();
                    break;
                case "4": //changeCalendar;
                    changeCalendar();
                    break;
                case "exit":
                    break;
                default:
                    break;
            }
        }

    }
    static void createCalendar(){
        System.out.print("Enter Calendar Type: ");
        String calType = myObj.nextLine();
        System.out.print("Enter Calendar Name: ");
        String newName = myObj.nextLine();
        System.out.println("Private? (true / false)");
        boolean privacy = Boolean.parseBoolean(myObj.nextLine());
        screen.createCalendar(calType, newName, privacy);
    }
    static void deleteCalendar(){
        System.out.print("Enter Calendar Name to Delete: ");
        String calName = myObj.nextLine();
        for (Calendar calPtr : screen.currentUser.ownedCalendars){
            if (calPtr.name.equals(calName)){
                screen.deleteCalendar(calPtr);
            }
        }
    }
    static void editCalendar(){
        System.out.print("Enter Calendar Name to Edit: ");
        String calName = myObj.nextLine();
        for (Calendar calPtr : screen.currentUser.ownedCalendars){
            if (calPtr.name.equals(calName)){
                calPtr.edit();
            }
        }
    }
    private static void changeCalendar() {
        boolean flag = false;
        System.out.print("Enter the Calendar Name: ");
        String tempName = myObj.nextLine();
        for (Calendar tempPtr : screen.currentUser.ownedCalendars){
            if (tempPtr.name.equals(tempName)){
                screen.currentCalendar=tempPtr;
                flag = true;
                break;
            }
        }
        if (flag){
            System.out.println("Current Calendar = " + screen.currentCalendar.name);
        }else{
            System.out.println(tempName + " is not a part of " + screen.currentUser.username + "'s calendars");
        }

    }
    private static void changeUser(){

    }
    private static void createEvent(){

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
                    case "1": //view owned Calendars
                        viewOwnedCalendars();
                        break;
                    case "2": //viewSpecificCalendar
                        viewSpecificCalendar();
                        break;
                    case "3": //manageCalendars
                        manageCalendars();
                        break;
                    case "4": //manageEvents

                        break;
                    case "5": //changeUser

                        break;
                    case "6":

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