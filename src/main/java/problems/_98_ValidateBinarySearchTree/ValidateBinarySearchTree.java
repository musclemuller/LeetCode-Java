package problems._98_ValidateBinarySearchTree;

import Helper.TreeNode;

public class ValidateBinarySearchTree {
    boolean isValid;

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) return true;
        if (min != null && root.val <= min.val) return false;
        if (max != null && root.val >= max.val) return false;
        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }

    public static void main(String[] args) {
        ValidateBinarySearchTree solution = new ValidateBinarySearchTree();

        // Test Case 1: [2,1,3]
        System.out.println("Test Case 1:");
        TreeNode root1 = new TreeNode(2);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(3);
        System.out.println("Input: root = [2,1,3]");
        System.out.println("Output: " + solution.isValidBST(root1));
        // Expected Output: true

        // Test Case 2: [5,1,4,null,null,3,6]
        System.out.println("\nTest Case 2:");
        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(4);
        root2.right.left = new TreeNode(3);
        root2.right.right = new TreeNode(6);
        System.out.println("Input: root = [5,1,4,null,null,3,6]");
        System.out.println("Output: " + solution.isValidBST(root2));
        // Expected Output: false
    }
} 
