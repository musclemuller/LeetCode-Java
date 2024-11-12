# [Binary Tree Inorder Traversal](https://leetcode.com/problems/binary-tree-inorder-traversal/description/)

Given the root of a binary tree, return the inorder traversal of its nodes' values.

### Examples

#### Example 1:
- **Input:** `root = [1,null,2,3]`
- **Output:** `[1,3,2]`

#### Example 2:
- **Input:** `root = [1,2,3,4,5,null,8,null,null,6,7,9]`
- **Output:** `[4,2,6,5,7,1,3,9,8]`

#### Example 3:
- **Input:** `root = []`
- **Output:** `[]`

#### Example 4:
- **Input:** `root = [1]`
- **Output:** `[1]`

### Constraints:
- The number of nodes in the tree is in the range `[0, 100]`.
- `-100 <= Node.val <= 100`

### Follow-Up:
A recursive solution is straightforward. Can you solve it iteratively?

### Solution

### Approach 3: Morris Traversal

In this method, we use a new data structure called a **Threaded Binary Tree**. The Morris Traversal strategy is as follows:

#### Steps:
1. **Initialize** `current` as the root.
2. **While** `current` is not `NULL`:
   - If `current` does **not have a left child**:
     - a. **Add** `current`'s value to the traversal result.
     - b. Move to the **right**, i.e., set `current = current.right`.
   - If `current` **has a left child**:
     - a. In `current`'s left subtree, locate the **rightmost node**.
     - b. Make `current` the **right child** of this rightmost node.
     - c. Move to the **left child**, i.e., set `current = current.left`.

#### Example Walkthrough:


          1
        /   \
       2     3
      / \   /
     4   5 6
First, 1 is the root, so initialize 1 as current, 1 has left child which is 2, the current's left subtree is

         2
        / \
       4   5
So in this subtree, the rightmost node is 5, then make the current(1) as the right child of 5. Set current = current.left (current = 2).
The tree now looks like:

         2
        / \
       4   5
            \
             1
              \
               3
              /
             6
For current 2, which has left child 4, we can continue with the same process as we did above

        4
         \
          2
           \
            5
             \
              1
               \
                3
               /
              6
then add 4 because it has no left child, then add 2, 5, 1, 3 one by one, for node 3 which has left child 6, do the same as above.
Finally, the inorder traversal is [4,2,5,1,6,3].

#### Complexity Analysis

- **Time Complexity:** \( O(n) \)
  
  To prove that the time complexity is \( O(n) \), we need to analyze the cost of finding the predecessor nodes for all nodes in the binary tree. Although it might seem that finding each node's predecessor could require \( O(\log n) \) operations due to the tree's height, the total complexity remains \( O(n) \). This is because a binary tree with \( n \) nodes has \( n - 1 \) edges, and each edge is processed at most twice: once to locate a node and once to find its predecessor. Thus, the overall complexity is \( O(n) \).

- **Space Complexity:** \( O(1) \)
  
  The only additional space used is the ArrayList to store the traversal output, which does not contribute to the space complexity. Therefore, the algorithm operates with constant auxiliary space.
