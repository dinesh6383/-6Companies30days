import java.util.*;

public class Circular_Game {
    public static void main(String[] args) {
        int result = findTheWinner(5, 2);
        int result1 = findTheWinner1(5, 2);
        int result2 = findTheWinner2(5, 2);
        System.out.println(result);
        System.out.println(result1);
        System.out.println(result2);
    }

    // using deque
    public static int findTheWinner(int n, int k) {
        Deque<Integer> queue = new ArrayDeque<>();

        for(int i = 1 ; i <= n ; i++) {
            queue.addLast(i);
        }

        while(queue.size() > 1) {
            for(int i = 1 ; i < k ; i++) {
                int front = queue.removeFirst();
                queue.addLast(front);
            }
            queue.removeFirst();
        }

        return queue.getFirst();
    }

    // using recursive approach
    public static int findTheWinner1(int n, int k) {
        if(n == 1) return 0;

        return (findTheWinner(n - 1, k) + k) % n;
    }

    // using iterative approach
    public static int findTheWinner2(int n, int k) {
        int result = 0;
        for(int i = 2; i <= n ; i++) {
            result = (result + k) % i;
        }

        return result + 1;
    }
}
