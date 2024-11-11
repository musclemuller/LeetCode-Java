// Given the root of a binary tree, return the inorder traversal of its nodes' values.
// Example 1:
// Input: root = [1,null,2,3]
// Output: [1,3,2]
// Explanation:

// Example 2:
// Input: root = [1,2,3,4,5,null,8,null,null,6,7,9]
// Output: [4,2,6,5,7,1,3,9,8]
// Explanation:

// Example 3:
// Input: root = []
// Output: []
// Example 4:
// Input: root = [1]
// Output: [1]

// Constraints:
// The number of nodes in the tree is in the range [0, 100].
// -100 <= Node.val <= 100

// Follow up: Recursive solution is trivial, could you do it iteratively?

import Helper.TreeNode;
import java.util.*;

public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        traverse(res, root);
        return res;
    }

    // recursive way
    void traverse(List<Integer> res, TreeNode root) {
        if (root == null) return;
        traverse(res, root.left);
        res.add(root.val);
        traverse(res, root.right);
    }

    // iteratively with stack
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }

    // morris traversal
    //     Step 1: Initialize current as root

    // Step 2: While current is not NULL,

    // If current does not have left child

    //     a. Add current’s value

    //     b. Go to the right, i.e., current = current.right

    // Else

    //     a. In current's left subtree, make current the right child of the rightmost node

    //     b. Go to this left child, i.e., current = current.left
    // For example:


    //           1
    //         /   \
    //        2     3
    //       / \   /
    //      4   5 6
    // First, 1 is the root, so initialize 1 as current, 1 has left child which is 2, the current's left subtree is

    //          2
    //         / \
    //        4   5
    // So in this subtree, the rightmost node is 5, then make the current(1) as the right child of 5. Set current = current.left (current = 2).
    // The tree now looks like:

    //          2
    //         / \
    //        4   5
    //             \
    //              1
    //               \
    //                3
    //               /
    //              6
    // For current 2, which has left child 4, we can continue with the same process as we did above

    //         4
    //          \
    //           2
    //            \
    //             5
    //              \
    //               1
    //                \
    //                 3
    //                /
    //               6
    // then add 4 because it has no left child, then add 2, 5, 1, 3 one by one, for node 3 which has left child 6, do the same as above.
    // Finally, the inorder traversal is [4,2,5,1,6,3].
    public List<Integer> inorderTraversal3(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode curr = root;
        TreeNode pre;

        while (curr != null) {
            if (curr.left == null) {
                res.add(curr.val);
                curr = curr.right; // move to next right node
            } else { // has a left subtree
                pre = curr.left;
                // Find the rightmost node in the left subtree, or the node that already points to curr
                while (pre.right != null && pre.right != curr) {
                    pre = pre.right;
                }
                
                if (pre.right == null) { 
                    // Establish a temporary thread back to the current node
                    pre.right = curr;
                    curr = curr.left;
                } else { 
                    // The thread already exists, which means we've returned to curr after visiting left subtree
                    pre.right = null; // Restore the tree
                    res.add(curr.val); // Add the current node to result
                    curr = curr.right; // Move to the right subtree
                }
            }
        }
        
        return res;
    }

    public static void main(String[] args) {
        BinaryTreeInorderTraversal s = new BinaryTreeInorderTraversal();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        List<Integer> res1 = s.inorderTraversal1(root);
        List<Integer> res2 = s.inorderTraversal2(root);
        List<Integer> res3 = s.inorderTraversal3(root);
        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
    }
}
