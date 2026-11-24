package main;

public class GameController {
    private volatile boolean isStartSimulation;
    private volatile boolean isNextTurn;
    private volatile boolean isPaused;
    private volatile boolean isQuit;

    public GameController(boolean isStartSimulation, boolean isNextTurn, boolean isPaused, boolean isQuit) {
        this.isStartSimulation = isStartSimulation;
        this.isNextTurn = isNextTurn;
        this.isPaused = isPaused;
        this.isQuit = isQuit;

    }

    public void setNextTurn(boolean nextTurn) {
        isNextTurn = nextTurn;
    }

    public void setPaused(boolean paused) {
        isPaused = paused;
    }

    public void setStartSimulation(boolean startSimulation) {
        isStartSimulation = startSimulation;
    }

    public boolean getIsStartSimulation() {
        return isStartSimulation;
    }

    public boolean getIsNextTurn() {
        return isNextTurn;
    }

    public boolean getIsPaused() {
        return isPaused;
    }

    public boolean getIsQuit() {
        return isQuit;
    }

    public void setQuit(boolean quit) {
        isQuit = quit;
    }
}
