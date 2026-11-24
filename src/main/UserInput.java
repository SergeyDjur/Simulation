package main;

import java.util.Scanner;

public class UserInput {
    public Scanner scanner = new Scanner(System.in);
    private final GameController gameController;
    private boolean isWorking = true;

    public UserInput(GameController gameController) {
        this.gameController = gameController;
    }


    public void commandListener() {
        System.out.println("to put on pause press 'P'");
        System.out.println("to make next turn press 'N'");
        System.out.println("to start endless simulation press 'S'");
        System.out.println("to quit simulation press 'Q'");


        while (isWorking) {

            String command = scanner.nextLine();

            if (command.length() != 1) {
                System.out.println("type a value");
                continue;
            }
            char input = command.charAt(0);

            if (!Character.isLetter(input)) {
                System.out.println("only letters allowed");
                continue;

            }
            if (command.equalsIgnoreCase("P")) {
                gameController.setPaused(true);
                return;
            }

            if (command.equalsIgnoreCase("N")) {

                gameController.setNextTurn(true);
                return;
            }
            if (command.equalsIgnoreCase("S")) {

                gameController.setStartSimulation(true);
                return;

            }
            if (command.equalsIgnoreCase("Q")) {
                gameController.setQuit(true);
                isWorking = false;
            }
            if (!command.equalsIgnoreCase("p") && !command.equalsIgnoreCase("n") && !command.equalsIgnoreCase("s") && !command.equalsIgnoreCase("q")) {
                System.out.println("unknown command");
            }
        }
    }

}
