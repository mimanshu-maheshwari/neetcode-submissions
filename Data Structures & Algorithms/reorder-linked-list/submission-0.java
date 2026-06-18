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
        if (head == null || head.next == null) {
            return;
        }
        var start = head;
        var middle = head;
        var end = head;
        ListNode split = null;
        while (end != null && end.next != null) {
            split = middle;
            middle = middle.next;
            end = end.next.next;
        }
        split.next = null;
        middle = reverse(middle);
        merge(start, middle);
    }
    private ListNode reverse(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode prev = null, next = null, curr = head;
        while (curr != null) { 
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    private void merge(ListNode l1, ListNode l2) {
        var curr = l1;
        l1 = l1.next;
        while (l1 != null || l2 != null) {
            if (l2 != null) {
                curr.next = l2;
                l2 = l2.next;
                curr = curr.next;
            }
            if (l1 != null) {
                curr.next = l1;
                l1 = l1.next;
                curr = curr.next;
            }
        }
    }
}
