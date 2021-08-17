import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse the standard input
 * according to the problem statement.
 **/
class Solution {

    private static long countDigit(long river) {

        return Long.toString(river).chars().mapToObj(e -> Integer.parseInt(Character.toString(e))).reduce(0,
                (i1, i2) -> (i1 + i2));
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        long r1 = in.nextLong();
        long r2 = in.nextLong();
        while (r1 != r2) {
            while (r1 < r2) {
                r1 += countDigit(r1);
                if (r1 == r2) {
                    System.out.println(r1);
                    break;
                }
            }
            while (r1 > r2) {
                r2 += countDigit(r2);
                if (r1 == r2) {
                    System.out.println(r1);
                    break;
                }

            }

        }

    }
}
