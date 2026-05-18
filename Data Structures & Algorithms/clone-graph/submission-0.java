/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    Map<Integer, Node> clonedNodes = new HashMap<>();
    public Node cloneGraph(Node node) {
        if (node == null) {
            return node;
        }
        
        int val = node.val;
        if (!clonedNodes.containsKey(val)) {
            clonedNodes.computeIfAbsent(val, k -> new Node(val));
        } else {
            return clonedNodes.get(val);
        }
        Node newNode = clonedNodes.get(val);
        for (Node n : node.neighbors) {
            newNode.neighbors.add(cloneGraph(n));
        }
        return newNode;
    }
}