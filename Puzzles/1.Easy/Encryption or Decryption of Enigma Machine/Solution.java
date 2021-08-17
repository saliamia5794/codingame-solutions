import java.util.*;
import java.util.stream.Collectors;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse the standard input
 * according to the problem statement.
 **/
class Solution {

    static char encryptWithRotor(char code) {

        for (String rotor : rotors) {

            int posRotor = alphabet.indexOf(code);
            code = rotor.charAt(posRotor);

        }
        return code;

    }

    static String decryptionWithRotor(String message) {
        Collections.reverse(rotors);

        for (String rotor : rotors) {

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < message.length(); i++) {
                int posRotor = rotor.indexOf(message.charAt(i));
                char decryptChar = (char) (posRotor + 65);
                sb.append(decryptChar);

            }
            message = sb.toString();

        }
        return message;

    }

    static String encodeWithN(int n, String text) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0, j = n; i < text.length(); i++, j++) {
            int x = text.charAt(i) - 64;
            char encoded = 0;
            if(j>=26){
                j=j%26;
            }
            int result = x + j;
            if (result <= 26) {
                encoded = (char) (result + 64);
                sb.append(encryptWithRotor(encoded));

            } else {
                result = result % 26;
                encoded = (char) (result + 64);
                sb.append(encryptWithRotor(encoded));
            }

        }
        return sb.toString();

    }

    static String decodeWithN(int n, String text) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0, j = n; i < text.length(); i++, j++) {
            int x = text.charAt(i) - 64;
            char encoded = 0;
            int result = x - j;
            if (result >= 1) {
                encoded = (char) (result + 64);
                sb.append(encoded);

            } else {
                result = 26 + (result % 26);
                encoded = (char) (result + 64);
                sb.append(encoded);
            }

        }
        return sb.toString();

    }

    static List<String> rotors = new ArrayList<>(3);
    static String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String operation = in.nextLine();
        int pseudoRandomNumber = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }
        for (int i = 0; i < 3; i++) {
            String rotor = in.nextLine();
            rotors.add(rotor);
        }
        String message = in.nextLine();

        if (operation.equals("ENCODE")) {

            System.out.println(encodeWithN(pseudoRandomNumber, message));

        } else {

            String decryption = decryptionWithRotor(message);
            // System.out.println(decryption);

            System.out.println(decodeWithN(pseudoRandomNumber, decryption));

        }

    }
}
