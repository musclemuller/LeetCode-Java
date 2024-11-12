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
