package Walmart;

import java.util.*;

public class Word_Break {
    public static boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> bucket = new HashSet<>(wordDict);
        HashMap<String, Boolean> cache = new HashMap<>();
        return breakWords(s, bucket, cache);
    }

    public static boolean breakWords(String str, HashSet<String> dict, HashMap<String, Boolean> cache) {
        if(cache.containsKey(str)) return cache.get(str);
        if(dict.contains(str)) return true;
        for(int i = 1; i < str.length(); i++) {
            String temp = str.substring(0, i);
            if(dict.contains(temp) && breakWords(str.substring(i), dict, cache)) {
                cache.put(str, true);
                return true;
            }
        }
        cache.put(str, false);
        return false;
    }
    public static void main(String[] args) {
        String s = "catsanddog";
        List<String> wordDict = new ArrayList<>();
        // wordDict.add("leet");
        // wordDict.add("code");
        wordDict.add("cats");
        wordDict.add("dogs");
        wordDict.add("sand");
        wordDict.add("ash");
        wordDict.add("cat");
        boolean result = wordBreak(s, wordDict);
        System.out.println(result);
    }
}

//["cats","dog","sand","and","cat"]