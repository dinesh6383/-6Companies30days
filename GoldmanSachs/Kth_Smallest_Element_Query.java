package GoldmanSachs;

import java.util.PriorityQueue;
class Paire {
    String str;
    int index;

    public Paire(String str, int idx) {
        this.str = str;
        this.index = idx;
    }
}

public class Kth_Smallest_Element_Query {
    public static int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
       int[] result = new int[queries.length];
        PriorityQueue<Paire> pq = new PriorityQueue<>((a, b) -> a.str.compareTo(b.str) != 0 ? a.str.compareTo(b.str) : a.index - b.index);
        
        for(int i = 0; i < queries.length; i++) {
            int trim = queries[i][1];
            int smallest = queries[i][0];
            for(int j = 0; j < nums.length; j++) {
                String num = nums[j];
                pq.add(new Paire(num.substring(num.length() - trim), j));
            }
            
            int index = -1;
            while(smallest > 0) {
                index = pq.poll().index;
                smallest--;
            }
            result[i] = index;
            pq.clear();
        }

        return result; 
    }

    public static void main(String[] args) {
        String[] nums = {"24", "37", "96", "04"};
        int[][] queries = {{2,1}, {2,2}};
        int[] result = smallestTrimmedNumbers(nums, queries);
        System.out.println(result);
    }
}
