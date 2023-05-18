import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TimeConversionApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        
        // Get the local time from the user
        System.out.print("Enter local time (HH:mm): ");
        String localTimeStr = scanner.nextLine();
        LocalTime localTime = LocalTime.parse(localTimeStr, formatter);
        
        // Get the source time zone from the user
        System.out.print("Enter source time zone (e.g., America/New_York): ");
        String sourceTimeZoneId = scanner.nextLine();
        ZoneId sourceTimeZone = ZoneId.of(sourceTimeZoneId);
        ZonedDateTime sourceDateTime = ZonedDateTime.of(LocalDate.now(), localTime, sourceTimeZone);
        
        // Get the target time zone from the user
        System.out.print("Enter target time zone (e.g., Asia/Tokyo): ");
        String targetTimeZoneId = scanner.nextLine();
        ZoneId targetTimeZone = ZoneId.of(targetTimeZoneId);
        ZonedDateTime targetDateTime = sourceDateTime.withZoneSameInstant(targetTimeZone);
        
        // Print the converted time
        LocalTime convertedTime = targetDateTime.toLocalTime();
        System.out.println("Converted time: " + convertedTime.format(formatter));
    }
}
