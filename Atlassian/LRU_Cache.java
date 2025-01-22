package Atlassian;

import java.util.HashMap;

class Node {
    int key;
    int value;
    Node prev;
    Node next;

    public Node(int key, int val) {
        this.key = key;
        this.value = val;
        this.prev = null;
        this.next = null;
    }
}

class LRUCache {
    Node head = new Node(0, 0);
    Node tail = new Node(0, 0);
    HashMap<Integer, Node> hm = new HashMap<>();
    int usage;

    public LRUCache (int capacity) {
        usage = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if(hm.containsKey(key)) {
            Node node = hm.get(key);
            remove(node);
            insert(node);
            return node.value;
        } 
        return -1;
    }

    public void put(int key, int value) {
        if(hm.containsKey(key)) {
            remove(hm.get(key));
        }

        if(hm.size() == usage) {
            remove(tail.prev);
        }

        insert(new Node(key, value));
    }

    public void remove(Node node) {
        hm.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void insert(Node node) {
        hm.put(node.key, node);
        node.next = head.next;
        node.prev = head;
        node.next.prev = node;
        head.next = node;
    }
}

public class LRU_Cache {
    public static void main(String[] args) {
        LRUCache obj = new LRUCache(2);
        System.out.println(obj.get(2));
        obj.put(2, 6);
        System.out.println(obj.get(1));
        obj.put(1, 5);
        obj.put(1, 2);
        System.out.println(obj.get(1));
        System.out.println(obj.get(2));
    }
}
//[[1],[2,1],[2],[3,2],[2],[3]]
//[[2],[2],[2,6],[1],[1,5],[1,2],[1],[2]]