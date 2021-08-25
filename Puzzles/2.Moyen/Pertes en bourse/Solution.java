import java.util.*;
import java.io.*;
import java.math.*;

class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int maxLossResult = 0;
        int previousValue = 0;
        for (int i = 0; i < n; i++) {
            int currentValue = in.nextInt();
            if (currentValue > previousValue) {
                previousValue = currentValue;
                
            } else if (currentValue < previousValue) {
                int currentLoss = currentValue - previousValue;
                if (currentLoss < maxLossResult) {
                    maxLossResult = currentLoss;
                }
            }

        }
        System.out.println(maxLossResult);
    }
}