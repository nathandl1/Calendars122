import java.util.Scanner;

public class Time implements IsEditable, IsVisible {
    String timeZone;
    int hour;
    int minute;
    Scanner myObj = new Scanner(System.in);
    Time(int newHour, int newMinute, String newZone){
        hour = newHour;
        minute = newMinute;
        timeZone = newZone;
    }
    Time(int newHour, int newMinute){
        this(newHour, newMinute, "PST");
    }
    @Override
    public void edit() {
        String ans = "0";
        while (!ans.equals("exit")){
            System.out.println("What would you like to change?");
            System.out.println("1.Hour 2.Minute");
            System.out.println("Enter exit to cancel.");
            ans = myObj.nextLine();
            switch(ans){
                case "1":
                    System.out.println("Enter new Hour: ");
                    hour = Integer.parseInt(myObj.nextLine());
                    break;
                case "2":
                    System.out.println("Enter new Minute: ");
                    minute = Integer.parseInt(myObj.nextLine());
                    break;
                case "exit":
                    break;
                default:
                    System.out.println("Not an option");
                    break;
            }
        }
    }
    @Override
    public void display() {
        System.out.println(hour+ " Hours, " + minute + " Minutes");
    }
}
