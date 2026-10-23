import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Game game = new Game();

        boolean running = true;

        while (running) {

            System.out.println("\n==============================");
            System.out.println("       🎲 DICE GAME");
            System.out.println("==============================");

            System.out.println("1. Play Dice Game");
            System.out.println("2. View Game History");
            System.out.println("3. View Statistics");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");

            try {

                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {

                    case 1:

                        System.out.print(
                            "Enter number of rounds to play: "
                        );

                        int rounds = Integer.parseInt(sc.nextLine());

                        game.playGame(rounds);

                        break;

                    case 2:

                        game.displayHistory();

                        break;

                    case 3:

                        game.displayStatistics();

                        break;

                    case 4:

                        running = false;

                        System.out.println(
                            "Thank you for playing Dice Game!"
                        );

                        break;

                    default:

                        System.out.println(
                            "Invalid choice! Select 1 to 4."
                        );
                }

            } catch (InvalidRoundsException e) {

                System.out.println("Error: " + e.getMessage());

            } catch (NumberFormatException e) {

                System.out.println(
                    "Invalid input! Please enter a number."
                );

            } catch (Exception e) {

                System.out.println(
                    "Unexpected error: " + e.getMessage()
                );
            }
        }

        sc.close();
    }
}