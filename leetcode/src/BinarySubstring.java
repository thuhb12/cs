/*
696. Count Binary Substrings
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BinarySubstring {
    public static void main(String[] args) {
        BinarySubstring binarySubstring = new BinarySubstring();
        System.out.println(binarySubstring.countBinarySubstrings("010101"));
    }
    public int countBinarySubstrings(String s) {
        char pre = s.charAt(0);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < s.length(); ) {
            pre = s.charAt(i);
            int count = 0;
            while(i < s.length()) {
                if (s.charAt(i) == pre) {
                    count++;
                    i++;
                    if (i == s.length()) {
                        list.add(count);
                    }
                } else {
                    list.add(count);
                    break;
                }
            }
        }
        int m = 0;
        for (int i = 0; i < list.size()-1; i++) {
            m += Math.min(list.get(i), list.get(i+1));
        }
        return m;
    }
}