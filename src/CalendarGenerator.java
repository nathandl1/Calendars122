public class CalendarGenerator {
    public Calendar createCalendar(String name, String type){
        if (type.equalsIgnoreCase("gregorian")){
            return new GregorianCalendar(type.toLowerCase(), name);
        }else{
            System.out.println("Not a special or recognized calendar type, making default Calendar...");
            return new Calendar(name);
        }
    }
}
