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
    public ListNode reverseKGroup(ListNode head, int k) {
        // split the chain for k nodes
        if (head == null) {
            return head;
        }

        var chainHead = head;
        var chainTail = head;
        for (int i = 1; i < k; ++i) {
            chainTail = chainTail.next;
            if (chainTail == null) {
                return chainHead;
            }
        }

        var nextChainHead = chainTail.next;
        chainTail.next = null;

        var newChainHead = reverse(chainHead);
        chainHead.next = reverseKGroup(nextChainHead, k);
        
        return newChainHead;
    }

    // private void printChain(ListNode head) {
    //     System.err.print("[");
    //     while (head != null){
    //         System.err.print(head.val + ",");
    //         head = head.next;
    //     }
    //     System.err.println("]");
    // }

    private ListNode reverse(ListNode head) {
        ListNode curr = head, prev = null, next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
