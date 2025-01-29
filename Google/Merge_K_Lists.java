package Google;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { 
        this.val = val; 
    }     
    ListNode(int val, ListNode next) { 
        this.val = val; this.next = next; 
    }
}

public class Merge_K_Lists {
    public static ListNode mergeLinkedList(ListNode node1, ListNode node2) {
        ListNode head = null;
        ListNode tail = null;

        while(node1 != null && node2 != null) {
            if(node1.val <= node2.val) {
                if(head == null) {
                    head = node1;
                    tail = head;
                } else {
                    tail.next = node1;
                    tail = tail.next;
                }
                node1 = node1.next;
            } else {
                if(head == null) {
                     head = node2;
                     tail = head;
                } else {
                    tail.next = node2;
                    tail = tail.next;
                }
                node2 = node2.next;
            }
        }

        while(node1 != null) {
            if(head == null) {
                head = node1;
                tail = head;
            } else {
                tail.next = node1;
                tail = tail.next;
            }
            node1 = node1.next;
        }

        while(node2 != null) {
            if(head == null) {
                head = node2;
                tail = head;
           } else {
               tail.next = node2;
               tail = tail.next;
           }
           node2 = node2.next;
        }

        return head;
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        
        ListNode prev = lists[0];
        for(int i = 1; i < lists.length; i++) {
            prev = mergeLinkedList(prev, lists[i]);
        }
        return prev;
    }

    public static ListNode createLinkedList(int[] arr) {
        ListNode head = null;
        ListNode tail = null;

        for(int i = 0; i < arr.length; i++) {
            int temp = arr[i];
            if(head == null) {
                head = new ListNode(temp);
                tail = head;
            } else {
                tail.next = new ListNode(temp);
                tail = tail.next;
            }
        }

        return head;
    }
    public static void main(String[] args) {
        int[][] array = {{1,4,5}, {1,3,4}, {2,6}};
        ListNode[] lists = new ListNode[array.length];
        for(int i = 0; i < array.length; i++) {
            lists[i] = createLinkedList(array[i]);
        }

        ListNode result = mergeKLists(lists);
        System.out.println(result.next.next.val);
    }
}
