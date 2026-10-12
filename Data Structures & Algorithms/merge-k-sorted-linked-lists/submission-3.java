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
        final int len = lists.length;
        if (lists == null || len == 0){ 
            return null;
        }
        int end = len - 1;
        while (end > 0) {
            int start = 0;
            while (start < end) {
                lists[start] = mergeTwoLists(lists[start], lists[end]);
                start++;
                end--;
            }
        }
        return lists[0];
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
                break;
            } else {
                curr.next = l2;
                break;
            }
            curr = curr.next;
        }

        var ret = dummy.next;
        dummy.next = null;
        return ret;
    }
}
