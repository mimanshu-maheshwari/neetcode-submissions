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
        if (head == null) {
            return head;
        }
        
        var end = head;
        for (int i = 0; i < n; ++i) {
            end = end.next;
        }

        ListNode dummy = new ListNode(-1, head);
        var curr = dummy;
        while (end != null){
            end = end.next;
            curr = curr.next;
        }
        var next = curr.next;
        curr.next = next.next;
        next.next = null;
        return dummy.next;
    }
}
