// Given a reference of a node in a connected undirected graph.
// Return a deep copy (clone) of the graph.
// Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.
// class Node {
//     public int val;
//     public List<Node> neighbors;
// }

// Test case format:
// For simplicity, each node's value is the same as the node's index (1-indexed). 
// For example, the first node with val == 1, the second node with val == 2, and so on. 
// The graph is represented in the test case using an adjacency list.
// An adjacency list is a collection of unordered lists used to represent a finite graph. 
// Each list describes the set of neighbors of a node in the graph.
// The given node will always be the first node with val = 1. You must return the copy of the given node as a reference to the cloned graph.

// Example 1: ../image/133.png
// Input: adjList = [[2,4],[1,3],[2,4],[1,3]]
// Output: [[2,4],[1,3],[2,4],[1,3]]
// Explanation: There are 4 nodes in the graph.
// 1st node (val = 1)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
// 2nd node (val = 2)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).
// 3rd node (val = 3)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
// 4th node (val = 4)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).

// Example 2:
// Input: adjList = [[]]
// Output: [[]]
// Explanation: Note that the input contains one empty list. The graph consists of only one node with val = 1 and it does not have any neighbors.

// Example 3:
// Input: adjList = []
// Output: []
// Explanation: This an empty graph, it does not have any nodes.
 
// Constraints:
// The number of nodes in the graph is in the range [0, 100].
// 1 <= Node.val <= 100
// Node.val is unique for each node.
// There are no repeated edges and no self-loops in the graph.
// The Graph is connected and all nodes can be visited starting from the given node.



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Helper.Node;

public class CloneGraph {
    Map<Node, Node> originToClone;

    public Node cloneGraph(Node node) {
        originToClone = new HashMap<>();
        traverse(node);
        return originToClone.get(node);
    }

    void traverse(Node node) {
        if (node == null) return;
        if (originToClone.containsKey(node)) {
            return;
        }
        originToClone.put(node, new Node(node.val));
        for (Node nbr : node.neighbors) {
            traverse(nbr);
            Node clone = originToClone.get(nbr);
            originToClone.get(node).neighbors.add(clone);
        }
    }

    public static void main(String[] args) {
        // Create test case for Example 1
        // Input graph: [[2,4],[1,3],[2,4],[1,3]]
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        // Clone the graph
        CloneGraph cloneGraph = new CloneGraph();
        Node clonedGraph = cloneGraph.cloneGraph(node1);

        // Print result to verify (customize output as needed)
        System.out.println("Original node1 neighbors: " + getNeighborValues(node1));
        System.out.println("Cloned node1 neighbors: " + getNeighborValues(clonedGraph));
    }

    // Helper function to get neighbor values for verification
    static List<Integer> getNeighborValues(Node node) {
        List<Integer> neighborValues = new ArrayList<>();
        for (Node neighbor : node.neighbors) {
            neighborValues.add(neighbor.val);
        }
        return neighborValues;
    }
}
