import java.util.*;
import java.io.*;
import java.math.*;

class Solution {
    public static Map<Integer, Integer> results = new HashMap<>();
    public static List<String> listsArg = new ArrayList<>(3);
    public static Map<Integer, List<String>> datas = new HashMap<>();

    public static int calculateReference(int n) {

        int result = 0;
        String operation = datas.get(n).get(0);
        String arg1 = datas.get(n).get(1);
        String arg2 = datas.get(n).get(2);

        if (arg1.contains("_")) {

            arg1 = "0";
        }
        if (arg2.contains("_")) {
            arg2 = "0";
        }

        if (!arg1.contains("$") && !arg2.contains("$")) {
            result = calculator(operation, Integer.valueOf(arg1), Integer.valueOf(arg2));
            results.put(n, result);
            if (n > 0 ) {
                calculateReference(n - 1);

            }

        } else if (arg1.contains("$") && !arg2.contains("$")) {
            arg1 = arg1.substring(1);
            int reference = Integer.valueOf(arg1);
            if (results.containsKey(reference)) {

                int cachedValue = results.get(reference);
                result = calculator(operation, cachedValue, Integer.valueOf(arg2));
                results.put(n, result);
                if (n > 0 ) {
                    calculateReference(n - 1);
                }

            } else {
                result = calculator(operation, calculateReference(reference), Integer.valueOf(arg2));
                results.put(n, result);

            }

        } else if (!arg1.contains("$") && arg2.contains("$")) {
            arg2 = arg2.substring(1);
            int reference = Integer.valueOf(arg2);
            if (results.containsKey(reference)) {

                int cachedValue = results.get(reference);
                result = calculator(operation, Integer.valueOf(arg1), cachedValue);
                results.put(n, result);
                if (n > 0) {
                    calculateReference(n - 1);

                }

            } else {
                result = calculator(operation, Integer.valueOf(arg1), calculateReference(reference));
                results.put(n, result);

            }

        } else if (arg1.contains("$") && arg2.contains("$")) {
            arg1 = arg1.substring(1);
            arg2 = arg2.substring(1);
            int reference1 = Integer.valueOf(arg1);
            int reference2 = Integer.valueOf(arg2);

            if (results.containsKey(reference1) && results.containsKey(reference2)) {
                int cachedValue1 = results.get(reference1);
                int cachedValue2 = results.get(reference2);
                result = calculator(operation, cachedValue1, cachedValue2);

                results.put(n, result);
                if (n > 0 ) {
                    calculateReference(n - 1);
                }

            } else if (results.containsKey(reference1) && !results.containsKey(reference2)) {
                int cachedValue1 = results.get(reference1);

                result = calculator(operation, cachedValue1, calculateReference(reference2));
                results.put(n, result);

            } else if (!results.containsKey(reference1) && results.containsKey(reference2)) {
                int cachedValue2 = results.get(reference2);

                result = calculator(operation, calculateReference(reference1), cachedValue2);
                results.put(n, result);
                if (n > 0 ) {
                    calculateReference(n - 1);
                }

            } else {
                result = calculator(operation, calculateReference(reference1), calculateReference(reference2));
                results.put(n, result);
                if (n > 0 ) {
                    calculateReference(n - 1);
                }

            }

        }

        return result;
    }

    public static int calculator(String operation, int arg1, int arg2) {
        int result = 0;
        switch (operation) {
            case "ADD":
                result = arg1 + arg2;
                break;
            case "VALUE":
                result = arg1 + arg2;

                break;
            case "MULT":
                result = arg1 * arg2;

                break;
            case "SUB":
                result = arg1 - arg2;

                break;

        }
        return result;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        for (int i = 0; i < N; i++) {
            String operation = in.next();
            String arg1 = in.next();
            String arg2 = in.next();
            listsArg = new ArrayList<>(3);
            listsArg.add(operation);
            listsArg.add(arg1);
            listsArg.add(arg2);
            datas.put(i, listsArg);

        }
        int n = N - 1;
        calculateReference(n);
        results.forEach((k, v) -> System.out.println(v));
    }
}
