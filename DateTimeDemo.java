import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class DateTimeDemo {
    public static void main(String[] args) {
        LocalDate currentDate = LocalDate.now();
        LocalTime currentTime = LocalTime.now();
        LocalDateTime currentDateTime = LocalDateTime.now();

        System.out.println("Current date: " + currentDate);
        System.out.println("Current time: " + currentTime);
        System.out.println("Current date time: " + currentDateTime);

        System.out.println(
                "Formatted current date: " + currentDate.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
        System.out.println(
                "Formatted current time: " + currentTime.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT)));

        System.out.println(
                "Formatted current date (custom format): "
                        + currentDate.format(DateTimeFormatter.ofPattern("dd-MMM-yy")));
        System.out.println(
                "Formatted current time (custom format): "
                        + currentTime.format(DateTimeFormatter.ofPattern("HH:mm:ss")));

        LocalDate parsedDate = LocalDate.parse("2022-10-11");
        System.out.println("Parsed date: " + parsedDate);

        LocalDateTime parsedDateTime = LocalDateTime.parse("June 30, 2021 12:01 AM",
                DateTimeFormatter.ofPattern("MMMM d, yyyy h:mm a", Locale.ENGLISH));

        System.out.println("Parsed date time: " + parsedDateTime);
    }
}
