package com.antonelli.restjersey;

public class DayOfWeek {
	public static String dayOfWeek(int day, int month, int year) {
		int century = year / 100;
		month += 10;
		if(month>12) {
			month-=12;
		}
		year = year % 100;
		if (month > 10) {
			year = year - 1;
		}
		int week = (int) ((day + Math.floor(2.6 * month - 0.2) - 2 * century + year + Math.floor(year / 4)
						+ Math.floor(century / 4)) % 7);
		// Switch-case statement has more performance than if-else if number of cases is equal or greater than 5
		switch(week) {
			case 0:
				return "Sunday";
			case 1:
				return "Monday";
			case 2:
				return "Tuesday";
			case 3:
				return "Wednesday";
			case 4:
				return "Thursday";
			case 5:
				return "Friday";
			case 6:
				return "Saturday";
			default:
				return "Invalid Result";
		}
	}

	public static void main(String[] args) {
		int day = 20;
		int month = 2;
		int year = 2018;
		String result = DayOfWeek.dayOfWeek(day, month, year);
		System.out.println(result);
	}
}
