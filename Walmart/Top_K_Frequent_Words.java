package Walmart;

import java.util.*;
class Pairs {
    String word;
    int count = 0;

    public Pairs(String word, int cnt) {
        this.word = word;
        this.count = cnt;
    }
}

public class Top_K_Frequent_Words {
    public static List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> frequency = new HashMap<>();
        for(String temp : words) {
            if(!frequency.containsKey(temp)) {
                frequency.put(temp, 1);
            } else {
                frequency.put(temp, frequency.get(temp) + 1);
            }
        }
        
        PriorityQueue<Pairs> pq = new PriorityQueue<>((a, b) -> b.count != a.count ? b.count - a.count : a.word.compareToIgnoreCase(b.word));
        for(String key : frequency.keySet()) {
            pq.add(new Pairs(key, frequency.get(key)));
        }

        List<String> result = new ArrayList<>();
        int valid = k;
        while(valid > 0) {
            result.add(pq.poll().word);
            valid--;
        }
        return result;
    }
    
    public static void main(String[] args) {
        String[] words = {"glarko","zlfiwwb","nsfspyox","pwqvwmlgri","qggx","qrkgmliewc","zskaqzwo","zskaqzwo","ijy","htpvnmozay","jqrlad","ccjel","qrkgmliewc","qkjzgws","fqizrrnmif","jqrlad","nbuorw","qrkgmliewc","htpvnmozay","nftk","glarko","hdemkfr","axyak","hdemkfr","nsfspyox","nsfspyox","qrkgmliewc","nftk","nftk","ccjel","qrkgmliewc","ocgjsu","ijy","glarko","nbuorw","nsfspyox","qkjzgws","qkjzgws","fqizrrnmif","pwqvwmlgri","nftk","qrkgmliewc","jqrlad","nftk","zskaqzwo","glarko","nsfspyox","zlfiwwb","hwlvqgkdbo","htpvnmozay","nsfspyox","zskaqzwo","htpvnmozay","zskaqzwo","nbuorw","qkjzgws","zlfiwwb","pwqvwmlgri","zskaqzwo","qengse","glarko","qkjzgws","pwqvwmlgri","fqizrrnmif","nbuorw","nftk","ijy","hdemkfr","nftk","qkjzgws","jqrlad","nftk","ccjel","qggx","ijy","qengse","nftk","htpvnmozay","qengse","eonrg","qengse","fqizrrnmif","hwlvqgkdbo","qengse","qengse","qggx","qkjzgws","qggx","pwqvwmlgri","htpvnmozay","qrkgmliewc","qengse","fqizrrnmif","qkjzgws","qengse","nftk","htpvnmozay","qggx","zlfiwwb","bwp","ocgjsu","qrkgmliewc","ccjel","hdemkfr","nsfspyox","hdemkfr","qggx","zlfiwwb","nsfspyox","ijy","qkjzgws","fqizrrnmif","qkjzgws","qrkgmliewc","glarko","hdemkfr","pwqvwmlgri"};
        int k = 14;
        List<String> result = topKFrequent(words, k);
        System.out.println(result);
    }
}
