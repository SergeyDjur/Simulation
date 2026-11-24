package main;

public class UserInputThread extends Thread {
    private final UserInput userInput;
    private final GameController gameController;

    public UserInputThread(GameController gameController) {
        this.gameController = gameController;
        this.userInput = new UserInput(gameController);

    }

    @Override
    public void run() {
        userInput.commandListener();
    }

}
