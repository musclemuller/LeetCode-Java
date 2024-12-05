package problems._99_RecoverBinarySearchTree;

import Helper.TreeNode;

public class RecoverBinarySearchTree {
    TreeNode first = null, second = null;
    TreeNode prev = new TreeNode(Integer.MIN_VALUE);

    public void recoverTree(TreeNode root) {
        inorderTraverse(root);

        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    void inorderTraverse(TreeNode root) {
        if (root == null) return;
        inorderTraverse(root.left);
        if (root.val < prev.val) {
            if (first == null) {
                first = prev;
            }
            second = root;
        }
        prev = root;
        inorderTraverse(root.right);
    }

    public static void main(String[] args) {
        RecoverBinarySearchTree solution = new RecoverBinarySearchTree();
        // Print method to show tree structure
        System.out.println("\nTest Case 1: [1,3,null,null,2]");
        System.out.println("Before recovery:");
        TreeNode test1 = new TreeNode(1);
        test1.left = new TreeNode(3);
        test1.left.right = new TreeNode(2);
        TreeNode.levelOrderTraversal(test1);
        System.out.println("\nAfter recovery:");
        solution.recoverTree(test1);
        TreeNode.levelOrderTraversal(test1);
        System.out.println("\n");

        // Create new solution instance for next test to reset all fields
        solution = new RecoverBinarySearchTree();

        System.out.println("Test Case 2: [3,1,4,null,null,2]");
        System.out.println("Before recovery:");
        TreeNode test2 = new TreeNode(3);
        test2.left = new TreeNode(1);
        test2.right = new TreeNode(4);
        test2.right.left = new TreeNode(2);
        TreeNode.levelOrderTraversal(test2);
        System.out.println("\nAfter recovery:");
        solution.recoverTree(test2);
        TreeNode.levelOrderTraversal(test2);
        System.out.println("\n");
    }
} 
