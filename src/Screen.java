import java.util.*;

public class Screen {
    public static Scanner myObj = new Scanner(System.in);
    static User currentUser;
    static Calendar currentCalendar;
    static Set<User> users = new HashSet<User>(); //new
    static Set<Calendar> calendars = new HashSet<Calendar>();
    static CalendarGenerator calGen = new CalendarGenerator();
    static void createFirstUser(String name){
        User first = User.getInstance(name);
        currentUser = first;
        currentCalendar = calGen.createCalendar("Default" + currentUser.getUsername(), "none");
        currentUser.ownedCalendars.add(currentCalendar);
        calendars.add(currentCalendar);
        addToUsers(first);
    }

    static void addToUsers(User user){
        if (!users.add(user)){
            System.out.println("User Already Exists");
        }
    }
    private static void changeUser(){
        System.out.print("Enter a username: ");
        String nName = myObj.nextLine();
        for (User user : users){
            if (user.getUsername().equals(nName)){
                currentUser = user;
                currentCalendar = user.ownedCalendars.iterator().next();
                return;
            }
        }
        System.out.println("User not found. Create User? y/n ");
        String boof = myObj.nextLine();
        if (boof.equals("y")){
            currentUser= User.getInstance(nName);
            currentCalendar = calGen.createCalendar("Default" + nName, "none");
            currentUser.ownedCalendars.add(currentCalendar);
            calendars.add(currentCalendar);
            users.add(currentUser);
        }
    }
    static String getChoice() {
        System.out.println("What would you like to do " + currentUser.getUsername() + "?");
        System.out.print("1. View All Owned Calendars");
        System.out.println("\t2. View Specific Calendar");
        System.out.print("3. Manage Calendars");
        System.out.println("\t\t\t4. Manage Events for Calendar: " + currentCalendar.name);
        System.out.println("5. Change Current User");
        System.out.println("Enter exit to end program.");
        return myObj.nextLine();
    }

    static String calManageChoice(){
        System.out.println("Active Calendar: " + currentCalendar.name);
        System.out.print("1. Create New Calendar");
        System.out.println("\t\t2. Delete Calendar");
        System.out.print("3. Edit Current Calendar");
        System.out.println("\t\t4. Change Calendar");
        System.out.println("Enter exit to go back");
        System.out.print("Choose an option: ");
        return myObj.nextLine();
    }

    private static void manageCalendars(){
        String ans = "";
        while (!ans.equals("exit")){
            ans = calManageChoice();
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
        Calendar tempCalendar = calGen.createCalendar(newName, calType);
        if (calendars.add(tempCalendar)){
            currentUser.addCalendar(tempCalendar);
        }
    }
    static void deleteCalendar(){
        System.out.print("Enter Calendar Name to Delete: ");
        String calName = myObj.nextLine();
        for (Calendar calPtr : currentUser.ownedCalendars){
            if (calPtr.name.equals(calName)){
                if (calPtr == currentCalendar){
                    System.out.println("Cannot Delete Current Calendar!");
                }else{
                    currentUser.ownedCalendars.remove(calPtr);
                    calendars.remove(calPtr);
                    return;
                }
            }
        }
    }
    private static void viewSpecificCalendar(){ //option 2
        System.out.println("Enter Calendar name: ");
        String calName = myObj.nextLine();
        for (Calendar calPtr : calendars){
            if (calPtr.name.equals(calName)){
                System.out.println("Calendar Found!");
                if(calPtr.isPublic || currentUser.ownedCalendars.contains(calPtr)){
                    calPtr.display();
                }else{
                    System.out.println("Calendar not accessible by " + currentUser.getUsername());
                }
                return;
            }
        }
        System.out.println("Calendar not found");
    }
    static void editCalendar(){
        System.out.print("Enter Calendar Name to Edit: ");
        String calName = myObj.nextLine();
        for (Calendar calPtr : currentUser.ownedCalendars){
            if (calPtr.name.equals(calName)){
                calPtr.edit();
            }
        }
    }
    private static void changeCalendar() {
        boolean flag = false;
        System.out.print("Enter the Calendar Name: ");
        String tempName = myObj.nextLine();
        for (Calendar tempPtr : currentUser.ownedCalendars){
            if (tempPtr.name.equals(tempName)){
                currentCalendar=tempPtr;
                flag = true;
                break;
            }
        }
        if (flag){
            System.out.println("Current Calendar = " + currentCalendar.name);
        }else{
            System.out.println(tempName + " is not a part of " + currentUser.getUsername() + "'s calendars");
        }
    }
    private static String eventManageChoice(){
        System.out.println("Active Calendar: " + currentCalendar.name);
        System.out.print("1. Create New Event");
        System.out.println("\t\t2. Delete Event");
        System.out.println("3. Edit Event");
        System.out.println("Enter exit to go back");
        System.out.print("Choose an option: ");
        return myObj.nextLine();
    }
    private static void manageEvents(){
        String ans = "";
        while (!ans.equals("exit")){
            ans = eventManageChoice();
            switch(ans){
                case "1":
                    createEvent();
                    break;
                case "2":
                    deleteEvent();
                    break;
                case "3":
                    editEvent();
                    break;
                case "exit":
                    break;
                default:
                    break;
            }
        }
    }
    private static void createEvent(){
        boolean flag = false;
        System.out.print("Enter Event Name: ");
        String eName = myObj.nextLine();
        for (Event e : currentCalendar.events){
            if (e.name.equals(eName)){
                flag = true;
                break;
            }
        }
        if (!flag){
            System.out.println("Enter Date: DD/MM/YYYY");
            String tempDate = myObj.nextLine();
            String[] arrOfStr = tempDate.split("/", 3);
            Date eDate = new Date(Integer.parseInt(arrOfStr[0]), Integer.parseInt(arrOfStr[1]), Integer.parseInt(arrOfStr[2]));
            System.out.println("Enter Starting Time (24hr): HH:MM");
            String tempTime = myObj.nextLine();
            String[] arrTime = tempTime.split(":", 2);
            Time sTime = new Time(Integer.parseInt(arrTime[0]), Integer.parseInt(arrTime[1]));
            System.out.println("Enter Ending Time (24hr): HH:MM");
            tempTime = myObj.nextLine();
            arrTime = tempTime.split(":", 2);
            Time eTime = new Time(Integer.parseInt(arrTime[0]), Integer.parseInt(arrTime[1]));
            currentCalendar.addEvent(new Event(eName, eDate, sTime, eTime));
        }else{
            System.out.println("Event name taken!");
        }
    }
    private static void deleteEvent(){
        System.out.print("Enter Event Name: ");
        String eName = myObj.nextLine();
        currentCalendar.events.removeIf(e -> e.name.equals(eName));
        System.out.println("Event " + eName + " removed");
    }
    private static void editEvent(){
        System.out.print("Enter Event Name: ");
        String eName = myObj.nextLine();
        for (Event e : currentCalendar.events){
            if (e.name.equals(eName)){
                e.edit();
            }
        }
    }
    public static void main(String[] args) {
            System.out.print("Enter a username:");
            String userName = myObj.nextLine();
            createFirstUser(userName);
            String choice = "0";
            while (!choice.equals("exit")){
                choice = getChoice();
                switch(choice){
                    case "1": //view owned Calendars
                        currentUser.listOwnedCalendars();
                        break;
                    case "2": //viewSpecificCalendar
                        viewSpecificCalendar();
                        break;
                    case "3": //manageCalendars
                        manageCalendars();
                        break;
                    case "4": //manageEvents
                        manageEvents();
                        break;
                    case "5": //changeUser
                        changeUser();
                        break;
                    case "exit":
                        break;
                    default:
                        System.out.println("Not an option");
                        break;
                }
                System.out.println();
            }
    }


}
