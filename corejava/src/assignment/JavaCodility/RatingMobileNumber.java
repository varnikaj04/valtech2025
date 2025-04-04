package assignment.JavaCodility;

import java.util.Scanner;

public class RatingMobileNumber {

	public static boolean isPalindrome(String number) {
		for (int i = 1; i < number.length()/2; i++) {
			if (number.charAt(i) != number.charAt(number.length()-i-1)) {
				return false;
			}
		}
		return true;
	}

	public static boolean hasRepeatingDigits(String number) {
		for (int i = 1; i <= number.length(); i++) {
			if (number.charAt(i) != number.charAt(0)) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter a mobile no.:");
		String number = scanner.nextLine();

		int score = rateMobile(number);
		System.out.println("Rating of mobile no - " + number + " is: " + score);
	}

	public static int rateMobile(String number) {
		int score = 0;
		if (number.length() < 10) {
			score = 0;
			System.out.println("Number is not valid!");
		} else {
			score += 1;
		}
		if (isPalindrome(number)) {
			score += 3;
		}
		if (hasRepeatingDigits(number)) {
			score += 2;
		}
		return score;
	}

}
