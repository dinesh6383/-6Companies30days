package Walmart;

import java.util.*;

class Combo {
    char c;
    int count = 0;

    public Combo(char c, int cnt) {
        this.c = c;
        this.count = cnt;
    }
}

public class Sort_Characters_By_Frequency {
    public static String frequencySort(String s) {
        HashMap<Character, Integer> frequency = new HashMap<>();
        for(char c1 : s.toCharArray()) {
            if(!frequency.containsKey(c1)) {
                frequency.put(c1, 1);
            } else {
                frequency.put(c1, frequency.get(c1) + 1);
            }
        }

        ArrayList<Combo> arr = new ArrayList<>();
        for(Character key : frequency.keySet()) {
            arr.add(new Combo(key, frequency.get(key)));
        }

        Collections.sort(arr, (a, b) -> b.count - a.count);
        String result = "";
        for(Combo temp : arr) {
            for(int i = 0; i < temp.count; i++) {
                result += temp.c;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        String s = "2a554442f544asfasssffffasss";
        String result = frequencySort(s);
        System.out.println(result);
    }
}