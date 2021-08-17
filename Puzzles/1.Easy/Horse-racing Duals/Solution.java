import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String args[]) {

        List<Integer> puissances =new ArrayList<>();
                List<Integer> results =new ArrayList<>();

        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        for (int i = 0; i < N; i++) {
            int pi = in.nextInt();
            puissances.add(pi);
        }
        Collections.sort(puissances);
        if(puissances.size()==3){
            results.add(puissances.get(0));
            results.add(puissances.get(2)-puissances.get(1));
        } 

      for(int j=0,k=1;j<puissances.size()&&k<puissances.size();j=j+2,k=k+2){

              results.add(puissances.get(k)-puissances.get(j));


      }

        Collections.sort(results); 
        System.out.println(results.get(0));

            

    }
}
