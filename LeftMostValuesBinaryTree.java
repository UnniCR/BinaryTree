package come.unni.test;

import java.util.ArrayDeque;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class LeftMostValuesBinaryTree {

    // Function to print leftmost values of a binary tree
    public static void printLeftMost(TreeNode root) {
        if (root == null)
            return;

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean found = false;

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (!found) {
                    System.out.print(node.val + " ");
                    found = true;
                }

                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
        }
    }

    // Example usage
    public static void main(String[] args) {
        // Example binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);

        System.out.println("Leftmost values of the binary tree:");
        printLeftMost(root);
    }
}
