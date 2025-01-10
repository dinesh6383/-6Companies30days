package Amazon;

import java.util.*;

class TreeNodes {
    int val;
    TreeNodes left;
    TreeNodes right;

    public TreeNodes(int value) {
        this.val = value;
    }
}

public class Serialize_And_Deserialize_Binary_Tree {
    public static TreeNodes deserialize(String data) {
        if(data.length() == 0) return null;

        String[] arr = data.split("/");
        int n = arr.length;

        Queue<TreeNodes> queue = new LinkedList<>();
        TreeNodes root = new TreeNodes(Integer.parseInt(arr[0]));
        queue.add(root);

        int p1 = 1, p2 = p1 + 1;
        while(p1 < n && !queue.isEmpty()) {
            TreeNodes curr = queue.poll();

            if(p1 < n && !arr[p1].equals("a")) {
                TreeNodes leftChild = new TreeNodes(Integer.parseInt(arr[p1]));
                curr.left = leftChild;
                queue.add(leftChild);
            }

            if(p2 < n && !arr[p2].equals("a")) {
                TreeNodes rightChild = new TreeNodes(Integer.parseInt(arr[p2]));
                curr.right = rightChild;
                queue.add(rightChild);
            }
            p1 += 2;
            p2 = p1 + 1;
        }
        return root;
    }

    public static String serialize(TreeNodes root) {
        if(root == null) return "";

        StringBuilder result = new StringBuilder();
        Queue<TreeNodes> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            TreeNodes curr = queue.poll();
            if(curr == null) {
                result.append("a/");
                continue;
            }

            result.append(curr.val + "/");
            queue.add(curr.left);
            queue.add(curr.right);
        }

        int idx = result.length() - 1;
        while(result.charAt(idx) == '/' || result.charAt(idx) == 'a') {
            result.deleteCharAt(idx);
            idx = result.length() - 1;
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String str = "1/2/a/2/1/3/4/5";
        TreeNodes deserializedString = deserialize(str);
        String serializeTreeNode = serialize(deserializedString);
        System.out.println(deserializedString);
        System.out.println(serializeTreeNode);
    }
}
