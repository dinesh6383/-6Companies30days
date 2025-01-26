package GoldmanSachs;

import java.util.ArrayList;
import java.util.List;

public class Letter_Combination_Of_A_Phone_Number { 
    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        if(digits.length() == 0) return result;
        
        String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        int n = digits.length();
        findCombinations(digits, 0, "", n, map, result);
        return result;
    }

    public static void findCombinations(String digits, int idx, String curr, int n, String[] map, List<String> result) {
        if(idx == n) {
            result.add(curr);
            return;
        }

        String curStr = map[digits.charAt(idx) - '0'];
        for(int i = 0; i < curStr.length(); i++) {
            char currChar = curStr.charAt(i);
            findCombinations(digits, idx + 1, curr + currChar, n, map, result);
        }
    }
    public static void main(String[] args) {
        String digits = "23";
        List<String> result = letterCombinations(digits);
        System.out.println(result);
    }
}
