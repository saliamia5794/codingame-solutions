import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse the standard input
 * according to the problem statement.
 **/
class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String b = in.nextLine();
        List<Integer> lists = new ArrayList<>();
        while (b.length() > 0) {

            if (!b.contains("0")) {
                lists.add(b.length());
                break;
            }
            String firstOperation = b.replaceFirst(Character.toString('0'), "1");
            if (!firstOperation.contains("0")) {

                lists.add(firstOperation.length());
                break;
            } else {
                int count = firstOperation.substring(0, firstOperation.indexOf('0')).length();
                lists.add(count);

            }
            b = b.substring(b.indexOf('0') + 1, b.length());
        }
        lists.sort(null);
        System.out.println(lists.get(lists.size() - 1));

    }
}
