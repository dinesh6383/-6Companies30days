import java.util.*;

public class Two_Palindrom_Subsequence {
    public static int maxProduct(String s) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        char[] arr = s.toCharArray();
        int n = arr.length;

        for(int mask = 0 ; mask < (1 << n) ; mask++) {
            String temp = "";
            for(int i = 0 ; i < n ; i++) {
                if((mask & 1 << i) > 0) {
                    temp += arr[i];
                }
            }

            if(isValid(temp)) hm.put(mask, temp.length());
        }

        int result = 0;
        for(int mask1 : hm.keySet()) {
            for(int mask2 : hm.keySet()) {
               if((mask1 & mask2) == 0) result = Math.max(result, hm.get(mask1) * hm.get(mask2)); 
            }
        }

        return result;
    }

    public static boolean isValid(String s) {
        int p1 = 0, p2 = s.length() - 1;
        while(p1 < p2) {
            if(s.charAt(p1) != s.charAt(p2)) return false;
            p1++;
            p2--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "leetcodecom";
        int result = maxProduct(s);
        System.out.println(result);
    }
    
}
