
import java.util.Scanner;

public class TravelItineraryPlanner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("1. Select Destination");
            System.out.println("2. Enter Dates");
            System.out.println("3. Choose Preferences");
            System.out.println("4. Calculate Total Budget");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    selectDestination();
                    break;
                case 2:
                    enterDates();
                    break;
                case 3:
                    System.out.println("at first select the destination");
                    selectDestination();
                    break;
                case 4:
                    System.out.println("at first select the destination and preferences");
                    selectDestination();
                    break;

                case 5:
                    System.out.println("Exiting program. Thank you!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
        scanner.close();
    }

    private static void selectDestination() {
        int choice;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("1. Paris");
            System.out.println("2. Tokyo");
            System.out.println("3. New York");
            System.out.println("4. Australia");
            System.out.println("0. Back to Main Menu");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    choosePreferences("Paris");
                    break;
                case 2:
                    choosePreferences("Tokyo");
                    break;
                case 3:
                    choosePreferences("New York");
                    break;
                case 4:
                    choosePreferences("Australia");
                    break;
                case 0:
                    System.out.println("Going back to the Main Menu.");
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4 (or 0 to go back).");
            }
        } while (true);

    }

    private static void enterDates() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the date of travel: ");
        String date = scanner.nextLine();
        System.out.println("Dates entered.");
    }

    private static void choosePreferences(String destination) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("===== Planning trip to " + destination + " =====");

        System.out.println("Select your preferences:");
        System.out.println("1. Budget");
        System.out.println("2. Standard");
        System.out.println("3. Luxury");
        System.out.print("Enter your preference (1-3): ");
        int preference = scanner.nextInt();
        getPreferenceName(preference);
        double budget = calculateBudget(destination, preference);
        System.out.println("\n===== Trip Itinerary Summary =====");
        System.out.println("Destination: " + destination);
        System.out.println("Preference: " + getPreferenceName(preference));
        System.out.println("Total Budget: $" + budget);

        System.out.println("=================================");

    }

    private static String getPreferenceName(int preference) {
        switch (preference) {
            case 1:
                return "Budget";
            case 2:
                return "Standard";
            case 3:
                return "Luxury";
            default:
                return "Unknown";
        }
    }

    private static double calculateBudget(String destination, int preference) {
        double baseBudget;

        switch (destination.toLowerCase()) {
            case "paris":
                baseBudget = 1500.0;
                break;
            case "tokyo":
                baseBudget = 2000.0;
                break;
            case "new york":
                baseBudget = 1800.0;
                break;
            case "Australia":
                baseBudget = 2800.0;
                break;
            default:
                baseBudget = 0.0;
        }

        switch (preference) {
            case 1:
                return baseBudget;
            case 2:
                return baseBudget * 1.5;
            case 3:
                return baseBudget * 2.0;
            default:
                return 0.0;
        }

    }
}
