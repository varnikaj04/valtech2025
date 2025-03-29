package assignment.JavaCodility;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeDifferenceCalculator {
	
	public static void calculateDiffernce(String time1, String time2) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime t1 = LocalDateTime.parse(time1, formatter);
		LocalDateTime t2 = LocalDateTime.parse(time2, formatter);
		
		Duration duration = Duration.between(t1, t2);
		long days = duration.toDays();
		long hours = duration.toHours() % 24;
		long minutes = duration.toMinutes() % 60;
		long seconds = duration.toSeconds() % 60;
		
		System.out.println("Difference between " + time1 + "and" + time2 + "is: ");
		System.out.println(days + " days" + hours + " hours" + minutes + " minutes" + seconds + " seconds");
	}
	
	public static void main(String[] args) {
		String time1 = "2025-03-20 10:50:00";
		String time2 = "2025-03-22 12:30:00";
		
		calculateDiffernce(time1, time2);
	}

}
