package asu.edu.arav.amazon.interview.bfs;

import java.util.*;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/clone-graph/
 */


// this solution is the BFS solution of the Clone Graph solution. lets see How I do this
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

    Map<Node, Node> nodeClonedMap = new HashMap<Node, Node>();

    // lets try the DFS version first chalo - O(N)
    public Node cloneGraph(Node node) {

        // in here to BFS type search in the Graph and clone the Graph lets see how we
        // go about this, First we do source  creation then we do the creation its neighors in
        // bfs order, lets see how it is
        if (node == null) {
            return node;
        }
        // BFS data store
        Queue<Node> queue = new ArrayDeque<Node>();
        // make the clone of the source node
        Node clonedNode = new Node(node.val, new ArrayList<>());
        // put the clonedNode to be used later others if they have edge this
        // cloned node
        nodeClonedMap.put(node, clonedNode);
        queue.add(node);

        while (!queue.isEmpty()){
            // get the node to process
            Node curNode = queue.poll();
            // obtain the cloned node of the current node to add its neighbor's clone
            Node clonedCurNode = nodeClonedMap.get(curNode);
            for(Node neighbor : curNode.neighbors){
                // cloned neighbor node
                Node clonedNeigbor = null;
                if(!nodeClonedMap.containsKey(neighbor)){
                    // if not avaiable in the Map that means clone it
                    clonedNeigbor = new Node(neighbor.val, new ArrayList<>());
                    // this step will make it available for next nodes and also prevents cycles
                    nodeClonedMap.put(neighbor, clonedNeigbor);
                    // important step is the fact the we need process this cloned node's neighors
                    queue.offer(neighbor);// put the origin not the cloned // important
                }
                clonedCurNode.neighbors.add(nodeClonedMap.get(neighbor));
            }
        }

        return clonedNode;
    }
}
