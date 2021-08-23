package MinesweeperProject;
import java.util.Scanner;

public class Minesweeper {

    static Tile[][] grid = new Tile[10][10];
    static boolean game_over = false;
    static int uncover_count = 0;

    public static void generateGrid() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                grid[i][j] = new Tile();
                grid[i][j].setPosition(new int[]{i, j});
            }
        }
        int num_mines = 0;
        do {
            int rand_numy = (int) (Math.random() * 10);
            if (rand_numy == 10) {
                rand_numy = 9;
            }
            int rand_numx = (int) (Math.random() * 10);
            if (rand_numx == 10) {
                rand_numx = 9;
            }
            if (!grid[rand_numy][rand_numx].getIs_mine()) {
                grid[rand_numy][rand_numx].setIs_mine(true);
                num_mines++;
            }
        } while (num_mines < 10);
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                int adj_mines = 0;
                if (i > 0 && j > 0) {
                    if (grid[i - 1][j - 1].getIs_mine()) {
                        adj_mines++;
                    }
                }
                if (j > 0) {
                    if (grid[i][j - 1].getIs_mine()) {
                        adj_mines++;
                    }
                }
                if (i < 9 && j > 0) {
                    if (grid[i + 1][j - 1].getIs_mine()) {
                        adj_mines++;
                    }
                }
                if (i > 0) {
                    if (grid[i - 1][j].getIs_mine()) {
                        adj_mines++;
                    }
                }
                if (i < 9) {
                    if (grid[i + 1][j].getIs_mine()) {
                        adj_mines++;
                    }
                }
                if (i > 0 && j < 9) {
                    if (grid[i - 1][j + 1].getIs_mine()) {
                        adj_mines++;
                    }
                }
                if (j < 9) {
                    if (grid[i][j + 1].getIs_mine()) {
                        adj_mines++;
                    }
                }
                if (i < 9 && j < 9) {
                    if (grid[i + 1][j + 1].getIs_mine()) {
                        adj_mines++;
                    }
                }
                grid[i][j].setNumber(adj_mines);
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


            if(a[0].getCover_status())
                place1 = " ";
            else
                place1 = Integer.toString(a[0].getNumber());

            if(a[1].getCover_status())
                place2 = " ";
            else
                place2 = Integer.toString(a[1].getNumber());

            if(a[2].getCover_status())
                place3 = " ";
            else
                place3 = Integer.toString(a[2].getNumber());

            if(a[3].getCover_status())
                place4 = " ";
            else
                place4 = Integer.toString(a[3].getNumber());

            if(a[4].getCover_status())
                place5 = " ";
            else
                place5 = Integer.toString(a[4].getNumber());

            if(a[5].getCover_status())
                place6 = " ";
            else
                place6 = Integer.toString(a[5].getNumber());

            if(a[6].getCover_status())
                place7 = " ";
            else
                place7 = Integer.toString(a[6].getNumber());

            if(a[7].getCover_status())
                place8 = " ";
            else
                place8 = Integer.toString(a[7].getNumber());

            if(a[8].getCover_status())
                place9 = " ";
            else
                place9 = Integer.toString(a[8].getNumber());

            if(a[9].getCover_status())
                place10 = " ";
            else
                place10 = Integer.toString(a[9].getNumber());

            System.out.println("["+place1+"] ["+place2+"] ["+place3+"] ["+place4+"] ["+place5+"] ["+place6+"] ["+place7+"] ["+place8+"] ["+place9+"] ["+place10+"]\n");
        }
    }

    public static void clickTile() {
        System.out.println("Enter row number:");
        Scanner keyboard = new Scanner(System.in);
        int x_input = Integer.parseInt(keyboard.nextLine());
        System.out.println("Enter column number:");
        Scanner keyboard2 = new Scanner(System.in);
        int y_input = Integer.parseInt(keyboard2.nextLine());
        grid[x_input - 1][y_input - 1].setCover_status(false);
        uncover_count++;
        if (grid[x_input - 1][y_input - 1].getIs_mine()){
            game_over = true;
            System.out.println("you hit a mine, game over");
        }
        else if (uncover_count >= 90){
            game_over = true;
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
        }while(!game_over);
    }
}
