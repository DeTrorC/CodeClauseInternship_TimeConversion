import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.Set;
import java.util.Arrays;

public class TimeConversion {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Time Zone Conversion Tool");
        System.out.println("=========================");

        // List of time zones (you can extend this list)
        String[] allTimeZones = {
            "America/New_York",
            "America/Los_Angeles",
            "Europe/London",
            "Europe/Paris",
            "Asia/Tokyo",
            "Australia/Sydney",
            "Africa/Cairo",
            "Asia/Dubai",
            "Asia/Kolkata",
            "Asia/Shanghai",
            "Europe/Berlin",
            "Europe/Rome",
            "America/Chicago",
            "America/Toronto",
            "America/Mexico_City",
            "Pacific/Honolulu",
            "Australia/Melbourne",
            "Asia/Singapore",
            "Asia/Hong_Kong",
            "Europe/Madrid",
            "Africa/Johannesburg",
            "Europe/Amsterdam",
            "America/Phoenix",
            "Asia/Bangkok",
            "America/Buenos_Aires",
            "Pacific/Auckland",
            "Europe/Stockholm",
            "America/Denver",
            "America/Anchorage",
            "Asia/Seoul",
            "Africa/Lagos"
        };

        System.out.println("Common Time Zones:");
        for (int i = 0; i < allTimeZones.length; i++) {
            System.out.println((i + 1) + ". " + allTimeZones[i]);
        }
        System.out.print("Enter the number of your local time zone: ");
        int userLocalTimeZoneIndex = scanner.nextInt();
        String userLocalTimeZone = allTimeZones[userLocalTimeZoneIndex - 1];

        System.out.print("Enter the number of the target time zone: ");
        int targetTimeZoneIndex = scanner.nextInt();
        String targetTimeZone = allTimeZones[targetTimeZoneIndex - 1];

        ZoneId userLocalZone = ZoneId.of(userLocalTimeZone);
        ZoneId targetZone = ZoneId.of(targetTimeZone);

        ZonedDateTime userLocalTime = ZonedDateTime.now(userLocalZone);
        ZonedDateTime targetTime = userLocalTime.withZoneSameInstant(targetZone);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss z");

        System.out.println("\nYour Local Time (" + userLocalTimeZone + "): " + userLocalTime.format(formatter));
        System.out.println("Time in " + targetTimeZone + ": " + targetTime.format(formatter));

        scanner.close();
    }
}
