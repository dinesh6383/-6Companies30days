package GoldmanSachs;

import java.util.LinkedList;
import java.util.Queue;

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

class Pair {
    int sum;
    int leftMax;
    int rightMin;

    public Pair(int sum, int leftMax, int rightMin) {
        this.sum = sum;
        this.leftMax = leftMax;
        this.rightMin = rightMin;
    }
}

public class Maximum_Sum_BST_In_Binary_Tree {
    public static int maxSumBST(TreeNode root) {
        int result[] = {0};
        traverse(root, result);
        return result[0];
    }

    public static Pair traverse(TreeNode node, int[] result) {
        if(node == null) {
            return new Pair(0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        Pair left = traverse(node.left, result);
        Pair right = traverse(node.right, result);

        if(left == null || right == null) return null;
        if(node.val <= left.rightMin || node.val >= right.leftMax) return null;

        result[0] = Math.max(result[0], left.sum + right.sum + node.val);

        return new Pair(left.sum + right.sum + node.val, Math.min(left.leftMax, node.val), Math.max(right.rightMin, node.val));
    }

    // created for my local testing purpose
    public static TreeNode createBinaryTree(int[] arr) {
        TreeNode result = new TreeNode(arr[0], null, null);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(result);

        int p1 = 1, p2 = p1 + 1;
        while(!queue.isEmpty() && p1 < arr.length) {
            TreeNode top = queue.poll();

            if(p1 < arr.length && arr[p1] != Integer.MAX_VALUE) {
                TreeNode left = new TreeNode(arr[p1], null, null);
                top.left = left;
                queue.add(left);
            }

            if(p2 < arr.length && arr[p2] != Integer.MAX_VALUE) {
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
        int max = Integer.MAX_VALUE;
        // int[] arr = {1,4,3,2,4,2,5,max,max,max,max,max,max,4,6};
        int[] arr = {1,max,10,-5,20};
        // int[] arr = {1,2,3,0,6,-1,8};
        TreeNode root = createBinaryTree(arr);
        int result = maxSumBST(root);
        System.out.println(result);
    }
}
