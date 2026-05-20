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
    public void reorderList(ListNode head) {
        if(head == null) return;
        //iterate through list to get length
        ListNode fast = head, slow = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        //split list in half
        ListNode second = slow.next;
        slow.next = null;
        //reverse second half
        ListNode node = second;
        ListNode prev = null, next = null;
        while(node != null){
            next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        second = prev;
        //insert second list into first
        node = head;
        ListNode temp1;
        while(second != null){
            temp1 = node.next;
            node.next = second;
            node = node.next;
            second = temp1;
        }
        
    }
}
