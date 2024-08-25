import java.security.SecureRandom;
import java.util.Scanner;

public class PasswordGenerator {

    // Define the character sets to be used
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_=+[]{}|;:,.<>?/";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask user for password length
        System.out.print("Enter the desired password length: ");
        int length = scanner.nextInt();

        // Ask user for complexity requirements
        System.out.print("Include uppercase letters? (yes/no): ");
        boolean includeUppercase = scanner.next().equalsIgnoreCase("yes");

        System.out.print("Include lowercase letters? (yes/no): ");
        boolean includeLowercase = scanner.next().equalsIgnoreCase("yes");

        System.out.print("Include digits? (yes/no): ");
        boolean includeDigits = scanner.next().equalsIgnoreCase("yes");

        System.out.print("Include special characters? (yes/no): ");
        boolean includeSpecial = scanner.next().equalsIgnoreCase("yes");

        // Generate password
        String password = generatePassword(length, includeUppercase, includeLowercase, includeDigits, includeSpecial);
        System.out.println("Generated password: " + password);
    }

    // Method to generate a password based on the given criteria
    public static String generatePassword(int length, boolean includeUppercase, boolean includeLowercase,
                                          boolean includeDigits, boolean includeSpecial) {
        StringBuilder characterSet = new StringBuilder();

        if (includeUppercase) {
            characterSet.append(UPPERCASE);
        }
        if (includeLowercase) {
            characterSet.append(LOWERCASE);
        }
        if (includeDigits) {
            characterSet.append(DIGITS);
        }
        if (includeSpecial) {
            characterSet.append(SPECIAL_CHARACTERS);
        }

        if (characterSet.length() == 0) {
            throw new IllegalArgumentException("At least one character type must be selected");
        }

        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder();

        // Generate random characters for the password
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(characterSet.length());
            password.append(characterSet.charAt(randomIndex));
        }

        return password.toString();
    }
}
