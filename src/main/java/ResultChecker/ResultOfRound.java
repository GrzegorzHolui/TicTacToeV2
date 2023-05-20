package ResultChecker;

enum ResultOfRound {

    NoOneWon("No one won"),

    AIWon("AI won"),

    UserWon("User won"),

    Draw("Draw");

    final String message;

    ResultOfRound(String message) {
        this.message = message;
    }
}
