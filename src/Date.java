import java.util.Scanner;

public class Date implements IsEditable, IsVisible {
    int day;
    int month;
    int year;
    Scanner myObj = new Scanner(System.in);

    Date(int newMonth, int newDay, int newYear){
        month = newMonth;
        day = newDay;
        year = newYear;
    }

    public void display(){
        System.out.println(month+"/"+day+"/"+year);
    }
    public void edit(){
        String ans = "0";
        while (!ans.equals("exit")){
            System.out.println("What would you like to change?");
            System.out.println("1.Month 2.Day 3.Year");
            System.out.println("Enter exit to cancel.");
            ans = myObj.nextLine();
            switch(ans){
                case "1":
                    System.out.println("Enter new Month: ");
                    month = Integer.parseInt(myObj.nextLine());
                    break;
                case "2":
                    System.out.println("Enter new Day: ");
                    day = Integer.parseInt(myObj.nextLine());
                    break;
                case "3":
                    System.out.println("Enter new Year: ");
                    year = Integer.parseInt(myObj.nextLine());
                    break;
                default:
                    System.out.println("Not an option");
                    break;
            }
        }
    }
}
