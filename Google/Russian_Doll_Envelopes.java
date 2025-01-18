package Google;

import java.util.*;

public class Russian_Doll_Envelopes {
    public static int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]);
        return getMaximumRussianDolls(envelopes);
    }

    public static int getMaximumRussianDolls(int[][] envelopes) {
        ArrayList<Integer> bucket = new ArrayList<>();
        bucket.add(envelopes[0][1]);

        for(int i = 1; i < envelopes.length; i++) {
            int currDoll = envelopes[i][1];
            if(currDoll > bucket.get(bucket.size() - 1)) {
                bucket.add(currDoll);
            } else {
                int insertIndex = getInsertionIndex(bucket, currDoll);
                bucket.set(insertIndex, currDoll);
            }
        }
        return bucket.size();
    }

    public static int getInsertionIndex(ArrayList<Integer> bucket, int target) {
        int low = 0, high = bucket.size() - 1;
        while(low <= high) {
            int mid = (low + high) / 2;
            if(bucket.get(mid) < target) low = mid + 1;
            else high = mid - 1;
        }
        return low < bucket.size() ? low : bucket.size() - 1;
    }
    public static void main(String[] args) {
        int[][] envelopes = {{15,8},{2,20},{2,14},{4,17},{8,19},{8,9},{5,7},{11,19},{8,11},{13,11},{2,13},{11,19},{8,11},{13,11},{2,13},{11,19},{16,1},{18,13},{14,17},{18,19}};
        int result = maxEnvelopes(envelopes);
        System.out.println(result);
    }
}
