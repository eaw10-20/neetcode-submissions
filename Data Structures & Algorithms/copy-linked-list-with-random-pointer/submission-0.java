/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;

        Map<Node,Node> map = new HashMap<>();
        Node node = head, first, pointer;
        
        while(node != null){
            map.put(node,new Node(node.val));
            node = node.next;
        } 
        first = map.get(head);
        pointer = first;
        node = head;
        while(node != null){
            pointer.next = map.get(node.next);
            pointer.random = map.get(node.random);
            pointer = pointer.next;
            node = node.next;
        }
        return first;
    }
}
