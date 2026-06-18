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

    Map<Node,Node> translator = new HashMap<>();

    public Node cloneGraph(Node node) {

        if(node == null) return null;

        if(translator.containsKey(node)) return translator.get(node);

        Node n = new Node(node.val);
        translator.putIfAbsent(node,n);

        for(Node branch: node.neighbors){
            n.neighbors.add(cloneGraph(branch));
        }

        return n;
    }
}