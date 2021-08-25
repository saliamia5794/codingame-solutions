import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Don't let the machines win. You are humanity's last hope...
 **/
class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int width = in.nextInt(); // the number of cells on the X axis
        int height = in.nextInt(); // the number of cells on the Y axis
        if (in.hasNextLine()) {
            in.nextLine();
        }
        List<String> gridsList = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            String line = in.nextLine(); // width characters, each either 0 or .
            gridsList.add(line);

        }

        for (int i = 0; i < height; i++) {
            String line = gridsList.get(i);
            String currentNode = "";
            String rightNode = "";
            String subNode = "";

            for (int j = 0; j < width; j++) {

                if (!line.contains("0")) {
                    break;
                }

                if (line.charAt(j) != '0') {

                    continue;
                }

                if (line.charAt(j) == '0') {

                    currentNode = j + " " + i;

                }
                int count = j;
                while (count < width) {
                    count++;
                    try {
                        if (line.charAt(count) == '0') {

                            rightNode = count + " " + i;
                            break;
                        }

                    } catch (Exception e) {
                        rightNode = "-1 -1";

                    }

                }
                int c = i;
                while (c < height) {
                    c++;
                    try {

                        if (gridsList.get(c).charAt(j) == '0') {

                            subNode = j + " " + c;
                            break;
                        }
                    } catch (Exception e) {

                        subNode = "-1 -1";

                    }
                }
                System.out.println(currentNode + " " + rightNode + " " + subNode);

            }

        }

    }
}