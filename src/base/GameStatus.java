package base;

public class GameStatus {

    public  static GameStatus gameStatus = new GameStatus();

    private int playerNumber;

    private int map;

    private Process process = Process.STARTING;

    private boolean goNext = false;

    private int playerCount1 = 0;

    private int playerCount2 = 0;

    private int difficult;

    public GameStatus(){
        this.difficult = 1;
        this.map = 1;
        this.difficult = 1;
        this.process = Process.PLAYING;
    }

    public int getPlayerNumber() {
        return playerNumber;
    }

    public void setPlayerNumber(int playerNumber) {
        this.playerNumber = playerNumber;
    }

    public int getMap() {
        return map;
    }

    public void setMap(int map) {
        this.map = map;
    }

    public Process getProcess() {
        return process;
    }

    public void setProcess(Process process) {
        this.process = process;
    }

    public int getPlayerCount2() {
        return playerCount2;
    }

    public void setPlayerCount2(int playerCount2) {
        this.playerCount2 = playerCount2;
    }

    public int getPlayerCount1() {
        return playerCount1;
    }

    public void setPlayerCount1(int playerCount1) {
        this.playerCount1 = playerCount1;
    }

    public int getDifficult() {
        return difficult;
    }

    public void setDifficult(int difficult) {
        this.difficult = difficult;
    }

    public enum Process{STARTING,PLAYING,PAUSE,COUNTING,GAMEOVER}

    public void setGoNext(boolean goNext) {
        this.goNext = goNext;
    }
}
