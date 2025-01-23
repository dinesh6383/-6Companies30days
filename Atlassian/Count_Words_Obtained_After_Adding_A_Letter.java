package Atlassian;

import java.util.*;

public class Count_Words_Obtained_After_Adding_A_Letter {
    public static int wordCount(String[] startWords, String[] targetWords) {
        HashSet<String> bucket = new HashSet<>();
        for(String str : startWords) {
            char[] temp = str.toCharArray();
            Arrays.sort(temp);
            String curr = new String(temp);
            bucket.add(curr);
        }


        int result = 0;
        for(int k = 0; k < targetWords.length; k++) {
            String str = targetWords[k];
            char[] temp = str.toCharArray();
            Arrays.sort(temp);
            str = new String(temp);

            for(int i = 0; i < str.length(); i++) {
                String tempWord = str.substring(0, i) + str.substring(i + 1);
                System.out.println(tempWord + " " + bucket.contains(tempWord));
                if(bucket.contains(tempWord)) {
                    result++;
                    break;
                }
            }
        }

        return result;
    }
    public static void main(String[] args) {
        String[] startWords = {"g","vf","ylpuk","nyf","gdj","j","fyqzg","sizec"};
        String[] targetWords = {"r","am","jg","umhjo","fov","lujy","b","uz","y"};
        int result = wordCount(startWords, targetWords);
        System.out.println(result);
    }
}
