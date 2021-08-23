import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class PasswordChecker {

    public static void main(String[] args) {
        String passwordGuess;
        String samplePassword = randomPassGenerator();
        int sampleNumber = 4;
        List<String> passwordSamples = new ArrayList<>();
        for (int i = 0; i < sampleNumber; i++) {
            passwordSamples.add(randomPassGenerator());
        }
        System.out.println(passwordSamples);
        boolean passwordChosen = false;
        do {
            Scanner keyboard = new Scanner(System.in);
            System.out.println("enter index of desired password:");
            String passIndexS = keyboard.nextLine();
            int passIndexI = Integer.parseInt(passIndexS);
            if (passIndexI < 0 || passIndexI >= sampleNumber) {
                System.out.println("index not in range");
            } else {
                passwordChosen = true;
                samplePassword = passwordSamples.get(passIndexI);
            }
        } while(!passwordChosen);
        System.out.println("Randomly Generated Password: " + samplePassword);
        do {
            Scanner keyboard = new Scanner(System.in);
            System.out.println("enter password guess:");
            passwordGuess = keyboard.nextLine();
            boolean correctStatus = passwordGuess.equals(samplePassword);
            System.out.println(correctStatus);
            if (!correctStatus) {
                int guessLength = passwordGuess.length();
                int sampleLength = samplePassword.length();
                String passwordGuessLower = passwordGuess.toLowerCase();
                String samplePasswordLower = samplePassword.toLowerCase();
                if (guessLength != sampleLength) {
                    System.out.println("incorrect length");
                } else if (passwordGuessLower.equals(samplePasswordLower)) {
                    System.out.println("Upper/Lower case mismatch");
                } else {
                    System.out.println("incorrect characters");
                }
            }
        }
        while (!passwordGuess.equals(samplePassword));
    }
    public static String randomPassGenerator() {
        int passLength = 8;
        String[] myArray = new String[passLength];
        for (int i = 0; i < passLength; i++) {
            char c  = (char)((Math.random()*1000)%26 + 'a');
            String d = Character.toString(c);
            if (((int)(Math.random()*5))%2 == 0) {
                d = d.toUpperCase();
            }

            myArray[i] = d;
        }
        return String.join("", myArray);
    }
}



