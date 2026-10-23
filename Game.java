import java.util.ArrayList;

public class Game {

    private Dice dice;
    private ArrayList<GameResult> gameHistory;

    private int playerWins;
    private int computerWins;
    private int draws;

    public Game() {
        dice = new Dice();
        gameHistory = new ArrayList<>();

        playerWins = 0;
        computerWins = 0;
        draws = 0;
    }

    public void playRound(int roundNumber) {

        int playerScore = dice.rollDice();
        int computerScore = dice.rollDice();

        String result;

        System.out.println("\n------ Round " + roundNumber + " ------");

        System.out.println("You rolled: " + playerScore);
        System.out.println("Computer rolled: " + computerScore);

        if (playerScore > computerScore) {

            result = "Player Wins";
            playerWins++;

            System.out.println("Congratulations! You win!");

        } else if (computerScore > playerScore) {

            result = "Computer Wins";
            computerWins++;

            System.out.println("Computer wins this round!");

        } else {

            result = "Draw";
            draws++;

            System.out.println("It's a draw!");
        }

        GameResult gameResult = new GameResult(
            roundNumber,
            playerScore,
            computerScore,
            result
        );

        gameHistory.add(gameResult);
    }

    public void playGame(int rounds)
            throws InvalidRoundsException {

        if (rounds <= 0) {
            throw new InvalidRoundsException(
                "Number of rounds must be greater than zero."
            );
        }

        for (int i = 1; i <= rounds; i++) {
            playRound(i);
        }

        displayStatistics();
    }

    public void displayHistory() {

        System.out.println("\n====== GAME HISTORY ======");

        if (gameHistory.isEmpty()) {
            System.out.println("No games played yet.");
            return;
        }

        gameHistory.forEach(GameResult::displayResult);
    }

    public void displayStatistics() {

        System.out.println("\n====== GAME STATISTICS ======");

        System.out.println("Player Wins: " + playerWins);
        System.out.println("Computer Wins: " + computerWins);
        System.out.println("Draws: " + draws);

        System.out.println("Total Rounds Played: "
                + gameHistory.size());

        if (playerWins > computerWins) {
            System.out.println("Overall Result: You are winning!");
        } else if (computerWins > playerWins) {
            System.out.println("Overall Result: Computer is winning!");
        } else {
            System.out.println("Overall Result: It's a tie!");
        }
    }
}