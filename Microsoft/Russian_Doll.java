import java.util.*;

public class Russian_Doll {
    public static int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        return LongestIncreasingSubSequence(envelopes);
    }

    public static int LongestIncreasingSubSequence(int[][] arr) {
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(arr[0][1]);

        for(int i = 1 ; i < arr.length ; i++) {
            if(arr[i][1] > temp.get(temp.size() - 1)) {
                temp.add(arr[i][1]);
            } else {
                int idx = binarySearch(temp, arr[i][1]);
                temp.set(idx, arr[i][1]);
            }
        }

        return temp.size();
    }

    public static int binarySearch(ArrayList<Integer> arr, int tgt) {
        int low = 0, high = arr.size() - 1;
        while(low <= high) {
            int mid = (low + high) / 2;
            if(arr.get(mid) < tgt) low = mid + 1;
            else high = mid - 1;
        }

        return low < arr.size() ? low : arr.size() - 1;
    }

    public static void main(String[] args) {
        int[][] envelopes = {{1,1},{1,1},{1,1},{1,1}};
        int result = maxEnvelopes(envelopes);
        System.out.println(result);
    }
}
