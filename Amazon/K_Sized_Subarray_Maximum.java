package Amazon;
import java.util.*;

public class K_Sized_Subarray_Maximum {
    public static ArrayList<Integer> maxOfSubarrays(int arr[], int k) {
        ArrayList<Integer> result = new ArrayList<>();
        Deque<Integer> dq = new ArrayDeque<>();
        int n = arr.length;

        for(int i = 0; i < k; i++) {
            handleOperation(arr, dq, arr[i]);
        }

        result.add(dq.getFirst());
        
        int p1 = 1, p2 = p1 + k - 1;
        while(p1 <= p2 && p2 < n) {
            int remove = arr[p1 - 1];
            int add = arr[p2];

            if(dq.getFirst() == remove) dq.removeFirst();
            handleOperation(arr, dq, add);
            result.add(dq.getFirst());

            p1++;
            p2 = p1 + k - 1;
        }
        return result;
    }

    public static void handleOperation(int[] arr, Deque<Integer> dq, int add) {
        while(!dq.isEmpty() && dq.getLast() < add) {
            dq.removeLast();
        }
        dq.addLast(add);
    } 

    public static void main(String[] args) {
        int[] arr = {8, 5, 10, 7, 9, 4, 15, 12, 90, 13};
        int k = 5;
        ArrayList<Integer> result = maxOfSubarrays(arr, k);
        System.out.println(result);
    }
}
