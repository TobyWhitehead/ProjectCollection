import java.util.Scanner;
import java.util.Arrays;

public class GuesserGame {

    public static void main(String[] args) {
        System.out.println("\nINSTRUCTIONS:\n");
        System.out.println("Using the least number of guesses possible, find the correct numbers and order");
        System.out.println("of numbers. Each number can take values 0-4. Input should be of the form: 1234. \n");
        int[] gameOut = gameGenerator();
        int guessNumber = 0;
        System.out.println(Arrays.toString(gameOut));
        boolean answerGuessed = false;
        Scanner keyboard = new Scanner(System.in);
        do {
            System.out.println("Enter Guess: ");
            String guessInput = keyboard.nextLine();
            guessNumber++;
            int[] numArray = new int[guessInput.length()];
            for (int i = 0; i < guessInput.length(); i++) {
                numArray[i] = guessInput.charAt(i) - '0';
            }
            if (numArray.length != gameOut.length) {
                System.out.println("Incorrect Guess Length");
            } else if (Arrays.equals(numArray, gameOut)) {
                answerGuessed = true;
            } else {
                posCounter(numArray, guessInput, gameOut);
                numCounter(numArray, guessInput, gameOut);
            }
        }
        while(!answerGuessed);
        System.out.println("correct");
        System.out.println("total guesses used: " + guessNumber);
    }
    public static int[] gameGenerator() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter game size: ");
        String gameSizeS = keyboard.nextLine();
        int gameSizeI = Integer.parseInt(gameSizeS);
        int[] gameArray = new int[gameSizeI];
        for (int i = 0; i < gameSizeI; i++) {
            int j = (int) (Math.random() * 5);
            gameArray[i] = j;
        }
        return(gameArray);
    }

    public static void posCounter(int[] numArray, String guessInput, int[] gameOut) {
        int positionCounter = 0;
        for (int j = 0; j < guessInput.length(); j++) {
            int intSub = numArray[j] - gameOut[j];
            if (intSub == 0) {
                positionCounter++;
            }
        }
        System.out.println("Correct Position: " + positionCounter);
    }

    public static void numCounter(int[] numArray, String guessInput, int[] gameOut) {
        int numberCounter = 0;
        for (int k = 0; k < guessInput.length(); k++) {
            boolean contains = false;
            for (int s: gameOut) {
                if (s == numArray[k]) {
                    contains = true;
                    break;
                }
            }
            if (contains) {
                numberCounter++;
            }
        }
        System.out.println("Correct Number: " + numberCounter);
    }
}
