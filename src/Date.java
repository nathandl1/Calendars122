public class Date {
    int day;
    int month;
    int year;

    Date(int newMonth, int newDay, int newYear){
        month = newMonth;
        day = newDay;
        year = newYear;
    }

    void display(){
        System.out.println(month+"/"+day+"/"+year);
    }
}
