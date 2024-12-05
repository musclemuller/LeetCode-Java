package Helper;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
    // Helper method to check if a node is a leaf node
    private static boolean isLeaf(TreeNode node) {
        return node != null && node.left == null && node.right == null;
    }

    // Modified preorder traversal
    public static void preorderTraversal(TreeNode root) {
        if (root == null) {
            System.out.print("null ");
            return;
        }
        System.out.print(root.val + " ");
        if (!isLeaf(root)) {
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
    }

    // Modified inorder traversal 
    public static void inorderTraversal(TreeNode root) {
        if (root == null) {
            System.out.print("null ");
            return;
        }
        if (!isLeaf(root)) {
            inorderTraversal(root.left);
        }
        System.out.print(root.val + " ");
        if (!isLeaf(root)) {
            inorderTraversal(root.right);
        }
    }

    // Modified postorder traversal
    public static void postorderTraversal(TreeNode root) {
        if (root == null) {
            System.out.print("null ");
            return;
        }
        if (!isLeaf(root)) {
            postorderTraversal(root.left);
            postorderTraversal(root.right);
        }
        System.out.print(root.val + " ");
    }

    // Level order traversal (breadth-first)
    public static void levelOrderTraversal(TreeNode root) {
        if (root == null) {
            System.out.print("null ");
            return;
        }

        java.util.Queue<TreeNode> queue = new java.util.LinkedList<>();
        queue.offer(root);
        int nodesInCurrentLevel = 1;
        int nodesInNextLevel = 0;
        boolean hasNextLevelNodes = false;
        TreeNode lastNodeInLevel = root;
        TreeNode lastNonNullNode = root;

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            nodesInCurrentLevel--;

            if (node != null) {
                System.out.print(node.val + " ");
                lastNonNullNode = node;
                queue.offer(node.left);
                queue.offer(node.right);
                if (node.left != null || node.right != null) {
                    hasNextLevelNodes = true;
                }
            } else {
                if (lastNonNullNode != lastNodeInLevel) {
                    System.out.print("null ");
                }
            }

            nodesInNextLevel += 2;

            if (nodesInCurrentLevel == 0) {
                if (!hasNextLevelNodes) {
                    break;
                }
                nodesInCurrentLevel = nodesInNextLevel;
                nodesInNextLevel = 0;
                hasNextLevelNodes = false;
                lastNodeInLevel = lastNonNullNode;
            }
        }
    }
}
