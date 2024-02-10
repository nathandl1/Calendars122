Java version info:
java 19.0.1 2022-10-18
Java(TM) SE Runtime Environment (build 19.0.1+10-21)
Java HotSpot(TM) 64-Bit Server VM (build 19.0.1+10-21, mixed mode, sharing)

To start the program, run Main.java. It will prompt you to enter a username. This is the first user's username.
It will create a default calendar for the first user as well. You can now access the first choices menu.
The choices menu allows you to

1. View All Owned calendars
- all calendars owned by the current user
2. View Specific Calendar
- runs the display function on a calendar that you specify by name (Case-sensitive)
3. Manage Calendars
- enter the calendar management window
4. Manage Events for Calendar: (currentCalendar name)
- enter the events manager for the current calendar
5. Change current user
- change to another user via entering a username, or if that username doesn't exist will create a new user
exit
- exits the program

Upon selecting 3 in the choices menu you enter the calendar manager menu where you can
1. Create a new Calendar
2. Delete an existing Calendar
3. Edit the current calendar
- runs the Calendar's edit() function if found
4. Change Calendar
- enter a calendar's name to change the currentCalendar to it (Case sensitive)
exit
- return to the choices menu

upon selecting 4 in the choices menu you enter the event manager menu
-NOTE: this can only affect the CURRENT CALENDAR,
go back to choices menu and select manage calendars to edit currentCalendar
1. Create a new event
2. Delete Event
3. Edit Event
-runs the edit() method on an event that you specify by name
exit
- return to choices menu

All options will prompt you for answers and give you specific formats when needed.

WARNINGS:
Deleting the current active calendar may cause issues
Creating two public calendars with the exact same name will cause 2. View Specific Calendar to display both calendars
