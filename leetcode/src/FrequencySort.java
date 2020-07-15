/*
451. Sort Characters By Frequency
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FrequencySort {
    public static void main(String[] args) {
        FrequencySort frequencySort = new FrequencySort();
        String s = "Aabb";
        System.out.println(frequencySort.frequencySort(s));
    }

    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        Map<Integer, List<Character>> char2frequency = new HashMap<>();
        for (char ch : map.keySet()) {
            int count = map.get(ch);
            List<Character> list = char2frequency.get(count);
            if (list == null) {
                list = new ArrayList<>();
                list.add(ch);
                char2frequency.put(count, list);
            } else {
                list.add(ch);
            }
        }
        List<Integer> frequency = new ArrayList<>(char2frequency.keySet());
        Collections.sort(frequency);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = frequency.size()-1; i >= 0; i--) {
            Integer count = frequency.get(i);
            List<Character> list = char2frequency.get(count);
            for (char ch : list) {
                stringBuilder.append(getString(ch, count));
            }
        }
        return stringBuilder.toString();
    }

    private String getString(char ch, int times) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < times; i++) {
            stringBuilder.append(ch);
        }
        return stringBuilder.toString();
    }
}
