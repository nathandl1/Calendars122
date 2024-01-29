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

    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
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
                    screen.createCalendar(calType);
                    break;
                default:
                    break;
            }
        }
    }
}