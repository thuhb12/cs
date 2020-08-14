import java.util.ArrayList;
import java.util.List;

/*
89. Gray Code
 */
public class GrayCode {
    public static void main(String[] args) {
        GrayCode grayCode = new GrayCode();
        System.out.println(grayCode.grayCode(2));
    }
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        List<String> s = generateCode(n);
        for (String t : s) {
            result.add(Integer.parseInt(t, 2));
        }
        return result;
    }

    private List<String> generateCode(int n) {
        List<String> list = new ArrayList<>();
        if (n == 0) {
            list.add("0");
            return list;
        } else if (n == 1) {
            list.add("0");
            list.add("1");
            return list;
        } else {
            List<String> s = generateCode(n - 1);
            for (String t : s) {
                list.add("0" + t);
            }
            for (int i = s.size()-1; i >= 0; i--) {
                String t = s.get(i);
                list.add("1" + t);
            }
            return list;
        }

    }

//    private int valueOf(String s) {
//        int sum = 0;
//        for (int i = 0; i < s.length(); i++) {
//
//        }
//    }
}
