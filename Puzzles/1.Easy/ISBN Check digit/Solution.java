import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse the standard input
 * according to the problem statement.
 **/
class Solution {

    static List<String> invalideCases = new ArrayList<String>();

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }
        for (int i = 0; i < N; i++) {
            String ISBN = in.nextLine();
            if (checkDigit(ISBN) == false) {
                invalideCases.add(ISBN);
            } else {
                addInvalideCase(ISBN);
            }
        }
        System.out.println(invalideCases.size() + " invalid:");
        for (String invalideCase : invalideCases) {
            System.out.println(invalideCase);
        }

    }

    static boolean checkDigit(String ISBN) {

        String regex = "(^\\d{9})(X|\\d{1}$)|(^\\d{12})(X|\\d{1}$)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(ISBN);
        if (matcher.find()) {
            return true;
        }
        return false;
    }

    public static int calculateResult(String isbn) {
        int result = 0;
        if (isbn.length() == 10) {
            for (int j = 0, k = 10; j < isbn.length() - 1; j++, k--) {
                result += k * Character.getNumericValue(isbn.charAt(j));
            }
            return result;
        } else {
            for (int f = 0; f < isbn.length() - 1; f++) {
                int multiplicator = f % 2 != 0 ? 3 : 1;
                result += multiplicator * Character.getNumericValue(isbn.charAt(f));
            }
            return result;
        }
    }

    static void addInvalideCase(String isbn) {
        String lastCharacter = isbn.substring(isbn.length() - 1);
        int lastDigit = lastCharacter.equals("X") ? 10 : Integer.parseInt(lastCharacter);
        int result = calculateResult(isbn);
        int sum = result + lastDigit;

        if (isbn.length() == 10) {

            if (sum % 11 != 0) {
                invalideCases.add(isbn);
            }
        }
        if (isbn.length() == 13) {
            if (sum % 10 == 0 && lastDigit == 10) {
                invalideCases.add(isbn);

            }

            if (sum % 10 != 0) {
                invalideCases.add(isbn);

            }
        }

    }

}

