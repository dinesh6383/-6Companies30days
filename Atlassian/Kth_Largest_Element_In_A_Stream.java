package Atlassian;

import java.util.PriorityQueue;

class kthLargest {
    int k;
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    public kthLargest(int max, int[] nums) {
        this.k = max;
        for(int num : nums) {
            this.add(num);
        }
    }

    public int add(int val) {
        if(pq.size() == k && val <= pq.peek()) return pq.peek();
        
        while(pq.size() == k && pq.peek() < val) {
            pq.poll();
        }
        pq.add(val);

        return pq.peek();
    }
}

public class Kth_Largest_Element_In_A_Stream {
    public static void main(String[] args) {
        kthLargest obj = new kthLargest(3, new int[] {1,1});
        System.out.println(obj.add(1));
        System.out.println(obj.add(1));
        System.out.println(obj.add(3));
        System.out.println(obj.add(3));
        System.out.println(obj.add(3));
        System.out.println(obj.add(4));
        System.out.println(obj.add(4));
        System.out.println(obj.add(4));
    }
}
