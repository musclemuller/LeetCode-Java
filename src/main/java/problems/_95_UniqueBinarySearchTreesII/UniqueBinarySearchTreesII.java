package problems._95_UniqueBinarySearchTreesII;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import Helper.TreeNode;

public class UniqueBinarySearchTreesII {
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
