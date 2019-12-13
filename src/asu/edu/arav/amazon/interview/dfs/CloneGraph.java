package asu.edu.arav.amazon.interview.dfs;

import java.util.*;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/clone-graph/
 */
public class CloneGraph {
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
        }

        public Node(int _val, List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return val == node.val &&
                    Objects.equals(neighbors, node.neighbors);
        }

        @Override
        public int hashCode() {
            return Objects.hash(val, neighbors);
        }
    }

    // global Hashmap which stores the already cloned graph node
    Map<Node, Node> nodeClonedMap = new HashMap<Node, Node>();

    // lets try the DFS version first chalo - O(N)
    public Node cloneGraph(Node node) {
        if (node == null) {
            return node;
        }
        // if has been alrealy made the chill dude dont cause cycles right
        // why ?? will get to know soon I guess
        // its because in  undirected edge B will node call for A, then A will do call for B
        // want to stuck in infinite cycles?? no right !!!!
        if (nodeClonedMap.containsKey(node)) {
            return nodeClonedMap.get(node);
        }

        Node clonedNode = new Node(node.val, new ArrayList<>());
        // put this is hashmap dude
        nodeClonedMap.put(node, clonedNode);
        for (Node childNode : node.neighbors) {
            clonedNode.neighbors.add(cloneGraph(childNode));
        }
        // this state ment i enough for the source as the Graph is totally connected
        return clonedNode;
    }
}
