package asu.edu.marisol;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class CloneGraph {

    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    /**
     * DFS approach.
     *
     * @time-complexity - O (N + M) - all the nodes.
     * @space-complexity - O (n) - all the nodes.
     */
    public Node cloneGraph(Node node) {
        if (node == null) return null;

        this.visited = new HashMap<>();
        return dfsClone(node);
    }

    private Map<Node, Node> visited;

    private Node dfsClone(Node node) {
        if (!visited.containsKey(node)) {
            visited.put(node, new Node(node.val));
            for (Node child : node.neighbors) {
                if (!visited.containsKey(child)) {
                    visited.put(child, dfsClone(child));
                }
                visited.get(node).neighbors.add(visited.get(child));
            }
        }

        return visited.get(node);
    }


    /**
     * DFS approach.
     *
     * @time-complexity - O (N + M) - all the nodes.
     * @space-complexity - O (n) - all the nodes.
     */
    public Node cloneGraph2(Node node) {
        if (node == null) return node;
        if (visited2.containsKey(node)) return visited2.get(node);

        Node clonedNode = new Node(node.val);
        visited2.put(node, clonedNode);

        for (Node child : node.neighbors) {
            clonedNode.neighbors.add(cloneGraph2(child));
        }
        return visited2.get(node);
    }

    private Map<Node, Node> visited2 = new HashMap<>();


    /**
     * BFS approach.
     *
     * @time-complexity - O (N + M) - all the nodes.
     * @space-complexity - O (N) - all the nodes.
     */
    public Node cloneGraph3(Node node) {
        if (node == null) return node;

        Map<Node, Node> visited = new HashMap<>();

        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);

        visited.put(node, new Node(node.val));

        while(!queue.isEmpty()) {
            Node n = queue.remove();
            for (Node child : n.neighbors) {
                if(!visited.containsKey(child)) {
                    visited.put(child, new Node(child.val));
                    queue.add(child);
                }
                visited.get(n).neighbors.add(visited.get(child));
            }
        }

        return visited.get(node);
    }

    /**
     * DFS approach.
     *
     * @time-complexity - O (N + M) - all the nodes.
     * @space-complexity - O (N) - all the nodes.
     */
    public Node cloneGraph4(Node node) {
        if (node == null) return null;

        if (visitedNodeMap.containsKey(node)) return visitedNodeMap.get(node);

        Node newNode = new Node(node.val);
        visitedNodeMap.put(node, newNode);

        for (Node neighbor : node.neighbors) {
            newNode.neighbors.add(cloneGraph4(neighbor));
        }

        return visitedNodeMap.get(node);
    }

    private Map<Node, Node> visitedNodeMap = new HashMap<>();



    /**
     * BFS approach.
     *
     * @time-complexity - O (N + M) - all the nodes.
     * @space-complexity - O (N) - all the nodes.
     */
    public Node cloneGraph5(Node node) {
        if (node == null) return null;
        Map<Node, Node> visitedNodeMap = new HashMap<>();

        Queue<Node> queue = new ArrayDeque<>();

        visitedNodeMap.put(node, new Node(node.val));
        queue.add(node);

        while (!queue.isEmpty()) {
            Node toClone = queue.poll();

            for (Node neighbor : toClone.neighbors) {
                if (!visitedNodeMap.containsKey(neighbor)) {
                    visitedNodeMap.put(neighbor, new Node(neighbor.val));
                    queue.add(neighbor);
                }
                visitedNodeMap.get(toClone).neighbors.add(visitedNodeMap.get(neighbor));
            }
        }

        return visitedNodeMap.get(node);
    }
}
