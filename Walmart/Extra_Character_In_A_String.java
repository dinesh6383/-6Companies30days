package Walmart;

import java.util.*;

public class Extra_Character_In_A_String {
    public static int minExtraChar(String s, String[] dictionary) {
        HashSet<String> dict = new HashSet<>();
        for(String curr : dictionary) {
            dict.add(curr);
        }
        
        int n = s.length();
        int[] dp = new int[n + 1];
        for(int i = 0; i <= n; i++) {
            dp[i] = n;
        }
        dp[0] = 0;

        for(int i = 1; i <= n; i++) {
            for(int j = 0; j < i; j++) {
                String sub = s.substring(j, i);
                if(dict.contains(sub)) {
                    dp[i] = Math.min(dp[i], dp[j]);
                }
            }
            dp[i] = Math.min(dp[i], dp[i - 1] + 1);
        }
        return dp[n];
    }
    public static void main(String[] args) {
        String s = "ecolloycollotkvzqpdaumuqgs";
        String[] dictionary = {"flbri","uaaz","numy","laper","ioqyt","tkvz","ndjb","gmg","gdpbo","x","collo","vuh","qhozp","iwk","paqgn","m","mhx","jgren","qqshd","qr","qpdau","oeeuq","c","qkot","uxqvx","lhgid","vchsk","drqx","keaua","yaru","mla","shz","lby","vdxlv","xyai","lxtgl","inz","brhi","iukt","f","lbjou","vb","sz","ilkra","izwk","muqgs","gom","je"};
        int result = minExtraChar(s, dictionary);
        System.out.println(result);
    }
}
