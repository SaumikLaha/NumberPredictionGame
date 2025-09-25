import java.util.Random;
import java.util.Scanner;

public class NumberPredictionGame {

    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();
    private static int bestScore = Integer.MAX_VALUE; // lower is better

    public static void main(String[] args) {
        printWelcome();

        boolean playAgain = true;
        while (playAgain) {
            int[] difficulty = chooseDifficulty();
            int maxNumber = difficulty[0];
            int maxAttempts = difficulty[1]; // -1 means unlimited

            playRound(maxNumber, maxAttempts);

            System.out.print("\nDo you want to play again? (yes/no): ");
            String answer = scanner.nextLine().trim().toLowerCase();
            playAgain = answer.equals("yes") || answer.equals("y");
        }

        printGoodbye();
        scanner.close();
    }

    private static void printWelcome() {
        System.out.println("=========================================");
        System.out.println("   Welcome to Number Prediction Game!");
        System.out.println("   Guess the number and get hints: Too high / Too low");
        System.out.println("=========================================");
    }

    // returns [maxNumber, maxAttempts]
    private static int[] chooseDifficulty() {
        System.out.println("\nChoose difficulty level:");
        System.out.println("1. Easy   (range 1-50, max attempts 10)");
        System.out.println("2. Medium (range 1-100, max attempts 7)");
        System.out.println("3. Hard   (range 1-200, max attempts 5)");
        System.out.println("4. Custom (you set range and attempts)");
        System.out.print("Enter choice (1-4): ");

        int choice = readIntFromUser();
        if (choice == 1) return new int[] {50, 10};
        if (choice == 2) return new int[] {100, 7};
        if (choice == 3) return new int[] {200, 5};
        if (choice == 4) {
            System.out.print("Enter maximum number for range (min 10): ");
            int maxNum = Math.max(10, readIntFromUser());
            System.out.print("Enter maximum attempts (-1 for unlimited): ");
            int attempts = readIntFromUserAllowNegativeOne();
            return new int[] {maxNum, attempts};
        }
        // default medium
        System.out.println("Invalid choice. Defaulting to Medium.");
        return new int[] {100, 7};
    }

    private static void playRound(int maxNumber, int maxAttempts) {
        int target = random.nextInt(maxNumber) + 1;
        int attempts = 0;
        boolean guessed = false;

        System.out.println("\nI'm thinking of a number between 1 and " + maxNumber + ".");
        if (maxAttempts > 0) {
            System.out.println("You have up to " + maxAttempts + " attempts. Good luck!");
        } else {
            System.out.println("You have unlimited attempts. Good luck!");
        }

        while (maxAttempts == -1 || attempts < maxAttempts) {
            attempts++;
            System.out.print("Attempt " + attempts + ". Enter your guess: ");
            int guess = readIntFromRange(1, maxNumber);

            if (guess == target) {
                System.out.println("🎉 Correct! You guessed the number in " + attempts + " attempt(s).");
                guessed = true;
                if (attempts < bestScore) {
                    bestScore = attempts;
                    System.out.println("🏆 New best score! (" + bestScore + " attempts)");
                } else if (bestScore != Integer.MAX_VALUE) {
                    System.out.println("Your best score so far: " + bestScore + " attempt(s).");
                }
                break;
            } else if (guess < target) {
                System.out.println("Too low! Try a higher number.");
            } else {
                System.out.println("Too high! Try a lower number.");
            }
        }

        if (!guessed) {
            System.out.println("\nYou've used up your attempts (or quit). The number was: " + target);
            if (bestScore != Integer.MAX_VALUE) {
                System.out.println("Best score so far: " + bestScore + " attempt(s).");
            }
        }
    }

    // read integer, reprompt until valid
    private static int readIntFromUser() {
        while (true) {
            String line = scanner.nextLine().trim();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.print("Invalid number. Please enter again: ");
            }
        }
    }

    // allow -1 for unlimited attempts
    private static int readIntFromUserAllowNegativeOne() {
        while (true) {
            String line = scanner.nextLine().trim();
            try {
                int v = Integer.parseInt(line);
                if (v == -1 || v >= 1) return v;
                System.out.print("Please enter -1 or a number >= 1: ");
            } catch (NumberFormatException e) {
                System.out.print("Invalid number. Please enter again: ");
            }
        }
    }

    // read integer and ensure it's in [min, max]
    private static int readIntFromRange(int min, int max) {
        while (true) {
            String line = scanner.nextLine().trim();
            try {
                int v = Integer.parseInt(line);
                if (v >= min && v <= max) return v;
                System.out.print("Please enter a number between " + min + " and " + max + ": ");
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Enter a valid integer: ");
            }
        }
    }

    private static void printGoodbye() {
        System.out.println("\nThank you for playing Number Prediction Game!");
        if (bestScore != Integer.MAX_VALUE) {
            System.out.println("Your best score: " + bestScore + " attempt(s).");
        }
        System.out.println("Goodbye!");
    }
}
