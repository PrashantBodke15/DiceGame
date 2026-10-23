public public class GameResult {

    private int roundNumber;
    private int playerScore;
    private int computerScore;
    private String result;

    public GameResult(int roundNumber, int playerScore,
                      int computerScore, String result) {

        this.roundNumber = roundNumber;
        this.playerScore = playerScore;
        this.computerScore = computerScore;
        this.result = result;
    }

    public int getRoundNumber() {
        return roundNumber;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public int getComputerScore() {
        return computerScore;
    }

    public String getResult() {
        return result;
    }

    public void displayResult() {

        System.out.println(
            "Round " + roundNumber
            + " | Player: " + playerScore
            + " | Computer: " + computerScore
            + " | Result: " + result
        );
    }
} {
    
}
