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
        ListNode p1_tail = null, p2_head = null, p2_tail = null, p3_head = null;
        var curr = head; 
        for (int i = 1; i < left; ++i) {
            p1_tail = curr;
            curr = curr.next;
        }
        p2_head = curr;
        for (int i = left; i < right && curr.next != null; ++i) {
            curr = curr.next;
        }
        p2_tail = curr;
        p3_head = curr.next;

        if (p1_tail != null) {
            p1_tail.next = null;
        }
        p2_tail.next = null;
        reverse(p2_head);
        p2_head.next = p3_head;
        if (p1_tail != null){
            p1_tail.next = p2_tail;
        } else {
            return p2_tail;
        }
        return head;
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