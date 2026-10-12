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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0){ 
            return null;
        }
        var result = lists[0];
        for (int i = 1; i < lists.length; i++) {
            result = mergeTwoLists(result, lists[i]);
        }
        return result;
    }
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        var dummy = new ListNode(-1);
        var curr = dummy;
        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    curr.next = l1;
                    l1 = l1.next;
                } else {
                    curr.next = l2;
                    l2 = l2.next;
                }
            } else if (l2 == null) {
                curr.next = l1;
                l1 = null;
            } else {
                curr.next = l2;
                l2 = null;
            }
            curr = curr.next;
        }

        var ret = dummy.next;
        dummy.next = null;
        return ret;
    }
}
