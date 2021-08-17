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

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String expression = in.next();
        String regex = "([a-zA-Z0-9])|(\\{\\})|(\\[\\])|(\\(\\))";
        String subst = "";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(expression);
        boolean x = true;
        while (matcher.find()) {
            expression = expression.replaceAll(regex, subst);  
        }
        if (expression.length()>0) {

            x = false;

        }

        System.out.println(x);

    } 
}
