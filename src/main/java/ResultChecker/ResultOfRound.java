package ResultChecker;

public enum ResultOfRound {

    NoOneWon("No one won"),

    AIWon("AI won"),

    UserWon("User won");

    final String message;

    ResultOfRound(String message) {
        this.message = message;
    }
    }
