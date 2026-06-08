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
        var head = new ListNode();
        var cur = head;
        int carry = 0;
        while (l1 != null || l2 != null){ 
            int val = 0;
            if (l2 != null) {
                val += l2.val;
                l2 = l2.next;
            }
            if (l1 != null){
                val += l1.val;
                l1 = l1.next;
            }
            val += carry;
            carry = val / 10;
            var newNode = new ListNode(val % 10);
            cur.next = newNode;
            cur = cur.next;
        }
        if (carry > 0) {
            cur.next = new ListNode(carry);
        }
        return head.next;
    }
}
