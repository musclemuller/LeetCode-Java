package problems._71_SimplifyPath;

import java.util.Stack;

public class SimplifyPath {
    public String simplifyPath(String path) {
        String[] parts = path.split("/");
        Stack<String> stk = new Stack<>();

        for (String part : parts) {
            if (part.isEmpty() || part.equals(".")) {
                continue;
            }
            if (part.equals("..")) {
                if (!stk.isEmpty()) stk.pop();
                continue;
            }
            stk.push(part);
        }

        String res = "";
        while (!stk.isEmpty()) {
            res = "/" + stk.pop() + res;
        }
        return res.isEmpty() ? "/" : res;
    }



    public static void main(String[] args) {
        SimplifyPath solution = new SimplifyPath();
        // Test Case 1: Basic path with trailing slash
        String path1 = "/home/";
        System.out.println("Input: path = \"" + path1 + "\"");
        System.out.println("Output: \"" + solution.simplifyPath(path1) + "\"");
        System.out.println("Expected: \"/home\"");
        System.out.println();

        // Test Case 2: Multiple consecutive slashes
        String path2 = "/home//foo/";
        System.out.println("Input: path = \"" + path2 + "\"");
        System.out.println("Output: \"" + solution.simplifyPath(path2) + "\"");
        System.out.println("Expected: \"/home/foo\"");
        System.out.println();

        // Test Case 3: Path with parent directory
        String path3 = "/home/user/Documents/../Pictures";
        System.out.println("Input: path = \"" + path3 + "\"");
        System.out.println("Output: \"" + solution.simplifyPath(path3) + "\"");
        System.out.println("Expected: \"/home/user/Pictures\"");
        System.out.println();

        // Test Case 4: Going up from root
        String path4 = "/../";
        System.out.println("Input: path = \"" + path4 + "\"");
        System.out.println("Output: \"" + solution.simplifyPath(path4) + "\"");
        System.out.println("Expected: \"/\"");
        System.out.println();

        // Test Case 5: Path with valid periods
        String path5 = "/.../a/../b/c/../d/./";
        System.out.println("Input: path = \"" + path5 + "\"");
        System.out.println("Output: \"" + solution.simplifyPath(path5) + "\"");
        System.out.println("Expected: \"/.../b/d\"");
        System.out.println();
    }
} 