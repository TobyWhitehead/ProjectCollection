package minesweeperProject;
import java.util.Scanner;

public class Minesweeper {

    static Tile[][] grid = new Tile[10][10];
    static boolean gameOver = false;
    static int uncoverCount = 0;

    public static void generateGrid() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                grid[i][j] = new Tile();
                grid[i][j].setPosition(new int[]{i, j});
            }
        }
        int numMines = 0;
        do {
            int randNumy = (int) (Math.random() * 10);
            if (randNumy == 10) {
                randNumy = 9;
            }
            int randNumx = (int) (Math.random() * 10);
            if (randNumx == 10) {
                randNumx = 9;
            }
            if (!grid[randNumy][randNumx].getMine()) {
                grid[randNumy][randNumx].setMine(true);
                numMines++;
            }
        } while (numMines < 10);
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                int adjMines = 0;
                if (i > 0 && j > 0 && grid[i - 1][j - 1].getMine()) {
                    adjMines++;
                }
                if (j > 0 && grid[i][j - 1].getMine()) {
                    adjMines++;
                }
                if (i < 9 && j > 0 && grid[i + 1][j - 1].getMine()) {
                    adjMines++;
                }
                if (i > 0 && grid[i - 1][j].getMine()) {
                    adjMines++;
                }
                if (i < 9 && grid[i + 1][j].getMine()) {
                    adjMines++;
                }
                if (i > 0 && j < 9 && grid[i - 1][j + 1].getMine()) {
                    adjMines++;
                }
                if (j < 9 && grid[i][j + 1].getMine()) {
                    adjMines++;
                }
                if (i < 9 && j < 9 && grid[i + 1][j + 1].getMine()) {
                    adjMines++;
                }
                grid[i][j].setNumber(adjMines);
            }
        }
    }

    public static void displayGrid() { //Gareth I am so sorry, yes it took me 70 lines of code to print a grid.
        for(Tile[] a : grid) {
            String place1;
            String place2;
            String place3;
            String place4;
            String place5;
            String place6;
            String place7;
            String place8;
            String place9;
            String place10;


            if(a[0].getCoverStatus())
                place1 = " ";
            else
                place1 = Integer.toString(a[0].getNumber());

            if(a[1].getCoverStatus())
                place2 = " ";
            else
                place2 = Integer.toString(a[1].getNumber());

            if(a[2].getCoverStatus())
                place3 = " ";
            else
                place3 = Integer.toString(a[2].getNumber());

            if(a[3].getCoverStatus())
                place4 = " ";
            else
                place4 = Integer.toString(a[3].getNumber());

            if(a[4].getCoverStatus())
                place5 = " ";
            else
                place5 = Integer.toString(a[4].getNumber());

            if(a[5].getCoverStatus())
                place6 = " ";
            else
                place6 = Integer.toString(a[5].getNumber());

            if(a[6].getCoverStatus())
                place7 = " ";
            else
                place7 = Integer.toString(a[6].getNumber());

            if(a[7].getCoverStatus())
                place8 = " ";
            else
                place8 = Integer.toString(a[7].getNumber());

            if(a[8].getCoverStatus())
                place9 = " ";
            else
                place9 = Integer.toString(a[8].getNumber());

            if(a[9].getCoverStatus())
                place10 = " ";
            else
                place10 = Integer.toString(a[9].getNumber());

            System.out.println("["+place1+"] ["+place2+"] ["+place3+"] ["+place4+"] ["+place5+"] ["+place6+"] ["+place7+"] ["+place8+"] ["+place9+"] ["+place10+"]\n");
        }
    }

    public static void clickTile() {
        System.out.println("Enter row number:");
        Scanner keyboard = new Scanner(System.in);
        int xInput = Integer.parseInt(keyboard.nextLine());
        System.out.println("Enter column number:");
        Scanner keyboard2 = new Scanner(System.in);
        int yInput = Integer.parseInt(keyboard2.nextLine());
        grid[xInput - 1][yInput - 1].setCoverStatus(false);
        uncoverCount++;
        if (grid[xInput - 1][yInput - 1].getMine()){
            gameOver = true;
            System.out.println("you hit a mine, game over");
        }
        else if (uncoverCount >= 90){
            gameOver = true;
            displayGrid();
            System.out.println("all empty tiles cleared, game over");
        }
        else {
            displayGrid();
        }

    }

    public static void main(String[] args) {
        generateGrid();
        displayGrid();
        do {
            clickTile();
        }while(!gameOver);
    }
}
