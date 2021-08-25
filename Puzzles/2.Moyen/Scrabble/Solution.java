import java.util.*;
import java.util.stream.Collectors;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse the standard input
 * according to the problem statement.
 **/
class Solution {

    public static void main(String args[]) {
        // entrée
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }
        List<String> words = new ArrayList<>();
        Map<Integer, String> results = new HashMap<>();
        Map<String, Integer> dicos = new HashMap<>();
        List<String> finalResults = new ArrayList<>();
        dicos.put("aeilnorstu", 1);
        dicos.put("dg", 2);
        dicos.put("bcmp", 3);
        dicos.put("fhvwy", 4);
        dicos.put("k", 5);
        dicos.put("jx", 8);
        dicos.put("qz", 10);
        for (int i = 0; i < N; i++) {
            String W = in.nextLine();
            words.add(W);
        }
        String LETTERS = in.nextLine();
        
        words.removeIf(word -> !checkValidString(word, LETTERS));
        words.stream().forEach(e -> results.putIfAbsent(countScore(e, dicos), e));
        results.entrySet().stream().forEach(e -> finalResults.add(e.getValue()));
        List<String> s = finalResults.stream().distinct().collect(Collectors.toList());
        System.out.println(s.get(s.size() - 1));

    }

    public static boolean checkValidString(String word, String letters) {
        int count = 0;
        for (int i = 0; i < word.length(); i++) {

            if (searchInString(word.charAt(i), letters) == false) {

                return false;
            }

        }
        if (check(word, letters) == false) {

            return false;
        }

        return true;
    }

    public static boolean check(String word, String letters) {
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {

            if (letters.contains(Character.toString(word.charAt(i)))) {

                String charToReplace = letters.substring(letters.indexOf(word.charAt(i)),
                        letters.indexOf(word.charAt(i)) + 1);
                letters = letters.replaceFirst(charToReplace, "");
                count++;
            }
        }
        if (count == word.length()) {

            return true;
        }

        return false;
    }

    public static boolean searchInString(char c, String chaine) {
        char[] chaineArray = chaine.toCharArray();
        Arrays.sort(chaineArray);
        int middle = chaine.length() / 2;
        int left = 0;
        int right = chaine.length() - 1;
        if (c == chaineArray[middle]) {
            return true;
        }
        while (left < middle) {
            if (c == chaineArray[left++]) {
                return true;
            }
        }
        while (right > middle) {
            if (c == chaineArray[right--]) {
                return true;
            }
        }
        return false;
    }

    public static int countScore(String word, Map<String, Integer> dictionarry) {
        StringBuilder sb = new StringBuilder();
        word.chars().distinct().mapToObj(e -> (char) e).forEach(e -> sb.append((char) e));
        int count = 0;
        for (int i = 0; i < sb.toString().length(); i++) {

            for (Map.Entry<String, Integer> entry : dictionarry.entrySet()) {

                if (searchInString(word.charAt(i), entry.getKey()) == true) {
                    count += entry.getValue();

                }

            }

        }

        return count;
    }

}