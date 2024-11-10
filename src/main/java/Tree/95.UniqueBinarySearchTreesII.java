// Given an integer n, return all the structurally unique BST's (binary search trees), which has exactly n nodes of unique values from 1 to n. 
// Return the answer in any order.
// Example 1:
// Input: n = 3
// Output: [[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
// Example 2:
// Input: n = 1
// Output: [[1]]
// Constraints:
// 1 <= n <= 8

package Tree;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import Helper.TreeNode;

class UniqueBinarySearchTreesII {
    public List<TreeNode> generateTrees(int n) {
        return build(1, n); 
    }

    List<TreeNode> build(int lo, int hi) {
        List<TreeNode> res = new ArrayList<>();
        if (lo > hi) {
            res.add(null);
            return res;
        }

        for (int i = lo; i <= hi; i++) {
            List<TreeNode> left = build(lo, i - 1);
            List<TreeNode> right = build(i + 1, hi);
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    res.add(root);
                }
            }
        }
        
        return res;
    }

    public static void main(String[] args) {
        UniqueBinarySearchTreesII s = new UniqueBinarySearchTreesII();
        List<TreeNode> tree = s.generateTrees(3);
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        for (TreeNode root : tree) {
            String jsonString = "";
            try {
                jsonString = mapper.writeValueAsString(root);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            System.out.println(jsonString);
        }
    }
}
