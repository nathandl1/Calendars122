public class Time {
    String timeZone;
    int hour;
    int minute;

    Time(int newHour, int newMinute, String newZone){
        hour = newHour;
        minute = newMinute;
        timeZone = newZone;
    }
    Time(int newHour, int newMinute){
        this(newHour, newMinute, "PST");
    }


}
