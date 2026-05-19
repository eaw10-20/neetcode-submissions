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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null) return list2;
        if(list2 == null) return list1;

        ListNode head, l1, l2, node;

        if(list2.val < list1.val){
            head = list2;
            l2 = list2.next;
            l1 = list1;
        }
        else{
            head = list1;
            l1 = list1.next;
            l2 = list2;
        } 

        node = head;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                node.next = l1;
                l1 = l1.next;
            }else{
                node.next = l2;
                l2 = l2.next;
            }
            node = node.next;
        }

        if(l1 == null) node.next = l2;
        else node.next = l1;

        return head;
    }
}