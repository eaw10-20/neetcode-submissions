/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int counter = 0;
        ListNode node = head;
        while(node != null){
            counter++;
            node = node.next;
        }
        //[1,3,6,3,1] n=2
        if(counter == n) return head.next;
        counter -= n;
        node = head;
        while(counter > 1){
            node = node.next;
            counter--;
        }
        node.next = node.next.next;
        return head;
    }
}
