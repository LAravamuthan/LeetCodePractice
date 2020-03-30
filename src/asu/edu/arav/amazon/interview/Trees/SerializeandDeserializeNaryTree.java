package asu.edu.arav.amazon.interview.Trees;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/serialize-and-deserialize-n-ary-tree/
 */
public class SerializeandDeserializeNaryTree {

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    class WrapperInt {
        private int val;

        public WrapperInt(int val) {
            this.val = val;
        }

        public int getVal() {
            return this.val;
        }

        public void increment() {
            this.val++;
        }
    }

    // Encodes a tree to a single string.
    public String serialize(Node root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    public void serialize(Node node, StringBuilder sb) {
        if (node == null) return;
        sb.append((char) (node.val + '0'));
        for (Node child : node.children) {
            serialize(child, sb);
        }
        sb.append('#');
    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if (data.isEmpty()) return null;
        return deserialize(data, new WrapperInt(0));
    }

    public Node deserialize(String data, WrapperInt wInt) {
        if (wInt.getVal() == data.length()) return null;
        Node node = new Node(data.charAt(wInt.getVal()) - '0', new ArrayList<>());
        wInt.increment();
        while (data.charAt(wInt.getVal()) != '#') {
            node.children.add(deserialize(data, wInt));
        }
        wInt.increment();
        return node;
    }
}
