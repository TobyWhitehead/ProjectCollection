package MinesweeperProject;

public class Tile {
    private int[] position = new int[2];
    private boolean is_mine = false;
    private boolean cover_status = true;
    int number = 0;

    public int[] getPosition() {
        return position;
    }
    public void setPosition(int[] newPosition) {
        this.position = newPosition;
    }
    public boolean getIs_mine() {
        return is_mine;
    }
    public void setIs_mine(boolean newIs_mine) {
        this.is_mine = newIs_mine;
    }
    public boolean getCover_status() {
        return cover_status;
    }
    public void setCover_status(boolean newCover_status) {
        this.cover_status = newCover_status;
    }
    public int getNumber() {
        return number;
    }

    public void setNumber(int newNumber) {
        this.number = newNumber;
    }
}
