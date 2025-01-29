package GoldmanSachs;

import java.util.*;

public class Run_Length_Encoding {
    public static String encode(String s) {
        int n = s.length();
        StringBuilder result = new StringBuilder();

        char prev = s.charAt(0);
        int freq = 1;

        for(int i = 1; i < s.length(); i++) {
            char curr = s.charAt(i);
            if(curr == prev) freq++;
            else {
                result.append(prev);
                result.append(freq);
                prev = curr;
                freq = 1;
            }
        }
        
        result.append(prev);
        result.append(freq);
        return result.toString();
    }
    public static void main(String[] args) {
        String s = "aaaaaaa";
        String result = encode(s);
        System.out.println(result);
    }
}
