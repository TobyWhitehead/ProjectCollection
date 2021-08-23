import java.util.Scanner;
import java.util.Arrays;

public class GuesserGame {

    public static void main(String[] args) {
        System.out.println("\nINSTRUCTIONS:\n");
        System.out.println("Using the least number of guesses possible, find the correct numbers and order");
        System.out.println("of numbers. Each number can take values 0-4. Input should be of the form: 1234. \n");
        int[] GameOut = GameGenerator();
        int GuessNumber = 0;
        System.out.println(Arrays.toString(GameOut));
        boolean answer_guessed = false;
        Scanner keyboard = new Scanner(System.in);
        do {
            System.out.println("Enter Guess: ");
            String GuessInput = keyboard.nextLine();
            GuessNumber++;
            int[] NumArray = new int[GuessInput.length()];
            for (int i = 0; i < GuessInput.length(); i++) {
                NumArray[i] = GuessInput.charAt(i) - '0';
            }
            if (NumArray.length != GameOut.length) {
                System.out.println("Incorrect Guess Length");
            } else if (Arrays.equals(NumArray, GameOut)) {
                answer_guessed = true;
            } else {
                posCounter(NumArray, GuessInput, GameOut);
                numCounter(NumArray, GuessInput, GameOut);
            }
        }
        while(!answer_guessed);
        System.out.println("correct");
        System.out.println("total guesses used: " + GuessNumber);
    }
    public static int[] GameGenerator() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter game size: ");
        String GameSizeS = keyboard.nextLine();
        int GameSizeI = Integer.parseInt(GameSizeS);
        int[] GameArray = new int[GameSizeI];
        for (int i = 0; i < GameSizeI; i++) {
            int j = (int) (Math.random() * 5);
            GameArray[i] = j;
        }
        return(GameArray);
    }

    public static void posCounter(int[] NumArray, String GuessInput, int[] GameOut) {
        int PositionCounter = 0;
        for (int j = 0; j < GuessInput.length(); j++) {
            int IntSub = NumArray[j] - GameOut[j];
            if (IntSub == 0) {
                PositionCounter++;
            }
        }
        System.out.println("Correct Position: " + PositionCounter);
    }

    public static void numCounter(int[] NumArray, String GuessInput, int[] GameOut) {
        int NumberCounter = 0;
        for (int k = 0; k < GuessInput.length(); k++) {
            boolean contains = false;
            for (int s: GameOut) {
                if (s == NumArray[k]) {
                    contains = true;
                    break;
                }
            }
            if (contains) {
                NumberCounter++;
            }
        }
        System.out.println("Correct Number: " + NumberCounter);
    }
}
