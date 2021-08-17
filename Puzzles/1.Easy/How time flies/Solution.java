import java.util.*;
import java.io.*;
import java.math.*;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

/**
 * Auto-generated code below aims at helping you parse the standard input
 * according to the problem statement.
 **/
class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String[] BEGIN = in.next().split("\\.");
        String[] END = in.next().split("\\.");
        LocalDate begin = LocalDate.of(Integer.parseInt(BEGIN[2]), Integer.parseInt(BEGIN[1]),
                Integer.parseInt(BEGIN[0]));
        LocalDate end = LocalDate.of(Integer.parseInt(END[2]), Integer.parseInt(END[1]), Integer.parseInt(END[0]));
        Period period = Period.between(begin, end);
        int months = period.getMonths();
        int years = period.getYears();
        String outputMonths = printDateFormat("month", months);
        String outputYears = printDateFormat("year", years);
        int total = (int) ChronoUnit.DAYS.between(begin, end);
        String outputTotal = printTotalFormat("days", total);
        System.out.println(outputYears + outputMonths + outputTotal);

    }

    public static String printDateFormat(String format, int weight) {

        if (weight > 1) {
            format = weight + " " + format + "s, ";

        } else if (weight == 0) {
            format = "";
        } else {
            format = weight + " " + format + ", ";

        }
        return format;

    }

    public static String printTotalFormat(String format, int total) {
        return format = "total " + total + " " + format;

    }
}
