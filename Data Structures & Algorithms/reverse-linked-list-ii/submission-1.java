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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0, head);
        ListNode p1_tail = dummy;
        
        for (int i = 1; i < left; i++) {
            p1_tail = p1_tail.next;
        }
        
        ListNode p2_head = p1_tail.next;
        ListNode curr = p2_head;
        for (int i = left; i < right; i++) {
            curr = curr.next;
        }
        ListNode p2_tail = curr;
        ListNode p3_head = curr.next;
        
        p2_tail.next = null;
        reverse(p2_head);
        p1_tail.next = p2_tail;
        p2_head.next = p3_head;
        
        return dummy.next;
    }

    public ListNode reverse(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }
        ListNode prev = null, next = null, curr = node;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}