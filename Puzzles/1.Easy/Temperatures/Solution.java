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
        List<Integer> temperatures = new ArrayList<>();
        List<Integer> positifTemperatures = new ArrayList<>();
        List<Integer> negatifTemperatures = new ArrayList<>();

        int n = in.nextInt(); // the number of temperatures to analyse
        for (int i = 0; i < n; i++) {

            int t = in.nextInt(); // a temperature expressed as an integer ranging from -273 to 5526
            temperatures.add(t);

        }

        for (int temp : temperatures) {

            if (temp < 0) {

                negatifTemperatures.add(temp);
            }
            if (temp > 0) {
                positifTemperatures.add(temp);
            }

        }

        if (positifTemperatures.size() != 0 && negatifTemperatures.size() != 0) {
            Collections.sort(positifTemperatures);

            Collections.sort(negatifTemperatures);

            if (positifTemperatures.get(0) <= Math.abs(negatifTemperatures.get(negatifTemperatures.size() - 1))) {

                System.out.println(positifTemperatures.get(0));

            } else {

                System.out.println(negatifTemperatures.get(negatifTemperatures.size() - 1));

            }
        } else if (negatifTemperatures.size() != 0 && positifTemperatures.isEmpty()) {
            Collections.sort(negatifTemperatures);
            System.out.println(negatifTemperatures.get(negatifTemperatures.size() - 1));

        } else if (positifTemperatures.size() != 0 && negatifTemperatures.isEmpty()) {

            Collections.sort(positifTemperatures);
            System.out.println(positifTemperatures.get(0));

        } else {

            System.out.println("0");
        }

        // Write an answer using System.out.println()
        // To debug: System.err.println("Debug messages...");

    }
}
