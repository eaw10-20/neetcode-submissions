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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode node = head;
        ListNode prev = null;
        int carry = 0;
        //add both lists
        while(l1 != null && l2 != null){
            node.val = (l1.val + l2.val + carry)%10;
            carry = (l1.val + l2.val + carry)/10;
            l1 = l1.next;
            l2 = l2.next;
            prev = node;
            node.next = new ListNode();
            node = node.next;
        }
        //add remaining list
        while(l1 != null){
            node.val = (l1.val + carry)%10;
            carry = (l1.val + carry)/10;
            l1 = l1.next;
            prev = node;
            node.next = new ListNode();
            node = node.next;
        }
        while(l2 != null){
            node.val = (l2.val + carry)%10;
            carry = (l2.val + carry)/10;
            l2 = l2.next;
            prev = node;
            node.next = new ListNode();
            node = node.next;
        }

        if(carry != 0) node.val = carry;
        else prev.next = null;

        return head;
    }
}
