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
    public ListNode reverseList(ListNode head) {
        if (head == null){
            return head;
        }
        return reverse(head, null);
    }
    public ListNode reverse(ListNode node, ListNode parent) {
        if (node == null) {
            return parent;
        }
        ListNode next = node.next;
        node.next = parent;
        return reverse(next, node);
    }
}
