package problems._100_SameTree;

import Helper.TreeNode;

public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if ((p == null && q != null) || (p != null && q == null)) return false;
        if (p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        SameTree solution = new SameTree();
        
        // Test Case 1: [1,2,3] vs [1,2,3]
        System.out.println("Test Case 1: [1,2,3] vs [1,2,3]");
        System.out.println("Expected: true");
        TreeNode p1 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode q1 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        System.out.println("Output: " + solution.isSameTree(p1, q1));
        System.out.println();

        // Test Case 2: [1,2] vs [1,null,2]  
        System.out.println("Test Case 2: [1,2] vs [1,null,2]");
        System.out.println("Expected: false");
        TreeNode p2 = new TreeNode(1, new TreeNode(2), null);
        TreeNode q2 = new TreeNode(1, null, new TreeNode(2));
        System.out.println("Output: " + solution.isSameTree(p2, q2));
        System.out.println();

        // Test Case 3: [1,2,1] vs [1,1,2]
        System.out.println("Test Case 3: [1,2,1] vs [1,1,2]");
        System.out.println("Expected: false");
        TreeNode p3 = new TreeNode(1, new TreeNode(2), new TreeNode(1));
        TreeNode q3 = new TreeNode(1, new TreeNode(1), new TreeNode(2));
        System.out.println("Output: " + solution.isSameTree(p3, q3));
    }
} 
