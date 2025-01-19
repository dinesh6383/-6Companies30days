package Google;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Number_Of_Good_Leaf_Nodes_Pairs {
    public static int answer = 0;
    public static int countPairs(TreeNode root, int distance) {
        getPairsCount(root, distance);
        return answer;
    }

    public static ArrayList<Integer> getPairsCount(TreeNode node, int distance) {
        if(node == null) return new ArrayList<>();
        if(node.left == null && node.right == null) {
            ArrayList<Integer> bucket = new ArrayList<>();
            bucket.add(1);
            return bucket;
        }

        ArrayList<Integer> left = getPairsCount(node.left, distance);
        ArrayList<Integer> right = getPairsCount(node.right, distance);

        for(int i = 0; i < left.size(); i++) {
            for(int j = 0; j < right.size(); j++) {
                if(left.get(i) + right.get(j) <= distance) answer++;
            }
        }

        ArrayList<Integer> combinedList = new ArrayList<>();
        for(int num : left) {
            if(num < distance) combinedList.add(num + 1);
        }

        for(int num : right) {
            if(num < distance) combinedList.add(num + 1);
        }

        return combinedList;
    }

    public static TreeNode createBinaryTree(int[] arr) {
        TreeNode result = new TreeNode(arr[0], null, null);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(result);

        int p1 = 1, p2 = p1 + 1;
        while(!queue.isEmpty() && p1 < arr.length) {
            TreeNode top = queue.poll();

            if(p1 < arr.length && arr[p1] > 0) {
                TreeNode left = new TreeNode(arr[p1], null, null);
                top.left = left;
                queue.add(left);
            }

            if(p2 < arr.length && arr[p2] > 0) {
                TreeNode right = new TreeNode(arr[p2], null, null);
                top.right = right;
                queue.add(right);
            }

            p1 += 2;
            p2 += 2;
        }

        return result;
    }
    public static void main(String[] args) {
        int[] arr = {7,1,4,6,-1,5,3,-1,-1,-1,-1,-1,2};
        TreeNode root = createBinaryTree(arr);
        int result = countPairs(root, 3);
        System.out.println(result);
    }
}
