package Amazon;

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

public class Time_For_Binary_Tree_To_Infected {
    public static int amountOfTime(TreeNode root, int start) {
        TreeNode starter = getStartedNode(root, start);
        HashSet<Integer> visited = new HashSet<>();
        HashMap<Integer, TreeNode> parentData = new HashMap<>();
        getParentNodes(root, parentData);
        visited.add(start);
        return getMaximumTime(starter, parentData, visited);
    }

    public static int getMaximumTime(TreeNode node, HashMap<Integer, TreeNode> parent, HashSet<Integer> visited) {
        // parent, left and right
        int parentSide = 0;
        int leftSide = 0;
        int rightSide = 0;

        if(parent.containsKey(node.val)) {
            int parentVal = parent.get(node.val).val;
            if(!visited.contains(parentVal)) {
                visited.add(parentVal);
                parentSide = 1 + getMaximumTime(parent.get(node.val), parent, visited);
            }
        }

        if(node.left != null && !visited.contains(node.left.val)) {
            visited.add(node.left.val);
            leftSide = 1 + getMaximumTime(node.left, parent, visited);
        }

        if(node.right != null && !visited.contains(node.right.val)) {
            visited.add(node.right.val);
            rightSide = 1 + getMaximumTime(node.right, parent, visited);
        }
        
        return Math.max(parentSide, Math.max(leftSide, rightSide));
    }

    public static void getParentNodes(TreeNode node, HashMap<Integer, TreeNode> parent) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);

        while(!queue.isEmpty()) {
            TreeNode top = queue.poll();

            if(top.left != null) {
                parent.put(top.left.val, top);
                queue.add(top.left);
            }

            if(top.right != null) {
                parent.put(top.right.val, top);
                queue.add(top.right);
            }
        }
    }

    public static TreeNode getStartedNode(TreeNode node, int target) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);

        while(!queue.isEmpty()) {
            TreeNode top = queue.poll();

            if(top.val == target) return top;

            if(top.left != null) {
                queue.add(top.left);
            }

            if(top.right != null) {
                queue.add(top.right);
            }
        }

        return null;
    }


    // created for my local testing purpose
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
        int[] arr = {1,2,-1,3,-1,4,-1,5};
        int start = 2;
        TreeNode root = createBinaryTree(arr);
        int result = amountOfTime(root, start);
        System.out.println(result);
    }
}