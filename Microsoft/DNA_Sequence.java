import java.util.ArrayList;
import java.util.HashMap;

public class DNA_Sequence {
    public static void main(String[] args) {
        String s = "AAAAAAAAAAAAA";
        ArrayList<String> result = findRepeatedDnaSequence(s);
        System.out.println(result);
    }

    public static ArrayList<String> findRepeatedDnaSequence(String s) {
        ArrayList<String> result = new ArrayList<String>();
        HashMap<String, Integer> hm = new HashMap<>();
        
        for(int i = 0; i <= s.length() - 10; i++) {
            String curr = s.substring(i, i + 10);

            if(!hm.containsKey(curr)) hm.put(curr, 1);
            else hm.put(curr, hm.get(curr) + 1);
        }

        for(String key : hm.keySet()) {
            int freq = hm.get(key);
            if(freq > 1) result.add(key);
        }

        return result;
    }
}
