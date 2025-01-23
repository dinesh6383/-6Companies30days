package Atlassian;

import java.util.*;

public class Find_Beautiful_Indices_In_The_Given_Array_I {
    public static List<Integer> beautifulIndices(String s, String a, String b, int k) {
        List<Integer> result = new ArrayList<>();
        List<Integer> b_indices = new ArrayList<>();

        for(int i = 0; i <= s.length() - b.length(); i++) {
            if(s.charAt(i) == b.charAt(0) && isValid(s, i, b)) {
                b_indices.add(i);
            }
        }

        for(int i = 0; i <= s.length() - a.length(); i++) {
            if(s.charAt(i) == a.charAt(0) && isValid(s, i, a)) {
                for(int j = 0; j < b_indices.size(); j++) {
                    if(Math.abs(b_indices.get(j) - i) <= k) {
                        result.add(i);
                        break;
                    }
                }
            }
        }

        return result;
    }

    public static boolean isValid(String str1, int idx, String str2) {
        int i = idx, j = 0;
        while(i < str1.length() && j < str2.length()) {
            if(str1.charAt(i) != str2.charAt(j)) return false;
            i++;
            j++;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "isawsquirrelnearmysquirrelhouseohmy";
        String a = "my";
        String b = "squirrel";
        int k = 15;
        List<Integer> result = beautifulIndices(s, a, b, k);
        System.out.println(result);
    }
}
