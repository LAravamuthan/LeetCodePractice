package asu.edu.marisol;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class LowestCommonAncestorofaBinaryTreeIII {

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    }

    /**
     * Simple way with Set.
     *
     * @time-complexity - O (h).
     * @space-complexity - O (h) - height of the tree mostly.
     */
    public Node lowestCommonAncestor(Node p, Node q) {
        Set<Node> p_parents = new HashSet<>();
        while (p != null) {
            p_parents.add(p);
            p = p.parent;
        }

        while (!p_parents.contains(q)) {
            q = q.parent;
        }

        return q;
    }


    /**
     * Simple way without extra space.
     *
     * @time-complexity - O (h).
     * @space-complexity - O (h) - height of the tree mostly.
     */
    public Node lowestCommonAncestor2(Node p, Node q) {
        Node a = p;
        Node b = q;

        while (a != b) {
            a = a == null ? q : a.parent;
            b = b == null ? p : q.parent;
        }

        return a;
    }

}
