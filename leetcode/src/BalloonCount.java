/*
1189. Maximum Number of Balloons
 */
import java.util.HashMap;
import java.util.Map;

public class BalloonCount {
    public int maxNumberOfBalloons(String text) {
        Map<Character, Integer> map = new HashMap<>();
        String balloon = "balloon";
        for (int i = 0; i < text.length(); i++) {
            map.put(text.charAt(i), map.getOrDefault(text.charAt(i), 0) + 1);
        }
        int b = map.getOrDefault('b', 0);
        int m = b;
        int a = map.getOrDefault('a', 0);
        m = Math.min(m, a);
        int l = map.getOrDefault('l', 0) / 2;
        m = Math.min(m, l);
        int o = map.getOrDefault('o', 0) / 2;
        m = Math.min(m, o);
        int n = map.getOrDefault('n', 0);
        m = Math.min(m, n);
        return m;
    }
}