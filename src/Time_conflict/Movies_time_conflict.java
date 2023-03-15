package Time_conflict;

import java.util.Scanner;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Movies_time_conflict {
	static Scanner sc = new Scanner (System.in);
	public static void main(String[] args) {
		String recommendation = "doporuceni: ";
		
		System.out.println("zacatek filmu A: ");
		System.out.println("hodina: ");
		int startHoursA = sc.nextInt();
		System.out.println("minuta: ");
		int startMinutesA = sc.nextInt();
		System.out.println("delka filmu A:");
		System.out.println("hodina: ");
		int lengthHoursA = sc.nextInt();
		System.out.println("minuta: ");
		int lengthMinutesA = sc.nextInt();
		
		System.out.println("\nzacatek filmu B: ");
		System.out.println("hodina: ");
		int startHoursB = sc.nextInt();
		System.out.println("minuta: ");
		int startMinutesB = sc.nextInt();
		System.out.println("delka filmu B:");
		System.out.println("hodina: ");
		int lengthHoursB = sc.nextInt();
		System.out.println("minuta: ");
		int lengthMinutesB = sc.nextInt();
		
//		int startHoursA = 0;
//		int startMinutesA = 30;
//		int lengthHoursA = 2;
//		int lengthMinutesA = 1;
//		
//		int startHoursB = 0;
//		int startMinutesB = 31;
//		int lengthHoursB = 2;
//		int lengthMinutesB = 00;
		
		int dayA = 4;
		if((startHoursA >= 0 && startHoursA < 3)) {
			dayA = 5;	
		} 		
		LocalDateTime movieStartA = LocalDateTime.of(2022, 4, dayA, startHoursA, startMinutesA);
//		LocalTime movieDurationA = LocalTime.of(lengthHoursA, lengthMinutesA);
		LocalDateTime endMovieA = movieStartA.plusHours(lengthHoursA).plusMinutes(lengthMinutesA);
		
		int dayB = 4;
		if((startHoursB >= 0 && startHoursB < 3)) {
			dayB = 5;	
		}

		LocalDateTime movieStartB = LocalDateTime.of(2022, 4, dayB, startHoursB, startMinutesB);
//		LocalTime movieDurationB = LocalTime.of(lengthHoursB, lengthMinutesB);
		LocalDateTime endMovieB = movieStartB.plusHours(lengthHoursB).plusMinutes(lengthMinutesB);	
		
//		System.out.println("movieStartA: \t\t" + movieStartA);
////		System.out.println("movieDurationA: \t" + movieDurationA);
//		System.out.println("endMovieA: \t\t" + endMovieA);
//		
//		System.out.println("\nmovieStartB: \t\t" + movieStartB);
////		System.out.println("movieDurationB: \t" + movieDurationB);
//		System.out.println("endMovieB: \t\t" + endMovieB);
		if(isOpen(movieStartA) && isOpen(movieStartB)) {
			return;
		}
		
		 int durationAendToBstart = (int)(Duration.between(endMovieA, movieStartB)).toMinutes(); // Bs - As
		 int durationAendToBend = (int)(Duration.between(endMovieA, endMovieB)).toMinutes();	// Be - Ae	
		 
//		 System.out.println(durationAendToBstart + " minutes");
//		 System.out.println(durationAendToBend + " minutes");
		 
		 if(durationAendToBstart >= 0) {
			 System.out.println(recommendation+ "v pohode");
		 }
		 else if(durationAendToBend <= 0) {
			 System.out.println(recommendation+"to nedas");
		 }
		 else {
			 durationAendToBstart = durationAendToBstart * (-1);
			 System.out.format(recommendation+ "neuvidis %d minut", durationAendToBstart);
		 }
	}
	
	public static boolean isOpen(LocalDateTime time) {
		LocalTime openingHours = LocalTime.of(14, 00);
		LocalTime closingHours = LocalTime.of(3, 0);
		return openingHours.isBefore(LocalTime.of(time.getHour(), time.getMinute())) 
				&& closingHours.isAfter(LocalTime.of(time.getHour(), time.getMinute()));
		}
}