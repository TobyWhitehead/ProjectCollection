import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class PasswordChecker {

    public static void main(String[] args) {
        String PasswordGuess;
        String SamplePassword = RandomPassGenerator();
        int SampleNumber = 4;
        List<String> PasswordSamples = new ArrayList<>();
        for (int i = 0; i < SampleNumber; i++) {
            PasswordSamples.add(RandomPassGenerator());
        }
        System.out.println(PasswordSamples);
        boolean password_chosen = false;
        do {
            Scanner keyboard = new Scanner(System.in);
            System.out.println("enter index of desired password:");
            String PassIndexS = keyboard.nextLine();
            int PassIndexI = Integer.parseInt(PassIndexS);
            if (PassIndexI < 0 || PassIndexI >= SampleNumber) {
                System.out.println("index not in range");
            } else {
                password_chosen = true;
                SamplePassword = PasswordSamples.get(PassIndexI);
            }
        } while(!password_chosen);
        System.out.println("Randomly Generated Password: " + SamplePassword);
        do {
            Scanner keyboard = new Scanner(System.in);
            System.out.println("enter password guess:");
            PasswordGuess = keyboard.nextLine();
            boolean correct_status = PasswordGuess.equals(SamplePassword);
            System.out.println(correct_status);
            if (!correct_status) {
                int GuessLength = PasswordGuess.length();
                int SampleLength = SamplePassword.length();
                String PasswordGuessLower = PasswordGuess.toLowerCase();
                String SamplePasswordLower = SamplePassword.toLowerCase();
                if (GuessLength != SampleLength) {
                    System.out.println("incorrect length");
                } else if (PasswordGuessLower.equals(SamplePasswordLower)) {
                    System.out.println("Upper/Lower case mismatch");
                } else {
                    System.out.println("incorrect characters");
                }
            }
        }
        while (!PasswordGuess.equals(SamplePassword));
    }
    public static String RandomPassGenerator() {
        int PassLength = 8;
        String[] myArray = new String[PassLength];
        for (int i = 0; i < PassLength; i++) {
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



