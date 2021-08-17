import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String MESSAGE = in.nextLine().chars()
        .mapToObj(i->{ String conv= Integer.toBinaryString(i);
                       return conv.length()==6?"0"+conv:conv;
            }).collect(Collectors.joining());
        final Pattern pattern = Pattern.compile("(1{1,}|0{1,})");
        final Matcher matcher = pattern.matcher(MESSAGE);
        StringBuilder sb =new StringBuilder();
        while (matcher.find()){
            for (int i = 0; i < matcher.groupCount(); i++) {
                sb=matcher.group(i).contains("1")?
                sb.append("0 "+matcher.group(i).replaceAll("1","0")+" "):sb.append("00 "+matcher.group(i)+" ");
            }
        }
        System.out.println(sb.substring(0,sb.length()-1));









    }
}
