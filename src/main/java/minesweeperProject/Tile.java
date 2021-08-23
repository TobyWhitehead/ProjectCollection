package minesweeperProject;

public class Tile {
    private int[] position = new int[2];
    private boolean isMine = false;
    private boolean coverStatus = true;
    int number = 0;

    public int[] getPosition() {
        return position;
    }
    public void setPosition(int[] newPosition) {
        this.position = newPosition;
    }
    public boolean getMine() {
        return isMine;
    }
    public void setMine(boolean newIsMine) {
        this.isMine = newIsMine;
    }
    public boolean getCoverStatus() {
        return coverStatus;
    }
    public void setCoverStatus(boolean newCoverStatus) {
        this.coverStatus = newCoverStatus;
    }
    public int getNumber() {
        return number;
    }

    public void setNumber(int newNumber) {
        this.number = newNumber;
    }
}
