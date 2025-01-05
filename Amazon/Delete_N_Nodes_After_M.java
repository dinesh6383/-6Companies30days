package Amazon;
class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Delete_N_Nodes_After_M {
  public static void linkdelete(Node head, int n, int m) {
    // your code here
    int currCount = 0;
    int deletedCount = 0;
    Node prev = null;
    Node curr = head;

    while(curr != null) {
        if(currCount == m && deletedCount < n) {
            curr = curr.next;
            prev.next = curr;
            deletedCount++;
        } else if(currCount < m) {
            prev = curr;
            curr = curr.next;
            currCount++;
        } else if(currCount == m && deletedCount == n) {
            currCount = 0;
            deletedCount = 0;
        }
    }
  }

  public static Node createLinkedList(int[] arr) {
    Node head = null;
    Node tail = null;

    for(int i = 0; i < arr.length; i++) {
        if(head == null) {
            head = new Node(arr[i]);
            tail = head;
        } else {
            tail.next = new Node(arr[i]);
            tail = tail.next;
        }
    }

    return head;
  }

  public static void printLinkedList(Node head) {
    Node temp = head;
    while(temp != null) {
        int value = temp.data;
        System.out.print("--> " + value);
        temp = temp.next;
    }
  }

  public static void main(String[] args) {
    int[] linkedListArr = {1,2,3,4,5,6};
    int n = 1;
    int m = 6;
    Node head = createLinkedList(linkedListArr);
    linkdelete(head, n, m);
    printLinkedList(head);
  }
}
