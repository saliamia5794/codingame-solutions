import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(); // Number of elements which make up the association table.
        int Q = in.nextInt(); // Number Q of file names to be analyzed.
        Map map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String EXT = in.next(); // file extension
            String MT = in.next(); // MIME type.
            map.put(EXT.toLowerCase(),MT);
            
        }
        in.nextLine();
        for (int i = 0; i < Q; i++) {
            String FNAME = in.nextLine().toLowerCase(); // One file name per line.
            int position =FNAME.lastIndexOf(".");
    String extension=position==-1?"":FNAME.substring(position+1);
      System.out.println(map.getOrDefault(extension, "UNKNOWN"));

              ;
        }

        // Write an answer using System.out.println()
        // To debug: System.err.println("Debug messages...");


        // For each of the Q filenames, display on a line the corresponding MIME type. If there is no corresponding type, then display UNKNOWN.
    }
}
