package assignment.JavaCodility;

import java.util.Scanner;
import java.util.regex.Pattern;

public class StrengthOfPassword {

	public String passwordStrength(String password) {

		if (password.length() < 8) {
			return "Entered password is too small";
		}

		Pattern upperCase = Pattern.compile("[A-Z]");
		Pattern lowerCase = Pattern.compile("[a-z]");
		Pattern digits = Pattern.compile("[0-9]");
		Pattern specialChar = Pattern.compile("[~`!@#$%^&*()|;:/?,.<>{}]");

		boolean hasUpperCase = upperCase.matcher(password).find();
		boolean hasLowerCase = lowerCase.matcher(password).find();
		boolean hasDigits = digits.matcher(password).find();
		boolean hasSpecialChar = specialChar.matcher(password).find();

		if (hasUpperCase && hasLowerCase && hasDigits && hasSpecialChar) {
			return "Strong";
		} else if ((hasUpperCase && hasLowerCase && hasDigits) || (hasUpperCase && hasLowerCase && hasSpecialChar)
				|| (hasUpperCase && hasDigits && hasSpecialChar) || (hasLowerCase && hasSpecialChar && hasDigits)) {
			return "Moderate";
		} else if ((hasUpperCase || hasLowerCase) && (hasDigits || hasSpecialChar)) {
			return "Easy";
		} else {
			return "Easy";
		}

	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the password: ");
		String password = sc.nextLine();
		
		StrengthOfPassword sp = new StrengthOfPassword();
		
		String strength = sp.passwordStrength(password);
		
		System.out.println("Strength of password: " + strength);

	}

}
