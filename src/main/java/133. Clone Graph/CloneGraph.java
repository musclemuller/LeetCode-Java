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
